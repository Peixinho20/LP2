package figures;

import java.awt.*;

public class Star extends Figure{
	public Star(int x,int y,int w,int h/*,Color preencheCor,Color corBorda*/){
		super(x,y,w,h/*,preencheCor,corBorda*/);
	}
	public Polygon polygon;
	
	public void print() {
        System.out.format("Triangulo de vertices (%d, %d), (%d, %d) e (%d, %d).\n",
            this.x, this.y, this.w, this.h);
    }
	
	public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int x[] = {this.x, this.x + (2 * this.w)/5, this.x + this.w/2, this.x + (3 * this.w/5), this.x + this.w, this.x + (int)(6.5 * this.w/10), 
        this.x + (int)(8.5 * this.w/10), this.x + this.w/2, this.x + (int)(1.5 * this.w/10), this.x + (int)(3.5 * this.w/10)};
         
        int y[] = {this.y + this.h/3, this.y + this.h/3, this.y, this.y + this.h/3, this.y + this.h/3, this.y + (int)(6 * this.h/10), 
        this.y + this.h, this.y + (int)(8 * this.h/10), this.y + this.h, this.y + (int)(6 * this.h/10)};
        
        Polygon polygon = new Polygon(x,y,10);
        this.polygon = polygon;
        
        //g2d.setColor(this.preencheCor);
        //g2d.fillPolygon(x1, y1, 10); 
        //g2d.setColor(this.corBorda);
        g2d.drawPolygon(x, y, 10);
    }

}

