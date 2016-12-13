package container;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 21/7/14
 * Time: 10:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class BeanFactoryExApp {
    public static void main(String... args){
        XmlBeanFactory factory = new XmlBeanFactory
                (new ClassPathResource("Beans.xml"));

        BeanFactoryExPojo obj = (BeanFactoryExPojo) factory.getBean("helloWorld");
        obj.getMessage();


    }
}
