package com.johnth.section01.tests;

public class Application {
    public static void main(String[] args) {
        /*
            ## 테스트 시나리오 ##
            애플리케이션의 테스트 되어야할 기능이나 특정내용을 문장으로 기술한 것
         */
        // 1. Calculator 인스턴스 생성이 잘 되는지 확인
        Calculator calc = new Calculator();
        if(calc != null){
            System.out.println("인스턴스 생성 성공");
        }else{
            System.out.println("인스턴스 생성 실패");
        }

        // 2. sum 메소드 정상 작동 하는지 확인
        //    2_1) 4와 5 전달시 합계 9가 돌아오는지 확인
        int result1 = calc.sum(4, 5);
        if(result1 == 9){
            System.out.println("sum 작동 성공");
        }else{
            System.out.println("sum 작동 실패");
        }

        //    2_2) 6과 7 전달시 합계 13이 돌아오는지 확인
        int result2 = calc.sum(6, 7);
        if(result2 == 13){
            System.out.println("sum 작동 성공");
        }else{
            System.out.println("sum 작동 실패");
        }

        // 3. 위의 과정 모두 통과시 신뢰성 있는 메소드임을 확인
        if(calc != null && result1 == 9 && result2 == 13){
            System.out.println("테스트 성공");
        }else{
            System.out.println("테스트 실패");
        }

    }
}
