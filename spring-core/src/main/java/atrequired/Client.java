package atrequired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
ApplicationContext ctx = new ClassPathXmlApplicationContext("atrequired.xml");
Shape s = (Shape) ctx.getBean("triangle");
s.draw();
	}

	

}
