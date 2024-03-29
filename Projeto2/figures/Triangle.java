package figures;

import java.awt.*;

public class Triangle extends Figure {
    public Triangle(int x,int y,int w,int h,Color preencheCor,Color corBorda) {
        super(x,y,w,h,preencheCor,corBorda);
    }

    private void Print() {
        System.out.format("Triangulo de vertices (%d, %d), (%d, %d) e (%d, %d).\n",
            this.x, this.y, this.w, this.h);
    }

    public /*abstract*/  void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
        int x[] = {this.x, ((this.w)/2) + (this.x), (this.w) + (this.x)};
        int y[] = {this.y + h, (this.y + h) - (this.h), this.y + h};
        g2d.setColor(this.preencheCor);
        g2d.fillPolygon(x, y, 3); 
        g2d.setColor(this.corBorda);
        g2d.drawPolygon(x, y, 3);
    }
}
