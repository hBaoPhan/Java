package phanHoaiBao.bai08;

public class Quad extends Shape {
	public Quad() {
		super();
	}

	@Override
	public void draw() {
		System.out.println("draw Quad");
		
	}

	@Override
	public void erase() {
		System.out.println("erase Quad");
		
	}

	@Override
	public void move(int x, int y) {
		System.out.println("Move Quad");
		
	}
}
