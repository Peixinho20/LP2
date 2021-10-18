package figures;

import java.awt.*;

public class Triangle extends Figure {
    int x, y, w, h;
    public Polygon polygon;
    
    public Triangle(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;

        this.w = w;
        this.h = h;

    }

    public void print() {
        System.out.format("Triangulo de vertices (%d, %d), (%d, %d) e (%d, %d).\n",
            this.x, this.y, this.w, this.h);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        int x[] = {this.x, this.x + this.w/2, this.x + this.w};
        int y[] = {this.y + this.h, this.y, this.y + this.h};
        Polygon polygon = new Polygon(x,y,3);
        this.polygon = polygon;
        Polygon Triangle = new Polygon(x, y, 3);

        g2d.drawPolygon(this.polygon);
        g2d.drawPolygon(this.polygon);        
    }
}
