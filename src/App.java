import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class App {
    private JFrame jFrame;
    private DrawingPanel leftDrawingPanel;
    private DrawingPanel rightDrawingPanel;

    public static void main(String[] args) {
        App app = new App();
        app.start();
        
    }
    private void start(){
        jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setTitle("Wyścigi kółeczek");
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(800, 600);
        preparePanels();
    }
    private void preparePanels() {
        JPanel mainPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        mainPanel.setBackground(new Color(0,100,0));
        jFrame.add(mainPanel);
        mainPanel.add(middlePanel);
        middlePanel.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        middlePanel.setPreferredSize(new Dimension (200, 500));
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
        middlePanel.setBackground(new Color(255,255,0));;
        middlePanel.add(getButtonPanel());
        JPanel lowerPanel = new JPanel();
        lowerPanel.setBackground(new Color(0,200,0));
        lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.X_AXIS));
        lowerPanel.setPreferredSize(new Dimension(200, 400));
        rightDrawingPanel = new DrawingPanel();
        leftDrawingPanel = new DrawingPanel();
        lowerPanel.add(leftDrawingPanel);
        lowerPanel.add(rightDrawingPanel);
        middlePanel.add(lowerPanel);
    }
    private JPanel getButtonPanel() {
        JPanel buttonPanel = new JPanel();
        JButton startButton = new JButton("Start");
        NextButton nextButton = new NextButton("Next");
        nextButton.setEnabled(false);
        startButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                RacingThread firstRacingThread = new RacingThread(leftDrawingPanel, nextButton);
                RacingThread secondRacingThread = new RacingThread(rightDrawingPanel, nextButton);
                firstRacingThread.start();
                secondRacingThread.start();
                startButton.setEnabled(false);
            }
            
        });
        nextButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                leftDrawingPanel.letItGo();
                rightDrawingPanel.letItGo();
            }
            
        });
        buttonPanel.add(startButton);
        buttonPanel.add(nextButton);
        buttonPanel.setBackground(new Color(0,150,0));
        buttonPanel.setPreferredSize(new Dimension(200, 100));
        return buttonPanel;
    }
}
