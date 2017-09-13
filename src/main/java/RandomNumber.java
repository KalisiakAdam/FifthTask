
public class RandomNumber {

    private int firstPins;
    private int secondPins;
    private int extraPins;


    public RandomNumber() {
        this.firstPins = -1;
        this.secondPins = -1;
        this.extraPins = 0;
    }

    private void setFirstPins() {
        firstPins = (int)(Math.random() * 11);
    }

    private void setSecondPins() {
        secondPins = (int)(Math.random() * (11 - firstPins));
    }

    public int setExtraPins (ExtraPins extraPinsEnum){
        switch (extraPinsEnum) {
            case ON: extraPins = (int)(Math.random() * 11);
            return extraPins;

            case OFF: extraPins = 0;
            return extraPins;
        }
        return extraPins;
    }

    public int getFirstPins() {
        if (firstPins == -1) setFirstPins();
        return firstPins;
    }

    public int getSecondPins() {
        if (secondPins == -1) setSecondPins();
        return secondPins;
    }

}
