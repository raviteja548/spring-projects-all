package com.advice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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

    @Before("allCircleMethods() && allGetters()")
    public void loggingAdviceBefore(JoinPoint joinPoint){
        System.out.println("BeforeAdvice :Logging Advice for Circle Before:"+joinPoint.toString());
    }

    @After("allCircleMethods() && allGetters()")
    public void loggingAdviceAfter(JoinPoint joinPoint){
        System.out.println("After Advice:Logging Advice for Circle:"+joinPoint.toString());
    }

    @AfterReturning("allCircleMethods() && allGetters()")
    public void loggingAdviceAfterReturning(JoinPoint joinPoint){
        System.out.println("AfterReturning: Logging Advice for Circle:"+joinPoint.toString());
    }

    @AfterThrowing("allCircleMethods() && allGetters()")
    public void loggingAdviceAfterThrowing(JoinPoint joinPoint){
        System.out.println("AfterThrowing: Logging Advice for Circle:"+joinPoint.toString());
    }

    @Before("args(name)")
    public void stringArgumentMethodChangesBefore(String name){
        System.out.println("Before Advice: A setter invoked:"+name);
    }

    @After("args(name)")
    public void stringArgumentMethodChangesAfter(String name){
        System.out.println("After Advice: A setter invoked:"+name);
    }



    @Pointcut("execution(* get*(..))")
    public void allGetters(){

    }

    @Pointcut("within(com.advice.model.Circle)")
    public void allCircleMethods(){

    }



}
