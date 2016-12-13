package com.aop.samples;

import com.aop.service.ShapeService;
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
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-main.xml");
        ShapeService service = ctx.getBean("shapeService",ShapeService.class);
        System.out.println(service.getCircle().getName()+" "+service.getTriangle().getName());



    }
}
