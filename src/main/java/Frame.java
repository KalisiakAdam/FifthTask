
public class Frame {

    private int firstPins;
    private int secondPins;
    private int extraPins;
    private boolean bonusTen;
    private boolean bonusThreeTen;
    private boolean bonusTenInTwoPins;
    private Frame previous;
    private int frameScore;


    public Frame(int firstPins, int secondPins, int extraPins, Frame previous) {
        this.firstPins = firstPins;
        this.secondPins = secondPins;
        this.extraPins = extraPins;
        this.bonusTen = false;
        this.bonusThreeTen = false;
        this.bonusTenInTwoPins = false;
        this.previous = previous;
        frameScore = 0;
        pinsBonusesManagement();
    }

    public boolean ifBonusTen() {
        return firstPins == 10;

    }

    public boolean ifBonusTenInTwoPins() {
        return totalPinsInFrame() == 10;
    }

    public boolean ifBonusThreeTen() {
        return this.bonusTen && previous.bonusTen;
    }

    private void pinsBonusesManagement() {
        if (previous == null) {
            if (ifBonusTen()) {
                bonusTen = true;
            } else if (ifBonusTenInTwoPins()){
                bonusTenInTwoPins = true;
            }
        } else {
            if (ifBonusTen()) {
                bonusTen = true;
                if (ifBonusThreeTen()) {
                    bonusThreeTen = true;
                }
            }
            else if (ifBonusTenInTwoPins()) {
                bonusTenInTwoPins = true;
            }
        }
    }


    public int totalPinsInFrame(){
        return firstPins + secondPins;
    }

    public int actualFrameScore() {

        if(previous == null) {
            frameScore += totalPinsInFrame();
        }else {

            if (this.bonusThreeTen && previous.bonusThreeTen) {
                frameScore += totalPinsInFrame() * 3 + firstPins + extraPins;
            } else if (previous.bonusTen) {
                frameScore += totalPinsInFrame() * 2  + extraPins;
            } else if (previous.bonusTenInTwoPins) {
                frameScore += totalPinsInFrame() + firstPins + extraPins ;
            } else {
                frameScore += totalPinsInFrame();
            }
        }
        return frameScore;
    }

    public int getFirstPins() {
        return firstPins;
    }

    public int getSecondPins() {
        return secondPins;
    }


    public int getFrameScore() {
        return frameScore;
    }
}
