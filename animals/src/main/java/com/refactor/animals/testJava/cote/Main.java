package com.refactor.animals.testJava.cote;


import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int X = sc.nextInt();
        int[] A = new int[N];

        for(int i=0; i<A.length; i++){
            A[i]= sc.nextInt();
        }

        for(int i=0; i<A.length; i++){
            if(A[i]<X){
                System.out.println(String.valueOf(A[i])+ " ");
            }
        }
        sc.close();
    }
}

