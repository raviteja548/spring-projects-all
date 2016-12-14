package com.joinpoint.aspect;

import org.aspectj.lang.JoinPoint;
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
    public void loggingAdviceForGetters(JoinPoint joinPoint){
        System.out.println("Logging Advice:"+joinPoint.toString());
    }

    @Before("allGetters() && allCircleMethods()")
    public void loggingAdvice(JoinPoint joinPoint){
        System.out.println("Logging Advice for Circle:"+joinPoint.toString());
    }


    @Before("allCircleMethods()")
    public void secondAdvice(JoinPoint joinPoint){
        System.out.println("Second Advice:"+joinPoint.toString());
    }

    @Before("args(name)")
    public void stringArgumentMethodChanges(String name){
        System.out.println("A setter invoked:"+name);
    }

    @Pointcut("execution(* get*(..))")
    public void allGetters(){

    }

    @Pointcut("within(com.joinpoint.model.Circle)")
    public void allCircleMethods(){

    }



}
