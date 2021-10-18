import javax.swing.*;
import java.awt.*;

public abstract class InfoDisplay extends DisplayDecorator {
    Display display;
    JPanel panel;
    LabelPanel labelPanel;

    InfoDisplay(Display display, int width, int height) {
        super(width, height);
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
        labelPanel.updateText(getDisplayText());
    }

    @Override
    public int getHeight() {
        return display.getHeight()+super.getHeight();
    }

    public abstract String getDisplayText();
}
