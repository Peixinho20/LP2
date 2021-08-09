import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DApp {
	public static void main (String[] args) {
		Hello2DFrame frame = new Hello2DFrame();
		frame.setVisible(true);
	}
}

class Hello2DFrame extends JFrame{
	public Hello2DFrame () {
		this.setTitle("Hello World!");
		this.setSize(350, 350);
	}
	public void paint (Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(Color.blue);
		int w = this.getWidth();
		int h = this.getHeight();
		g2d.drawLine(0,0, w,h);
		g2d.drawLine(0,0, w,0);
	}	
}
