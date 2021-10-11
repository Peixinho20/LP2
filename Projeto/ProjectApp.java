import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.JFrame;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Toolkit;
import figures.*;

class ProjectApp {
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
    Color cores[] = {Color.WHITE, Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY,
            Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.GRAY,
<<<<<<< HEAD
            Color.RED, Color.YELLOW, Color.PINK	};

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
=======
            Color.RED, Color.YELLOW, Color.PINK	
    };
    
	Frame(){
    	
    	//Menu
    	buts.add(new ButtonRect(1, new Rect(20, 90, 30, 30, Color.BLACK, Color.BLACK)));
    	buts.add(new ButtonEllipse(2, new Ellipse(20,130,30,30, Color.BLACK, Color.BLACK)));
    	buts.add(new ButtonTriangle(4, new Triangle(60,90,30,30, Color.BLACK, Color.BLACK)));
    	buts.add(new ButtonStar(6, new Star(60,130,30,30, Color.BLACK, Color.BLACK)));
    	buts.add(new ButtonDelete(7, new Rect(20, 170, 70, 20, Color.BLACK, Color.BLACK)));
    	buts.add(new ButtonDeleteAll(8, new Rect(20, 200, 70, 20, Color.BLACK, Color.BLACK)));
    	buts.add(new ButtonChangeColor(9, new Rect(20, 230, 70, 20, Color.BLACK, Color.BLACK)));
    	
        this.addWindowListener(
            new WindowAdapter(){
                public void windowClosing(WindowEvent e){
>>>>>>> 157f6625134312dbae5a0a31c1f962cccb23ffbe
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
<<<<<<< HEAD
                        if (focus!=null){
                            figs.remove(focus);
                            figs.add(focus);
                        }
                        repaint();
                        
                    }catch(Exception x){}
=======
                    } else if(evt.getKeyChar() == '-'){
                    	if(Ffocus.getW() > 0 && Ffocus.getH() > 0) {
                    		Ffocus.setH(Ffocus.getH() - Ffocus.getH()/10);
                        	Ffocus.setW(Ffocus.getW() - Ffocus.getW()/10);
                    	}
                    } else if(evt.getKeyCode() == KeyEvent.VK_UP){//MOVE PARA CIMA
                    	Ffocus.setY(Ffocus.getY() - 1);
                    } else if(evt.getKeyCode() == KeyEvent.VK_DOWN){//MOVE PARA BAIXO
                    	Ffocus.setY(Ffocus.getY() + 1);
                    } else if(evt.getKeyCode() == KeyEvent.VK_LEFT){//MOVE PARA A ESQUERDA
                    	Ffocus.setX(Ffocus.getX() - 1); 
                    } else if(evt.getKeyCode() == KeyEvent.VK_RIGHT){//MOVE PARA A DIREIRA
                    	Ffocus.setX(Ffocus.getX() + 1);
                    } else if(evt.getExtendedKeyCode() == KeyEvent.VK_SPACE){//ALTERNA ENTRE AS FIGURAS
                    	if(figs.size() > 0) {
                    		if(Ffocus == null) {
                    			Ffocus = figs.get(0);
                    		}
                    		Ffocus = null;
                        	if(aux == 0) {
                        		Ffocus = figs.get(figs.size() - 1);
                        	}
                        	Ffocus = null;
                        	if(aux >= figs.size()) {
                        		aux = 0;
                        	}
                        	if(aux != 0) {
                        		Ffocus = figs.get(aux);
                        	}   	
                        	Ffocus = figs.get(aux);
                        	Ffocus.setContour(Color.red);
                        	figs.remove(Ffocus);
                        	figs.add(Ffocus);
                        	aux += 1;
                    	}
                    } else if(evt.getKeyChar() == 'c'){
                    	Ffocus.setFill(colors[colorPaintAux]);
                    	colorPaintAux += 1;
                    	if(colorPaintAux >= 12) {
                    		colorPaintAux = 0;
                    	}
                    } else if(evt.getKeyChar() == 'p'){
                    	Ffocus.setBorder(colors[colorPaintAux]);
                    	colorPaintAux += 1;
                    	if(colorPaintAux >= 12) {
                    		colorPaintAux = 0;
                    	}
                    } else if(evt.getKeyChar() == 'b'){
                    	Bfocus = null;
                    }
                    repaint();
>>>>>>> 157f6625134312dbae5a0a31c1f962cccb23ffbe
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
        this.setSize(400, 400);
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

