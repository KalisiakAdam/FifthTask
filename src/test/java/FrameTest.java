import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class FrameTest {

    private Frame actual;
    private Frame previous;

    @Before
    public void setUp() {
        previous = new Frame(10,0,0, null);
        actual = new Frame(10,0,0, previous);
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
    public void isBonusThreeTen() {
        actual.setBonusTen(true);
        previous.setBonusTen(true);

        assertTrue(actual.ifBonusThreeTen());
    }

    @Test
    public void isTotalPinsInFrameWithoutLastExtraPins() {
        actual.setFirstPins(5);
        actual.setSecondPins(4);

        assertThat(actual.totalPinsInFrame(), is(9));
    }

    @Test
    public void isItBonusThreeTimesTenPlusFirstPins() {
        actual.setBonusThreeTen(true);
        previous.setBonusThreeTen(true);

        assertThat(actual.actualFrameScore(),is(40));
    }

    @Test
    public void isItBonusTwoTimesTen() {
        actual.setBonusThreeTen(false);
        previous.setBonusThreeTen(false);
        previous.setBonusTen(true);

        assertThat(actual.actualFrameScore(), is(20));
    }

    @Test
    public void isItBonusTenInTwoPinsExtraPointsFromFirstPins() {
        previous.setBonusTenInTwoPins(true);

        assertThat(actual.actualFrameScore(), is(20));
    }

    @Test
    public void isItNoBonusesOnlyFirstAndSecondPins() {
        previous.setBonusTen(false);
        previous.setBonusTenInTwoPins(false);

        assertThat(actual.actualFrameScore(), is(10));
    }
}
