import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class FrameTest {

    private Frame actual;
    private Frame previous;

    @Before
    public void setUp() {
        previous = new Frame(10,0,0, null);
        actual = new Frame(10,0,1,previous);
    }

    @Test
    public void isBonusPinsIsTen_WhenFirstPinsInFrameIsTen() {
        assertTrue(actual.ifBonusTen());
    }

    @Test
    public void isBonusPinsIsTen_WhenSumOfPinsInFrameIsTen() {
        assertTrue(actual.ifBonusTenInTwoPins());
    }

    @Test
    public void isBonusThreeTen () {
        actual.setBonusTen(true);
        previous.setBonusTen(true);
        assertTrue(actual.ifBonusThreeTen());
    }

    @Test
    public void isTotalPinsInFrameWithOutLastExtraPins() {
        actual.setFirstPins(5);
        actual.setSecondPins(4);
        assertThat(actual.totalPinsInFrame(), is(9));
    }

    @Test
    public void isBonusTenIsTrueInThisFrame_WhenThereIsPreviousFrame() {
        actual.setBonusTen(true);
        actual.pinsBonusesManagement();
        assertThat(actual.isBonusTen(), is(true));
    }

    @Test
    public void isBonusThreeTenIsTrueInThisFrame_WhenThereIsPreviousFrame() {
        actual.setBonusTen(true);
        actual.setBonusThreeTen(true);
        actual.pinsBonusesManagement();
        assertThat(actual.isBonusThreeTen(), is(true));
    }

    @Test
    public void isBonusTenInTwoPinsTrueInThisFrame_WhenThereIsPreviousFrame() {
        actual.setBonusTen(false);
        actual.setBonusTenInTwoPins(true);
        actual.pinsBonusesManagement();
        assertThat(actual.isBonusTenInTwoPins(), is(true));
    }
}
