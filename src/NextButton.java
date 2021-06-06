import javax.swing.JButton;

public class NextButton extends JButton {
    private int halfway = 0;

    public NextButton(String text) {
        super(text);
    }
    
    public void gotHalfway(){
        if (++halfway == 2) {
            setEnabled(true);
        }
    }
    
}
