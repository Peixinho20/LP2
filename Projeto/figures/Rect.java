package figures;

import java.awt.*;

public class Rect extends Figure{ //construtor do retangulo
    public Rect (int x,int y,int w,int h) {
        super(x,y,w,h);
    }

    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.x, this.y, this.w, this.h);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //g2d.setColor(this.preencheCor);
        //g2d.fillRect(this.x,this.y,this.w,this.h);
        //g2d.setColor(this.corBorda);
        g2d.drawRect(this.x,this.y, this.w,this.h);
    }
}
