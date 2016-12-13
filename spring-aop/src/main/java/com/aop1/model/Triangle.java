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
public class Triangle {
    private String name;

    public String getName() {
        return "Equilateral Triangle";
    }

    public void setName(String name) {
        this.name = name;
    }
}
