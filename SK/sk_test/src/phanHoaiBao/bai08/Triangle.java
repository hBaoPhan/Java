package phanHoaiBao.bai08;

public class Triangle extends Shape {
	public Triangle() {
		super();
	}

	@Override
	public void draw() {
		System.out.println("draw Triangle");
		
	}

	@Override
	public void erase() {
		System.out.println("erase Triangle");
		
	}

	@Override
	public void move(int x, int y) {
		System.out.println("Move Triangle");
		
	}
}
