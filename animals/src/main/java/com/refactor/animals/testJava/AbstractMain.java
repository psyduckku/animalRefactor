package com.refactor.animals.testJava;

public class AbstractMain {
    public static void main(String[] args) {
      GrandParent gp = new Child();
      gp.name = "grand papa";
      gp.age = 90;
      //gp.setHobby("watchTv"); upcasting은 GrandParent의 속성 이외에 child의 속성을 가질 수 없음
      gp.print();
      gp.test(); //Child의 메서드를 사용할 수 있지만,
        System.out.println("-------------------");
      Child c = new Child();
      c.name ="child momo";
      c.age = 10;
      c.setHobby("study");
      c.print();
      c.test();
      c.parentPrint();
    }
}
