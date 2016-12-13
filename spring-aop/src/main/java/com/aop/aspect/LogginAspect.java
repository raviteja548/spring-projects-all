package com.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 13/12/16
 * Time: 8:05 AM
 * To change this template use File | Settings | File Templates.
 */
@Aspect
public class LogginAspect {

    @Before("execution(public String getName())")
    public void loggingAdvice(){
        System.out.println("Advice run, method invoked");
    }
}
