import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class RandomNumberTest {

    private RandomNumber number;

    @Before
    public void setUp() {
        number = new RandomNumber();
    }

    @Test
    public void shouldGenerateNumberFromOneToTenFirstPin() {
        int low = 0;
        int high = 10;
        assertThat(number.getFirstPins(), allOf(greaterThanOrEqualTo(low),lessThanOrEqualTo(high)) );
    }

    @Test
    public void shouldGenerateNumberFromOneToTenToExceptFirstPin() {
        assertThat(number.getSecondPins(), not(number.getFirstPins() - number.getFirstPins()) );
    }

    @Test
    public void isExtraPinsWithEnumZeroReturnZero() {
        assertThat(number.setExtraPins(ExtraPins.OFF), is(0));
    }

    @Test
    public void isExtraPinsWithEnumZeroReturnFromOneToTen() {
        int low = 0;
        int high = 10;
        assertThat(number.setExtraPins(ExtraPins.ON), allOf(greaterThanOrEqualTo(low),lessThanOrEqualTo(high)));
    }
}
