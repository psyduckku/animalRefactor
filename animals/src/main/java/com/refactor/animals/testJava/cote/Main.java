package com.refactor.animals.testJava.cote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine()," ");
        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"MON","TUE","WED","THUR","FRI","SAT","SUN"};
        int x= Integer.parseInt(tokenizer.nextToken());
        int y= Integer.parseInt(tokenizer.nextToken());
        int count = 0;
        int result = 0;
        for(int i=0; i<x; i++){
            count+=months[i];
        }
        System.out.println(days[(count-1)%7]);
    }
}

