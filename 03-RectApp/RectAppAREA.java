public class RectAppAREA {//cria um retangulo
	public static void main(String[] args){
		Rect r1 = new Rect(1,1,10,10); // parametros do retangulo
		r1.print();
	}
}
class Rect { //propriedades
	int x, y;
	int w, h;
	int area;
	Rect (int x, int y, int w, int h) { //construtor do retangulo
		this.x = x;//parametros
		this.y = y;// o this.y eh o mesmo do int x,y
		this.w = w;// o w depois da = é o mesmo do Rect(int w)
		this.h = h;
		this.area = w*h;
	}
	void print () { //método para manipular propriedades
		System.out.format("Retangulo de tamanho (%d) m².\n",this.area);
	}
}


