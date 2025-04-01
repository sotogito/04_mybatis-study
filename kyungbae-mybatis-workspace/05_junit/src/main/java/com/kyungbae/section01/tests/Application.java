package com.kyungbae.section01.tests;

public class Application {
    public static void main(String[] args) {

        Calculator calc = new Calculator();
        if (calc != null) {
            System.out.println("인스턴스 생성 성공");
        } else {
            System.out.println("인스턴스 생성 실패");
        }


        int result1 = calc.sum(4,5);
        if (result1 == 9) {
            System.out.println("sum 작동 성공");
        } else {
            System.out.println("sum 작동 실패");
        }

        int result2 = calc.sum(6,7);
        if (result2 == 13) {
            System.out.println("sum 작동 성공");
        } else {
            System.out.println("sum 작동 실패");
        }

        if (calc != null && result1 == 9 && result2 == 13) {
            System.out.println("테스트 성공");
        } else {
            System.out.println("테스트 실패");
        }


    }
}
