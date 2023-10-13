package com.refactor.animals.testJava.cote;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        //https://blog.naver.com/windywaltz/222790918932  여기부터 시작
        //ExceptionHandler Advice 적용하기
        //

        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        StringTokenizer st = new StringTokenizer(num, " ");
        int i=0;
        int sum=0;
        int result=0;
        int[] arr = new int[6];

        while(st.hasMoreTokens()){
            arr[i]=Integer.parseInt(st.nextToken());
            arr[i] = arr[i]*arr[i];
            sum+=arr[i];
            i++;
        }
        result = sum%10;
        System.out.println(result);
    }
}

