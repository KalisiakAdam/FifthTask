import org.junit.Before;
import org.junit.Test;
import java.util.Stack;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PlayerTest {

    private Player player;

    @Before
    public void setUp() {
        player = new Player("Player");
    }

    @Test
    public void isItInstanceOfStackAfterConctructorInvocation() {

        assertThat(player.getPlayerGame(), is(instanceOf(Stack.class)) );
    }
}
