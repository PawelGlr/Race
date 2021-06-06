import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class DrawingPanel extends JPanel{
    private int circreHeight = 0;
    private boolean canGo = false;

    public DrawingPanel() {
        setMaximumSize(new Dimension(100,400));
        setMinimumSize(new Dimension(100,400));
        setBackground(new Color(230,230,0));
        addMouseListener(new MouseInputListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
 
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
  
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(new Color(255,255,255));
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(new Color(230,230,0));
                
            }

            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
            
        });
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(0,0,0));
        g.drawLine(0, 200, 100, 200);
        g.drawOval(50, circreHeight, 20, 20);
    }
    public void draw(int height){
        circreHeight = height;
        // repaint();
    }
    public int getCircleHeight(){
        return circreHeight;
    }
    public void letItGo(){
        canGo = true;
    }
    public boolean getCanGo(){
        return canGo;
    }

    
}
