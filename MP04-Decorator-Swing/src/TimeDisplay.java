import java.time.LocalDateTime;

public class TimeDisplay extends InfoDisplay {
    TimeDisplay(Display display, int width, int height) {
        super(display, width, height);
    }

    @Override
    public String getDisplayText() {
        return "Date: "+LocalDateTime.now().toString();
    }
}
