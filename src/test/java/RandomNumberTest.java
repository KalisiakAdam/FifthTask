import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RandomNumberTest {

    @Mock
    private RandomNumber number;


    @Before
    public void setUp() {
        number = new RandomNumber();
        when(number.getFirstPins()).thenReturn(5);

    }

    @Test
    public void shouldGenerateNumberFromOneToTenFirstPin(){
        int low = 0;
        int high = 10;
        assertThat(number.getFirstPins(), allOf(greaterThanOrEqualTo(low),lessThanOrEqualTo(high)) );
    }

    @Test
    public void shouldGenerateNumberFromOneToTenToExceptFirstPin(){

        assertThat(number.getSecondPins(), not(number.getFirstPins()) );
    }
}
