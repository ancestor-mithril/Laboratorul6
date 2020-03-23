package lab6;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyComponent extends JPanel {
    private int x, y, radius;

    public MyComponent() {
        init();
    }

    private void init() {
        setPreferredSize(new Dimension(400, 400));
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                radius = 50 + (int) (100 * Math.random());
                repaint();
            }
        });
    }
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        g.drawOval(x - radius / 2, y - radius / 2, radius, radius);
    }
}


