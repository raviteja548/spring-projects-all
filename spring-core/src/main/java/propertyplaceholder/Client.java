package propertyplaceholder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import simpleautowire.Shape;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
ApplicationContext ctx = new ClassPathXmlApplicationContext("propertyplaceholder.xml");
        //DBConfig dbConfig = (DBConfig) ctx.getBean("dbConfig");
      //  System.out.println(dbConfig.toString());


             TestBean tb = (TestBean)ctx.getBean("test");
        System.out.println(tb.getDbConfig().getDbHost());
	}

	

}
