package com.younggalee.section02.junit;

public class Calculator {

    public int sum(int x, int y){
        return x+y;
    }

    public int random(){
        return (int)(Math.random()* 101 + 100); // 100~200
    }
}
