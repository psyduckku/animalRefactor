package com.refactor.animals.testJava.cote;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //문자열을 입력받음. 대소문자를 구분하진 않지만 //해당 문자열은 모두 대문자로 출력되어야함->.toUpperClass()
        //대문자 모든 문자는 26개임 . 즉 26개의 int 배열을 만들기
        //문자열의 length만큼. charAt()으로 하나씩 꺼냄. 꺼내서 asc인덱스에 맞는 배열에 저장함
        //+ int index = 65-word. 숫자-문자=숫자. 대문자A는 asc코드로 65. 65-A는 0이된다. B는 1 C는 2 즉. 인덱스값으로 26개의 배열에이렇게 저장해준다.
        // 각 배열마다 최고 높은 수를 max값에 저장함. 가장많이 사용된 숫자가 여러개(중복)일 경우 ? 물음표를 출력함.

        int[] arr = new int[26]; //배열값을 int로 해서 char를 담아도 asc값으로 변환됨
        int max=0;
        int result;
        //어떻게 인덱스에 값을 값을 세지..?
        Scanner sc = new Scanner(System.in);
        String sentence = sc.next();
        String upperSentence = sentence.toUpperCase();
        for (int i = 0; i < upperSentence.length(); i++) {
            arr[upperSentence.charAt(i)-65]++;
            //26개의 단어들을 담음. 0, arr[0]=A arr[1]=B arr[3]=C
        }
        for(int i=0; i<arr.length;i++){
            //하나씩 꺼내서. 제일 높은값만 max에 담음. max=0; if(max<arr[i]){ max = arr[i]}

//            if(max<arr[i]){
//                max=arr[i];
//            }
            System.out.println(arr[i]);
        }
    }
}
