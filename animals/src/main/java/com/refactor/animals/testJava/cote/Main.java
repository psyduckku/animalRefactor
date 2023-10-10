package com.refactor.animals.testJava.cote;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] jum = new int[num];
        int max=0;
        int sum=0;
        float avg=0;
        for(int i=0; i<jum.length; i++){
            jum[i] = sc.nextInt();
            if(max<jum[i]){
                max = jum[i];
            }
            sum += jum[i];
        }
        System.out.println(100.0*sum/max/num);

    }

}
