package innerbeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsingInnerBeans {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("inner.xml");
		//Shape s = (Shape) ctx.getBean("triangle");
//		Shape s = (Shape) ctx.getBean("triangle-alias");
		Shape s = (Shape) ctx.getBean("triangle-name1");
		s.draw();


	}

}
