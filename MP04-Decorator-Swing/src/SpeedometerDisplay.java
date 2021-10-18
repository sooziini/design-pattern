import javax.swing.*;
import java.awt.*;

public class SpeedometerDisplay extends DisplayDecorator {
    Display display;
    JPanel panel;
    LabelPanel labelPanel;

    SpeedometerDisplay(Display display, int width, int height) {
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
        labelPanel.updateText("Speed: 50");
    }

    @Override
    public int getHeight() {
        return display.getHeight()+super.getHeight();
    }
}
