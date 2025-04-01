package com.sotogito.section02.junit;

import org.junit.jupiter.api.*;

/**
 * ## Junit
 * 1. java개발시 가장 많이 사용되는 테스팅 기반 프레임워크
 * 2. 독립된단위 테스트 지원함
 *      > 단위 테스트
 *          : 한 가지 기능(메서드)마다 일을 잘 수행하는지 확인하여 특정 모듈이 의도한대로 정확히 작동되는지 검증하는 절차
 *          : 연관된 컨포넌트가 개발되지 않더라도 기능별로 테스트 해볼 수 있음
 * 3.  assert(단정문) 메서드로 테스트 케이스의 수행 결과를 판별할 수 있음
 * 4. 개발 단계 초기에 문제점을 발견해서 빠르게 해결할 수 있음
 */
public class LifeCycleTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("모든 테스트 실행 전 최초에 1번만 실행");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("모든 테스트 실행 후 최종적으로 1번만 실행");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("테스트 케이스 하나하나 실행 전 한번씩 실행");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("테스트 케이스 하나하나 실행 후 하나씩 실행");
    }

    @Test
    public void test1_테스트케이스1() {

    }

}
