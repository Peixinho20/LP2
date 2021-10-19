package figures;

import java.awt.*;

public class Triangle extends Figure {
    public Triangle(int x,int y,int w,int h) {
        super(x,y,w,h);
    }
    //public Polygon polygon;

    public void print() {
        System.out.format("Triangulo de vertices (%d, %d), (%d, %d) e (%d, %d).\n",
            this.x, this.y, this.w, this.h);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        int x[] = {this.x, this.w/2 + this.x, this.w + this.x};
        int y[] = {this.y + h, this.y, this.y + this.h};
        Polygon polygon = new Polygon(x,y,3);
        this.polygon = polygon;
        Polygon Triangle = new Polygon(x, y, 3);
        //g2d.setColor(this.preencheCor);
        //g2d.fillPolygon(x, y, 3); 
        //g2d.setColor(this.corBorda);
        //g2d.drawPolygon(x, y, 3);
        g2d.drawPolygon(this.polygon);
        g2d.drawPolygon(this.polygon);   
    }
}
