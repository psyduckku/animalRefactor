package com.refactor.animals.testJava;

public class Child extends Parent{
    public String hobby;
    @Override
    public void print() {
        System.out.println("[Child클래스의 print출력]");
        System.out.println("child");
        System.out.println("name = +" + name);
        System.out.println("age = " + age );
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public void test() {
        System.out.println("hobby = " + hobby);
    }

    public void parentPrint(){
        super.print(); //가능한 이유는 Parent를 상속받기 때문, GrandParent의 경우 print가
                        //abstract이기 때문에 접근이 불가능함.
    }

}
