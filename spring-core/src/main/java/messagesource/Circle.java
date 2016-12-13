package messagesource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;



public class Circle implements Shape {

	@Autowired
	@Qualifier("pointC")
	private Point point0;
	
	@Autowired
	private MessageSource messageSource;
	
	
	public Point getPoint0() {
		return point0;
	}

	public void setPoint0(Point point0) {
		this.point0 = point0;
	}


	public void draw(){
		
		System.out.println("Point A"+point0.getX()+" "+point0.getY());
		System.out.println(this.messageSource.getMessage("drawing.circle", null, "default value",null));
		System.out.println(messageSource.getMessage("drawing.point", new Object[]{point0.getX(),point0.getY()}, "default value",null));
		
	}


}
