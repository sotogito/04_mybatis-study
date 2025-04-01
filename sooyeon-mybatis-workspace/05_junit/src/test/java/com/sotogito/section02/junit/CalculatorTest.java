package com.sotogito.section02.junit;

/**
 * ## 단정문
 * 1. 테스트 예상 결과와 실제 결과를 비교하는 문장
 * 2. 예상 결과와 일치하면 테스트 성공으로 판단
 * 3. Jnuit 단정문 , hamcrest, assertj-core 등에서 제공\
 *      => assertj-core 많이 사용
 */
import com.sotogito.section02.junit.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
class CalculatorTest {

    //Fixture 준비 : 테스트할 대상 또는 테스트에 필요한 객체를 준비한다
    private Calculator calc = null;

    @BeforeEach
    @Test
    void setUp() {
        calc = new Calculator();
        assertNotNull(calc);
    }

    @AfterEach
    void tearDown() {
        System.out.println("단위테스트 완료");
    }

    @DisplayName("두 수의 합 확인")
    @Test
    void sum() {
        int expected = 9;
        int result = calc.sum(4,5);
//
//        assertEquals(expected,result);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("랜덤값 구하기")
    @Test
    void random() {
        int result = calc.random();

//        assertThat(result)
//                .isGreaterThanOrEqualTo(100)
//                .isLessThanOrEqualTo(200);

        assertThat(result).isBetween(100,200);
    }

}