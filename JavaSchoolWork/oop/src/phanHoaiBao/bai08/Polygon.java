package phanHoaiBao.bai08;

public class Polygon extends Shape {
	public Polygon() {
		super();
	}

	@Override
	public void draw() {
		System.out.println("draw Polygon");
		
	}

	@Override
	public void erase() {
		System.out.println("erase Polygon");
		
	}

	@Override
	public void move(int x, int y) {
		System.out.println("Move Polygon");
		
	}
}
