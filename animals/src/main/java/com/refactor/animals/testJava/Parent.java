package com.refactor.animals.testJava;

public abstract class Parent extends GrandParent{
    @Override
    public void print() {
        System.out.println("[Parent클래스의 print출력]");
        System.out.println("parent");
        System.out.println("name = + "+name);
    }
}
