import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import figures.*;
import button.*;
import button.Button;

public class ProjectApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);        
    }
}

class ListFrame extends JFrame {
	public static final long serialVersionUID = 1L;

    ArrayList<Figure> figs = new ArrayList<Figure>();
    ArrayList<Button> buts = new ArrayList<Button>();
    Random rand = new Random();
    Figure focus = null;
    Button Bfocus = null; //botão selecionado
    Point pMouse = null;
    boolean auxClick = false;

    int dx,dy;
    int contcontorno=1;
    int contpreenchimento=0;
    
    Color cores[] = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA, Color.CYAN, Color.WHITE, Color.BLACK, Color.GRAY, Color.LIGHT_GRAY, Color.DARK_GRAY, Color.PINK, Color.ORANGE};

@SuppressWarnings("unchecked")

    ListFrame () {
    	try {
    		FileInputStream f = new FileInputStream("proj.bin");
    		ObjectInputStream o = new ObjectInputStream(f);
    		this.figs = (ArrayList<Figure>) o.readObject();
    		o.close();
    		
    	} catch (Exception x) {
    		System.out.println("ERRO!");
    	}
    	buts.add(new Button(0, new Rect(40,60,30,30,Color.white,Color.black)));
        buts.add(new Button(1, new Ellipse(40, 115, 30, 30, Color.black,Color.white)));
        buts.add(new Button(2, new Triangle(40, 170, 30, 30, Color.white,Color.black)));
        buts.add(new Button(3, new Star(40, 220, 30,30,Color.white,Color.black)));
    
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                	try {
                		FileOutputStream f = new FileOutputStream("proj.bin");
                		ObjectOutputStream o = new ObjectOutputStream(f);
                		o.writeObject(figs);
                		o.flush();
                		o.close();
                		
                	} catch (Exception x){                		
                	}                	
                    System.exit(0);
                }
            }
        );
        this.addMouseListener(
            new MouseAdapter(){
                public void mousePressed(MouseEvent evt){
                	pMouse = getMousePosition();
                	focus = null;
                	
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
                        
                        for(Button but: buts){
                        	if(but.clicked(pMouse.x,pMouse.y)){
                        		Bfocus = but;
                        		
                        		repaint();
	    						auxClick = true;
                        	}
                        }
                      	if(Bfocus != null && !(Bfocus.clicked(pMouse.x,pMouse.y))) {
							if(Bfocus.getIndice() == 0) {
								focus = new Rect(pMouse.x,pMouse.y,40,40, Color.red,Color.black);								
								figs.add(focus);
								
							}
							if(Bfocus.getIndice() == 1) {
								focus = new Ellipse(pMouse.x,pMouse.y,40,40, Color.blue,Color.yellow);
								figs.add(focus);	
							}
							
							if(Bfocus.getIndice() == 2) {
								focus = new Triangle(pMouse.x,pMouse.y,40,40,Color.green,Color.black);
								figs.add(focus);
							}
							
							if(Bfocus.getIndice() == 3) {
								focus = new Star(pMouse.x,pMouse.y,40,40,Color.pink,Color.black);
								figs.add(focus);
							}
							Bfocus = null; //me permite clicar sem add figuras
        				}
        				                   	
                        if (focus!=null){ //adicionar e remover figura na posição do mouse
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
                public void mouseDragged(MouseEvent me) {//Arrastar figuras
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
                    else if(evt.getKeyCode() == KeyEvent.VK_DELETE || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
                    	figs.remove(focus);
                    }
                    try{//Adicionar e remover figuras
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
                        //Evento de aumentar e diminuir figuras
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
                        //colorir figuras
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
            fig.paint(g, fig == focus);
        }
        for (Button but: this.buts){
        	but.paint(g, but == Bfocus);
        }                    
    }    
}
