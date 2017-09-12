
public class RandomNumber {

    private int firstPins;
    private int secondPins;


    public RandomNumber() {
        this.firstPins = -1;
        this.secondPins = -1;
    }

    private void setFirstPins() {
        firstPins = (int)(Math.random() * 11);
    }

    private void setSecondPins() {
        secondPins = (int)(Math.random() * (10 - firstPins));
    }

    public int setExtraPins (ExtraPins extraPins){
        switch (extraPins) {
            case ON: return (int)(Math.random() * 11);

            case OFF: return 0;
        }
        return 0;
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
