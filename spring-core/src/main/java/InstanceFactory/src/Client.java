package InstanceFactory.src;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Client {

    public static void main(String[] args) {
        BeanFactory fac = new XmlBeanFactory(new ClassPathResource("instanceFactory.xml"));
        Apple apple = (Apple) fac.getBean("apple");
        System.out.println(apple.getAppleColor());
    }
}
