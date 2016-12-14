package com.aroundadvice.samples;

import com.aroundadvice.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 13/12/16
 * Time: 7:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static  void main(String... args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("around-advice.xml");
        ShapeService service = ctx.getBean("shapeService",ShapeService.class);

        service.getCircle().setName("In Circle");
        System.out.println(service.getCircle().getName());
        System.out.println("---------------------------------------");
        service.getCircle().setName("Java");
        System.out.println(service.getCircle().getName());




    }
}
