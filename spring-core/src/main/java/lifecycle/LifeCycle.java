package lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("lifecycle.xml");
		ctx.registerShutdownHook();
		//Shape s = (Shape) ctx.getBean("triangle");
//		Shape s = (Shape) ctx.getBean("triangle-alias");
		Shape s = (Shape) ctx.getBean("triangle");
		s.draw();


	}

}
