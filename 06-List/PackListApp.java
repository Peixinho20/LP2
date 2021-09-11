import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

import figures.*;

class PackListApp {
    public static void main(String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    ArrayList<Rect> rs = new ArrayList<Rect>();
    ArrayList<Ellipse> el = new ArrayList<Ellipse>();
    ArrayList<Triangle> tg = new ArrayList<Triangle>();
    
    Random rand = new Random();

    private Color getRandomColor() {
        return new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
    }

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed(KeyEvent evt) {
                    if (evt.getKeyChar() == 'r') {
                        int x = rand.nextInt(350);
                        int y = rand.nextInt(350);
                        int w = rand.nextInt(50);
                        int h = rand.nextInt(50);
                        //Color borderColor = getRandomColor();
                        //Color fillColor = getRandomColor();

                        rs.add(new Rect(x, y, w, h/*, borderColor, fillColor*/)); // outer.rs.add();
                        repaint();  // outer.repaint()
                    }

                    if (evt.getKeyChar() == 'e') {
                        int x = rand.nextInt(350);
                        int y = rand.nextInt(350);
                        int w = rand.nextInt(50);
                        int h = rand.nextInt(50);
                        //Color borderColor = getRandomColor();
                        //Color fillColor = getRandomColor();
                        
                        el.add(new Ellipse(x, y, w, h/*, borderColor, fillColor*/)); 
                        repaint(); // outer.repaint()
                    }
                    if (evt.getKeyChar() == 't') {
                        int x1 = rand.nextInt(350);//tamanho janela
                        int y1 = rand.nextInt(350);//tamanho janela
                        int x2 = rand.nextInt(350);//tamanho janela
                        int y2 = rand.nextInt(350);//tamanho janela 
                        int x3 = rand.nextInt(350);//tamanho janela
                        int y3 = rand.nextInt(350);//tamanho janela
                        //Color borderColor = getRandomColor();
                        //Color fillColor = getRandomColor();
                        
                        tg.add(new Triangle(x1, y1, x2, y2, x3, y3/*, borderColor, fillColor*/));
						//x1 e y1 posições dos triangulos
                        repaint(); // outer.repaint()
                    }
                }
            }
        );

        this.setTitle("Lista de Figuras");
        this.setSize(350, 350);

    }

    public void paint(Graphics g) {
        super.paint(g);

        for (Rect r: this.rs) {
            r.Paint(g);
        }
        
        for (Ellipse e: this.el) {
            e.Paint(g);
        }
        
		for (Triangle t: this.tg) {
            t.Paint(g);
        }

    }   
}

