package com.refactor.animals.testJava.cote;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //배수의합
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int sum=0;
        for(int i=1; i<=10; i++){
            if(i%num==0){
                sum=+i;
            }
        }
        bw.write("10까지"+String.valueOf(num)+"의배수의 합:" +String.valueOf(sum));
        bw.flush();

    }
}

