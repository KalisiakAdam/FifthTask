

public class BowlingGame {

    private Player player1;
    private Player player2;
    private Frame thisFrame;
    private int totalPinsFirstPlayer;
    private int totalPinsSecondPlayer;

    public BowlingGame() {
        this.player1 = new Player("Player 1");
        this.player2 = new Player("Player 2");
    }

    public Frame whatKindOfFrameReturn(int numberOfFrames, Frame previousFrame) {
            Frame generatedFrame = null;
            RandomNumber randomNumber = new RandomNumber();
        if (numberOfFrames <= 10) {
            generatedFrame = new Frame(randomNumber.getFirstPins(), randomNumber.getSecondPins(), randomNumber.setExtraPins(ExtraPins.OFF), previousFrame);
        } else if (numberOfFrames == 11) {
            generatedFrame = new Frame(randomNumber.getFirstPins(), randomNumber.getSecondPins(), randomNumber.setExtraPins(ExtraPins.ON), previousFrame);
        }

        return generatedFrame;
    }

    public int nextFrameGenerator(Player player) {

        Frame previousFrame = player.getPlayerGame().peek();
        thisFrame = whatKindOfFrameReturn(player.getPlayerGame().size(), previousFrame);
        thisFrame.actualFrameScore();
        player.getPlayerGame().push(thisFrame);

        if (player.equals(player1)) {
            totalPinsFirstPlayer += thisFrame.getFrameScore();
            displayResult(player, totalPinsFirstPlayer);

        } else {
            totalPinsSecondPlayer += thisFrame.getFrameScore();
            displayResult(player, totalPinsSecondPlayer);
        }

        return thisFrame.totalPinsInFrame();
    }

    public void displayResult(Player player, int totalPinsPlayer) {

        System.out.println("### FRAME: " + (player.getPlayerGame().size() - 1));
        System.out.print("first pins: " + thisFrame.getFirstPins());
        System.out.println(" second pins: " + thisFrame.getSecondPins());
        System.out.println(player.getName() +" TOTAL SCORE " + totalPinsPlayer + "\n");
    }

    public void generateGame() {

        while (isEndOfGame(player1.getPlayerGame().size(), player2.getPlayerGame().size())) {

            if (player1.getPlayerGame().size() < 11 && player2.getPlayerGame().size() < 11 ) {

                int tempGeneratorPlayerOne = nextFrameGenerator(player1);
                while (tempGeneratorPlayerOne == 10) {
                    if (player1.getPlayerGame().size() == 11) {break;}
                    else {tempGeneratorPlayerOne = nextFrameGenerator(player1);}
                }

                int tempGeneratorPlayerTwo = nextFrameGenerator(player2);
                while (tempGeneratorPlayerTwo == 10) {
                    if (player2.getPlayerGame().size() == 11) {break;}
                    else {tempGeneratorPlayerTwo = nextFrameGenerator(player2);}
                }

            } else if (player1.getPlayerGame().size() == 11 && player2.getPlayerGame().size() < 11 ) {
                nextFrameGenerator(player2);

            } else if (player1.getPlayerGame().size() < 11 && player2.getPlayerGame().size() == 11 ) {
                nextFrameGenerator(player1);
            }
        }
    }

    public boolean isEndOfGame (int player1Size, int player2Size) {
        return !(player1Size == 11 && player2Size == 11);
    }
}
