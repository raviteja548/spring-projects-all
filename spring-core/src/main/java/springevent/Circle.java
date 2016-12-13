package springevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;


@Component
public class Circle implements Shape ,ApplicationEventPublisherAware{

	@Autowired
	@Qualifier("pointC")
	private Point point0;
	
	private ApplicationEventPublisher publisher; 
	
	
	public Point getPoint0() {
		return point0;
	}

	public void setPoint0(Point point0) {
		this.point0 = point0;
	}


	public void draw(){
		
		System.out.println("Point A"+point0.getX()+" "+point0.getY());
		DrawEvent dw = new DrawEvent(this);
		publisher.publishEvent(dw); 
	}



	public void setApplicationEventPublisher(ApplicationEventPublisher arg0) {
		publisher=arg0;
		
	}

	


}
