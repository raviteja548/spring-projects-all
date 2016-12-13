package com.aop1.service;

import com.aop1.model.Circle;
import com.aop1.model.Triangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: RAVI
 * Date: 13/12/16
 * Time: 7:54 AM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class ShapeService {
    @Autowired
    private Triangle triangle;
    @Autowired
    private Circle circle;

    public Triangle getTriangle() {
        return triangle;
    }

    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }
}
