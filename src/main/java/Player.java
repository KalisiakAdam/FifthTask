import java.util.Stack;

public class Player {

    private String name;
    private Stack<Frame> playerGame;

    public Player (String name) {
        playerGame = new Stack<>();
        Frame frame = new Frame(0, 0, 0, null);
        frame.actualFrameScore();
        playerGame.push(frame);
        this.name = name;
    }

    public Stack<Frame> getPlayerGame() {
        return playerGame;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;

        return name.equals(player.name) && playerGame.equals(player.playerGame);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + playerGame.hashCode();

        return result;
    }
}
