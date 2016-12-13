package compandsterotypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class Circle implements Shape {
	@Autowired
	private Point point0;
	
	
	public Point getPoint0() {
		return point0;
	}

	public void setPoint0(Point point0) {
		this.point0 = point0;
	}


	public void draw(){
		
		System.out.println("Point 0is "+point0.getX()+" "+point0.getY());
	}

}
