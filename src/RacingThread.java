import java.util.Random;

public class RacingThread extends Thread {
    private DrawingPanel drawingPanel;
    private Random random = new Random();
    private NextButton nextButton;
    public RacingThread(DrawingPanel drawingPanel, NextButton nextButton) {
        this.drawingPanel = drawingPanel;
        this.nextButton = nextButton;
    }
    // public void 
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            int number = random.nextInt(100);
            if (number > 90) {
                number+=300;
            }else if(number>=70){
                number+=100;
            }else if(number < 20){
                number = 1;
            }
            try {
                sleep(number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            drawingPanel.draw(drawingPanel.getCircleHeight()+1);
            drawingPanel.repaint();
        }
        nextButton.gotHalfway();
        while (!drawingPanel.getCanGo()) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 200; i++) {
            int number = random.nextInt(100);
            if (number > 90) {
                number+=300;
            }else if(number>=70){
                number+=100;
            }else if(number < 20){
                number = 1;
            }
            try {
                sleep(number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            drawingPanel.draw(drawingPanel.getCircleHeight()+1);
            drawingPanel.repaint();
        }

    }
}
