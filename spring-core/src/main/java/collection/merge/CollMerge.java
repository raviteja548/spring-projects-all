package collection.merge;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollMerge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
ApplicationContext ctx = new ClassPathXmlApplicationContext("collec-merge.xml");
//Shape s = (Shape) ctx.getBean("par-triangle");
Shape s = (Shape) ctx.getBean("chi-triangle");
s.draw();
	}

	

}
