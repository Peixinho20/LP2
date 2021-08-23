
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class EllipseApp {
    public static void main (String[] args) {
        EllipseFrame frame = new EllipseFrame();
        frame.setVisible(true);
    }
}

class EllipseFrame extends JFrame {
   
    Ellipse e1;
    Ellipse e2;
    Ellipse e3;

    EllipseFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Ellipse Coloridas");
        this.setSize(350, 350);
        
        this.e1 = new Ellipse(175, 100, 200, 100, Color.PINK, Color.BLUE);
        this.e2 = new Ellipse(175, 250, 200, 100, Color.YELLOW, Color.RED);
        this.e3 = new Ellipse(175, 400, 200, 100, Color.GREEN, Color.BLACK);
    }

    public void paint (Graphics g) {
        super.paint(g);        
        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);
    }
}

class Ellipse {
    int x, y;
    int w, h;
    Color filledColor;
    Color borderColor;

    Ellipse (int x, int y, int w, int h, Color filledColor, Color borderColor) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.borderColor = borderColor;
        this.filledColor = filledColor;
    }

    void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n", this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(this.borderColor);
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        
        g2d.setColor(this.filledColor);
        g2d.fill(new Ellipse2D.Double(this.x, this.y, this.w, this.h));//linha importante para preencher a elipse corretamente
    }
}
