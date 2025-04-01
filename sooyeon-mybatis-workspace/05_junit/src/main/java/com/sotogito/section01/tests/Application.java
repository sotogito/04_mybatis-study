package com.sotogito.section01.tests;

public class Application {
    public static void main(String[] args) {

        /**
         * ## 테스트 시나리오
         * 애플리케이션의 테스트 되어야할 기능이나 특정 내용을 문장으로 기술한것
         *
         * 1. Calculator 인스턴스 생성이 잘 되는지 확인
         * 2. sum 메서드 정상 작동 하는 지 확인
         *      - 4+5 = 9
         *      - 6+7 = 13
         * 3. 위의 과정 모두 통과시 신뢰성 있는 메서드임을 확인
         */

        Calculator calc = new Calculator();
        if(calc != null) {
            System.out.println("생성 성공");
        }else {
            System.out.println("생성 실패");
        }

        int result1 = calc.sum(4, 5);
        int result2 = calc.sum(6,7);

        if(result1 == 9 && result2 == 13){
            System.out.println("성공");
        }else {
            System.out.println("실패");
        }
    }
}
