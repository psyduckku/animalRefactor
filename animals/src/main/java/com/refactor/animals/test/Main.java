package com.refactor.animals.test;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static final int MAX_N = 10;
    static int N, E;
    static int[][] Graph = new int[MAX_N][MAX_N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        E = sc.nextInt();
        for(int i = 0; i < E; ++i){
            int u = sc.nextInt();
            int v = sc.nextInt();
            Graph[u][v] = Graph[u][v] = 1; //각 노드의 정점에 값을 1로 초기화

        }
        bfs(0); //최상위 노드부터 시작
        sc.close();
    }
    static void bfs(int node){
        boolean[] visited = new boolean[MAX_N];

        Queue<Integer> myqueue = new LinkedList<>();
        visited[node] = true;
        myqueue.add(node);
        System.out.println(node);

        while(!myqueue.isEmpty()){
            int curr = myqueue.remove(); //제거한 노드번호를 전달

            System.out.print(curr + " "); //방문 노드 찍기

            for(int next=0; next < N; ++next){
                if(!visited[next] && Graph[curr][next]!=0){
                    visited[next] = true;
                    myqueue.add(next);
                }
            }
        }
    }
}
