import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class RandomNumberTest {

    private RandomNumber number;

    @Before
    public void setUp() {
        number = new RandomNumber();
    }

    @Test
    public void shouldGenerateNumberFromOneToTenFirstPins() {
        int low = 0;
        int high = 10;

        assertThat(number.getFirstPins(), allOf(greaterThanOrEqualTo(low), lessThanOrEqualTo(high)));
    }

    @Test
    public void shouldGenerateRandomNumberFromExceptFirstPinsToTen() {

        RandomNumber numbers = mock(RandomNumber.class);
        when(numbers.getFirstPins()).thenReturn(5);
        when(numbers.getSecondPins()).thenReturn(5);

        int low = 10 - numbers.getFirstPins();
        int high = 10;

        assertThat(numbers.getSecondPins(), allOf(greaterThanOrEqualTo(low), lessThanOrEqualTo(high)));
    }

    @Test
    public void isExtraPinsWithEnumOffReturnZero() {
        assertThat(number.setExtraPins(ExtraPins.OFF), is(0));
    }

    @Test
    public void isExtraPinsWithEnumOnReturnFromOneToTen() {
        int low = 0;
        int high = 10;
        assertThat(number.setExtraPins(ExtraPins.ON), allOf(greaterThanOrEqualTo(low),lessThanOrEqualTo(high)));
    }
}
