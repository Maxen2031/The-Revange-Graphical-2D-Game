import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton implements ActionListener {
    private String buttonType;
    private Screen screen;

    public Button(Screen screen) {
        this.setVisible(true);
        this.screen = screen;
    }

    public Button(String buttonType, Screen screen) {
        this.setButtonType(buttonType);
        this.setFocusable(false);
        this.addActionListener(this);
        this.setVisible(true);
        this.screen = screen;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }

    public String getButtonType() {
        return this.buttonType;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (!(event.getSource().equals(this))) return;
        System.out.println("here");
        if (this.getButtonType().equals("playButton")) {
            System.out.println("2");
            this.playAction();
        }
    }

    public void playAction() {
        screen.initializeGame();
    }
}
