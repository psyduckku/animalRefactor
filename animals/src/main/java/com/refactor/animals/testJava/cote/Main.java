package com.refactor.animals.testJava.cote;

import org.yaml.snakeyaml.reader.StreamReader;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[9]; //좌: 클래스 타입, 우 객체생성(생성시 값부여)
        int maxIdx=-1; //지역변수는 초기화 필수!!
        int maxValue=-1;

        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i]>maxValue){
                maxIdx = i;
                maxValue = arr[i];
            }
        }
        br.close();
        bw.write(String.valueOf(arr[maxIdx]));
        bw.newLine();
        bw.write(String.valueOf(maxIdx+1));
        bw.flush();

    }
}

