package jsr250;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;




public class Circle implements Shape {

	@Resource(name="pointB")
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
	@PostConstruct
	public void initializeCircle(){
		System.out.println("cicle initialized");
	}
	@PreDestroy
	public void destroyCircle(){
		System.out.println("destroying circle..");
	}

}
