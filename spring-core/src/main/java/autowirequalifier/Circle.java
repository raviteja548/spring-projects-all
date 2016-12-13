package autowirequalifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;



public class Circle implements Shape {

	@Autowired
	@Qualifier("pointC")
	private Point point0;
	
	
	public Point getPoint0() {
		return point0;
	}

	public void setPoint0(Point point0) {
		this.point0 = point0;
	}


	public void draw(){
		
		System.out.println("Point A"+point0.getX()+" "+point0.getY());
	}


}
