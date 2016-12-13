package InstanceFactory.src;
public class AppleFactory {

    public AppleFactory() {
    }

    public Apple getApple() {
        return new Apple();
    }
}
//AppleFactory af=new AppleFactory();
//Apple apple=af.getApple();