import java.util.logging.Logger;

public class BowlGame {

    private Player player1;
    private Player player2;
    private Frame thisFrame;
    private int totalPinsFirstPlayer;
    private int totalPinsSecondPlayer;

    public BowlGame() {
        this.player1 = new Player("Player 1");
        this.player2 = new Player("Player 2");
    }

    public int nextFrameGenerator(Player player) {

        RandomNumber randomNumber = new RandomNumber();
        Frame previousFrame = player.getPlayerGame().peek();
        if (player.getPlayerGame().size() <= 10) {
            thisFrame = new Frame(randomNumber.getFirstPins(), randomNumber.getSecondPins(), randomNumber.setExtraPins(ExtraPins.OFF), previousFrame);
        } else if (player.getPlayerGame().size() == 11) {
            thisFrame = new Frame(randomNumber.getFirstPins(), randomNumber.getSecondPins(), randomNumber.setExtraPins(ExtraPins.ON), previousFrame);
        }
        thisFrame.actualFrameScore();
        player.getPlayerGame().push(thisFrame);


        if(player.equals(player1)) {
            totalPinsFirstPlayer += thisFrame.getFrameScore();
            System.out.println("### FRAME: " + (player1.getPlayerGame().size() ));
            System.out.print(" first pins: " + thisFrame.getFirstPins());
            System.out.println(" second pins: " + thisFrame.getSecondPins());
            System.out.println(player1.getName() +" Actual TOTAL SCORE " + totalPinsFirstPlayer);
            System.out.println("        ");

        } else {
            totalPinsSecondPlayer += thisFrame.getFrameScore();
            System.out.println("### FRAME: " + (player2.getPlayerGame().size()  ));
            System.out.print(" first pins: " + thisFrame.getFirstPins());
            System.out.println(" second pins: " + thisFrame.getSecondPins());
            System.out.println(player2.getName() +" Actual TOTAL SCORE " + totalPinsSecondPlayer);
            System.out.println("         ");
        }
        return thisFrame.totalPinsInFrame();

    }

    public Logger displayResult (Player player) {

        return null;
    }

    public void generateGame() {

        while (isEndOfGame()) {
            if (player1.getPlayerGame().size() < 11 && player2.getPlayerGame().size() < 11 ){
                int tempGeneratorPlayerOne = nextFrameGenerator(player1);
                while (tempGeneratorPlayerOne== 10) {
                    if (player1.getPlayerGame().size() == 11) {break;}
                    else {tempGeneratorPlayerOne = nextFrameGenerator(player1);}

                }
                int tempGeneratorPlayerTwo = nextFrameGenerator(player2);
                while (tempGeneratorPlayerTwo == 10) {
                    if (player2.getPlayerGame().size() == 11) {break;}
                    else {tempGeneratorPlayerTwo = nextFrameGenerator(player2);}

                }


            } else if (player1.getPlayerGame().size() == 11 && player2.getPlayerGame().size() < 11 ){
                nextFrameGenerator(player2);
            } else if (player1.getPlayerGame().size() < 11 && player2.getPlayerGame().size() == 11 ){
                nextFrameGenerator(player1);
            }
        }
    }


    public boolean isEndOfGame() {
        if (player1.getPlayerGame().size() == 11 && player2.getPlayerGame().size() == 11)
            return false;

        return true;
    }
}
