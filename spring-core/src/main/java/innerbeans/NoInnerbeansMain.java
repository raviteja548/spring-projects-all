package innerbeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NoInnerbeansMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
ApplicationContext ctx = new ClassPathXmlApplicationContext("noinner.xml");
Shape s = (Shape) ctx.getBean("triangle");
s.draw();
	}

	

}
