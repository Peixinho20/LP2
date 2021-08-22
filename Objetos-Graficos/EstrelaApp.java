import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

import sl.shapes.*;

public class TestApplication1 extends JFrame {
    Canvas cStars = new Canvas();
    public TestApplication1() {
        super("Shapes demo");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridBagLayout());

        getContentPane().add(new JLabel("Star polygons"),
                             new GridBagConstraints(0, 2, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 0, 5), 0, 0));
        getContentPane().add(cStars, new GridBagConstraints(0, 300, 1, 1, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));

        initStars();

        setSize(350, 350);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        TestApplication1 fr = new TestApplication1();
        fr.setVisible(true);
    }

    protected void initStars() {
        Shape[] shapes = new Shape[1];
        shapes[0] = new StarPolygon(50, 50, 50, 20, 5, Math.PI / 4);//estrela

        cStars.setShapes(shapes, Color.red);
    }

    protected static class Canvas extends JPanel {
        Shape[] shapes;
        Color color;
        public void setShapes(Shape[] shapes, Color color) {
            this.shapes = shapes;
            this.color = color;
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.white);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.black);
            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
            g.setColor(color);
            for (int i = 0; i < shapes.length; i++) {
                ( (Graphics2D) g).draw(shapes[i]);

            }
        }
    }
}
