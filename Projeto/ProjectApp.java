import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class ProjectApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame { //listas de figuras ativas
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();
    
    Figure focus = null; //figura em foco no momento

    ListFrame () {
        this.addWindowListener ( //adcionar ouvinte de janela
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.addMouseMotionListener(
        	public void mousePressed (MouseEvent evt){
        	}
        );
        
        this.addMouseMotionListener(
        	public void mouseDragged (MouseEvent evt){
        	}
        );

        this.addKeyListener ( //adcionar ouvinte de teclado
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    int x = rand.nextInt(350);
                    int y = rand.nextInt(350);
                    int w = rand.nextInt(50);
                    int h = rand.nextInt(50);
                    if (evt.getKeyChar() == 'r') {
                        figs.add(new Rect(x,y, w,h));
                    } else if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x,y, w,h));
                    } else if (evt.getKeyChar() == 't'){
                    	figs.add(new Triangle(x,y, w,h));                      
                    } else if (evt.getKeyChar() == 's'){
                    	figs.add(new Star(x,y, w,h));                      
                    }
                   
                    repaint();
                }
            }
        );

        this.setTitle("Lista de Figuras");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) { //redesnhar as figuras
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}
