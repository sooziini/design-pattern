public class SpeedometerDisplay extends InfoDisplay {
    SpeedometerDisplay(Display display, int width, int height) {
        super(display, width, height);
    }

    @Override
    public String getDisplayText() {
        return "Speed: 50";
    }
}
