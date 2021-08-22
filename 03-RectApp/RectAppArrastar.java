public class RectAppArrastar {//cria um retangulo
	public static void main(String[] args){
		Rect r1 = new Rect(1,1,10,10); //parametros do retan.
		r1.print();
	}
}

class Rect { //propriedades
	int x, y;
	int dx,dy;
	int w, h;
	Rect (int x, int y, int w, int h) { //construtor do retangulo
		this.x = x;//parametros
		this.y = y;// o this.y eh o mesmo do int x,y
		this.w = w;// o w depois da = é o mesmo do Rect(int w)
		this.h = h;
	}
	void drag (int dx, int dy) { //método para manipular propriedades
		this.dx = this.x + x;
		this.dy = this.y + y;		
	}
}


