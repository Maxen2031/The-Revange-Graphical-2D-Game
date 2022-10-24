import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton implements ActionListener {
    private String buttonType;

    public Button() {
        this.setVisible(true);
    }

    public Button(String buttonType) {
        this.setButtonType(buttonType);
        this.setFocusable(false);
        this.setVisible(true);
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

        if (this.getButtonType() == "playButton") {
            this.playAction();
        }
    }

    public void playAction() {
        System.out.println("Play Action");
    }
}
