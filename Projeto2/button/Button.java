package button;
import java.awt.Graphics;
import java.awt.*;
import figures.*;
import ivisible.IVisible;

public class Button implements IVisible{
    public int x, y; //posição do botão
    public int size = 50; //tamanho do botão
    public int buttonIndice; //Índice do botão
    public Figure figureButton; //Figura do botão
	
	public Button(int buttonIndice, Figure figureButton) {
        this.figureButton = figureButton;
        this.buttonIndice = buttonIndice;

        this.x = 30;
        this.y = 50 + 55 * buttonIndice;		
	}
	
	public int getIndice() {
        return this.buttonIndice;
    }
	
	public boolean clicked(int x, int y) {
          return (x>=this.x) && (x<= this.x + this.size) && (y >= this.y) && (y <= this.size + (this.size * this.buttonIndice + 50));		
	}

	public void paint(Graphics g, boolean focused) {
    	Graphics2D g2d = (Graphics2D) g;
        
        if (focused) {
            g2d.setStroke(new BasicStroke(1));
            g2d.setPaint(new Color(20,20,20));
            g2d.fillRect(this.x, this.y, this.size, this.size);
            g2d.setPaint(Color.GRAY);
            g2d.drawRect(this.x, this.y, this.size, this.size);
        } else {
            g2d.setStroke(new BasicStroke(1));
            g2d.setPaint(new Color(90,90,90));
            g2d.fillRect(this.x, this.y, this.size, this.size);
            g2d.setPaint(Color.BLACK);
            g2d.drawRect(this.x, this.y, this.size, this.size);
        }

        this.figureButton.paint(g, false);
    }
}
