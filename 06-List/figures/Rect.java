package figures;

import java.awt.*;

public class Rect {
    private int x, y;
    private int w, h;
    private Color borderColor;
    private Color fillColor;

    public Rect(int x, int y, int w, int h/*, Color borderColor, Color fillColor*/) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        //this.borderColor = borderColor;
        //this.fillColor = fillColor;
    }

    public void Print() {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void Paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(borderColor);
        g2d.drawRect(this.x, this.y, this.w, this.h);

        //g2d.setColor(fillColor);
        //g2d.fillRect(this.x, this.y, this.w, this.h);
    }
}
