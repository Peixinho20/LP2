import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;//novo
import figures.*;

public class ProjectApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);        
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Figure focus = null;
    Point pMouse = null;

    int dx,dy;
    int contcontorno=1;
    int contpreenchimento=0;
    Color cores[] = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA, Color.CYAN, Color.WHITE, Color.BLACK, Color.GRAY, Color.LIGHT_GRAY, Color.DARK_GRAY, Color.PINK, Color.ORANGE};

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.addMouseListener(
            new MouseAdapter(){
                public void mousePressed(MouseEvent evt){
                    try{
                        int x = evt.getX();
                        int y = evt.getY();
                        pMouse = getMousePosition();
                        focus = null;
                        for (Figure fig: figs){
                            if (fig.clicked(pMouse.x,pMouse.y)){
                                focus = fig;
                                dx = focus.x - pMouse.x;
                                dy = focus.y - pMouse.y;
                            }
                        }
                        if (focus!=null){
                            figs.remove(focus);
                            figs.add(focus);
                        }
                        repaint();
                        
                    }catch(Exception x){}
                }
            }
        );
        this.addMouseMotionListener(
            new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent me) {
                    pMouse = getMousePosition();
                    if (focus != null) {
                        figs.remove(focus);
                        figs.add(focus);
                        focus.x = pMouse.x + dx;
                        focus.y = pMouse.y + dy;
                    }
                    repaint();
                }
            }
        );
        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    pMouse = getMousePosition();
                    int x = pMouse.x;
                    int y = pMouse.y;
                    int w = 50;
                    int h = 50;
                    Color contorno = cores[contcontorno];
                    Color preenchimento = cores[contpreenchimento];
                        
                    if (evt.getKeyChar() == 'r') {
                        Rect r = new Rect(x,y, w,h,Color.red,Color.black);
                        figs.add(r);  
                    }
                    else if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x,y,w,h,Color.blue,Color.yellow));   
                    }
                    else if (evt.getKeyChar() == 't'){
                        figs.add(new Triangle(x,y,w,h,Color.green,Color.black));   
                    }
                    else if (evt.getKeyChar() == 's'){
                        figs.add(new Star(x,y,w,h,Color.pink,Color.black));   
                    }
                    try{
                        if (evt.getKeyCode() == 10){
                            for( Figure fig: figs){
                                if ((focus == null) || (focus!=null)){
                                    focus=fig;
                                    figs.remove(focus);
                                    figs.add(focus);
                                    break;
                                }
                                repaint();
                            }   
                        }
                        else if(evt.getKeyCode() == 127){
                            figs.remove(focus);
                            focus=null;
                        }
                        else if(evt.getKeyCode() == 38){
                            focus.y-=10;
                        }
                        else if(evt.getKeyCode() == 37){
                            focus.x-=10;
                        }
                        else if(evt.getKeyCode() == 40){
                            focus.y+=10;
                        }
                        else if(evt.getKeyCode() == 39){
                            focus.x+=10;
                        }
                        else if (evt.getKeyChar()=='a'){
                            focus.w+=5;
                            focus.h+=5;
                        }
                        else if (evt.getKeyChar()=='d'){
                            if(focus.w>=10 && focus.h>=10){
                                focus.w-=5;
                                focus.h-=5;
                            }
                        }
                        else if(evt.getKeyChar()=='c'){
                            if (contcontorno==12){
                                contcontorno=0;
                            }
                            else {
                                contcontorno++;
                            }
                            focus.contorno=cores[contcontorno];

                        }
                        else if (evt.getKeyChar()=='p'){
                            if (contpreenchimento==12){
                                contpreenchimento=0;
                            }
                            else {
                                contpreenchimento++;
                            }
                            focus.preenchimento=cores[contpreenchimento];

                        }
                        repaint();    
                    }catch(Exception e){}
                }
            }
        );

        this.setTitle("Projeto");
        this.setSize(350, 350);
    }
    public void paint (Graphics g){
        super.paint(g);
        for(Figure fig: this.figs){
            if(focus==fig){
                focus.preencherFig(g);
                focus.desenharBorda(g);
            }
            fig.paint(g);
        }                    
    }    
}
