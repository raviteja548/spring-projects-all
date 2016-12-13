package jsr250;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("jsr250.xml");
ctx.registerShutdownHook();
Shape s = (Shape) ctx.getBean("circle");
s.draw();
	}

	

}
