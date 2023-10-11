package com.refactor.animals.testJava.cote;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer();
        String a="안녕";
        System.out.println("a = " + a);
        String b="반가워";
        System.out.println(a+=b);
        sb1.append(a);
        System.out.println("sb1="+a+b);
        }

    }

