
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

    public void pinsBonusesManagement() {
        if (previous == null) {
            if (ifBonusTen()) {
                bonusTen = true;
            } else if (ifBonusTenInTwoPins()) bonusTenInTwoPins = true;
        } else {
            if (ifBonusTen()) {
                bonusTen = true;
                if (ifBonusThreeTen()) bonusThreeTen = true;
            } else if (ifBonusTenInTwoPins()) bonusTenInTwoPins = true;
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

    public void setFirstPins(int firstPins) {
        this.firstPins = firstPins;
    }

    public void setSecondPins(int secondPins) {
        this.secondPins = secondPins;
    }

    public int getExtraPins() {
        return extraPins;
    }

    public void setExtraPins(int extraPins) {
        this.extraPins = extraPins;
    }

    public boolean isBonusTen() {
        return bonusTen;
    }

    public void setBonusTen(boolean bonusTen) {
        this.bonusTen = bonusTen;
    }

    public boolean isBonusThreeTen() {
        return bonusThreeTen;
    }

    public void setBonusThreeTen(boolean bonusThreeTen) {
        this.bonusThreeTen = bonusThreeTen;
    }

    public boolean isBonusTenInTwoPins() {
        return bonusTenInTwoPins;
    }

    public void setBonusTenInTwoPins(boolean bonusTenInTwoPins) {
        this.bonusTenInTwoPins = bonusTenInTwoPins;
    }

    public Frame getPrevious() {
        return previous;
    }

    public void setPrevious(Frame previous) {
        this.previous = previous;
    }

    public void setFrameScore(int frameScore) {
        this.frameScore = frameScore;
    }
}
