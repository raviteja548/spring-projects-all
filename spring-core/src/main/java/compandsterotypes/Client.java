package compandsterotypes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
ApplicationContext ctx = new ClassPathXmlApplicationContext("compandsterotype.xml");
Shape s = (Shape) ctx.getBean("circle");
s.draw();
	}

	

}
