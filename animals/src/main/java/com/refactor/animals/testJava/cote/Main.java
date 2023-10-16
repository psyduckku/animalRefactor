package com.refactor.animals.testJava.cote;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        String abc = Integer.toString((a*b*c));
        for(int i=0; i<10;i++){
            int count=0;
            for (int j=0; j<abc.length();j++){
                if(i+48==abc.charAt(j)){
                    count++;
                }
            }System.out.println(count);

        }




    }
}

