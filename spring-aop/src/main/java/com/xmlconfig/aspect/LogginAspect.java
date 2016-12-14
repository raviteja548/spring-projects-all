package com.xmlconfig.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 13/12/16
 * Time: 8:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class LogginAspect {



    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        Object valueToReturn = null;
        try {
            System.out.println("Before Advice "+proceedingJoinPoint.toString());
             valueToReturn = proceedingJoinPoint.proceed();

            System.out.println("After Returning");
        } catch (Throwable throwable) {
            System.out.println("After Throwing");
        }
        System.out.println("After Finally");
             return  valueToReturn;
    }








}
