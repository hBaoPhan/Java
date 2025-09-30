package phanHoaiBao.bai08;

public class Circle extends Shape{

	
	public Circle() {
		super();
	}

	@Override
	public void draw() {
		System.out.println("draw Circle");
		
	}

	@Override
	public void erase() {
		System.out.println("erase Circle");
		
	}

	@Override
	public void move(int x, int y) {
		System.out.println("Move Circle");
		
	}

}
