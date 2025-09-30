package phanHoaiBao.bai08;


public class Rectangle extends Quad{

	
	public Rectangle() {
		super();
	}

	@Override
	public void draw() {
		System.out.println("draw Rectangle");
		
	}

	@Override
	public void erase() {
		System.out.println("erase Rectangle");
		
	}

	@Override
	public void move(int x, int y) {
		System.out.println("Move Rectangle");
		
	}

}
