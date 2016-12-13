package com.aop1.model;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 13/12/16
 * Time: 7:53 AM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class Circle {
    private String name;

    public String getName() {
        return "Cirucm Circle";
    }

    public void setName(String name) {
        this.name = name;
    }
}
