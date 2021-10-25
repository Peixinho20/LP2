package figures;

import java.awt.Graphics;
import ivisible.IVisible;

public abstract class Figure implements IVisible {
	public int x, y;
    public int w, h;

    public Figure (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
	}        
    public abstract void paint (Graphics g);
}
