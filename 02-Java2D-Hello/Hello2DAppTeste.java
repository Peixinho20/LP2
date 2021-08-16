import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Hello2DAppTeste extends JFrame {

    public Hello2DAppTeste() {
        setTitle("Hello World");
        setSize(250, 250);
        setVisible(true);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.blue);
        Shape circleShape = new Ellipse2D.Double(100, 100, 100, 100);

        g2d.draw(circleShape);
    }

    public static void main(String[] args) {

        new Hello2DAppTeste();

    }
}

