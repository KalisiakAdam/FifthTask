import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @Before
    public void setUp() {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void isItEndOfGame_IfPlayersStackSizeIsEleven_ReturnFalse() {
        int player1Size = 11;
        int player2Size = 11;

        assertThat(bowlingGame.isEndOfGame(player1Size,player2Size), is(false));
    }

    @Test
    public void isItNotEndOfGame_IfPlayersStackSizeIsLessEleven_ReturnTrue() {
        int player1Size = 10;
        int player2Size = 10;

        assertThat(bowlingGame.isEndOfGame(player1Size,player2Size), is(true));
    }

    @Test
    public void isItReturnFrameClass() {
        int numberOfFrames = 10;

      assertThat(bowlingGame.whatKindOfFrameReturn(numberOfFrames, null), is(instanceOf(Frame.class)));

    }
}
