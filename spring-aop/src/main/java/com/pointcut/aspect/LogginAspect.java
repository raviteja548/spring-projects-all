package com.pointcut.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 13/12/16
 * Time: 8:05 AM
 * To change this template use File | Settings | File Templates.
 */
@Aspect
@Component
public class LogginAspect {

    @Before("allGetters()")
    public void loggingAdvice(){
        System.out.println("Logging Advice, method invoked");
    }


    @Before("execution(* get*(..))")
    public void secondAdvice(){
        System.out.println("Second Advice, method invoked");
    }

    @Pointcut("execution(* get*(..))")
    public void allGetters(){

    }

}
