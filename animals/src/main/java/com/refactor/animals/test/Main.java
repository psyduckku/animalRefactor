package com.refactor.animals.test;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3);
        list.stream().forEach((n->{
            System.out.println(n);
        }));

    }
}
