import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class TimeDisplay extends DisplayDecorator {
    Display display;
    JPanel panel;
    LabelPanel labelPanel;

    TimeDisplay(Display display, int width, int height) {
        super(display, width, height);
        this.display = display;
    }

    @Override
    public JPanel create() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setMinimumSize(new Dimension(getWidth(), getHeight()));
        panel.setPreferredSize(new Dimension(getWidth(), getHeight()));
        panel.add(display.create());
        labelPanel = new LabelPanel();
        panel.add(labelPanel.createPanel(getWidth(), getHeight()));
        return panel;
    }

    @Override
    public void show() {
        display.show();
        labelPanel.updateText("Date: "+LocalDateTime.now().toString());
    }

    @Override
    public int getHeight() {
        return display.getHeight()+super.getHeight();
    }
}
