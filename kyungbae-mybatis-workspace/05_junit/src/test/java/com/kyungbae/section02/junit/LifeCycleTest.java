package com.kyungbae.section02.junit;

import org.junit.jupiter.api.*;

public class LifeCycleTest {

    @BeforeAll
    public static void beforeAll(){
        System.out.println("@BeforeAll - 최초에 1회 실행");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("@BeforeEach - 각 테스트 메소드 전에 실행");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("@AfterEach - 각 테스트 메소드 후에 실행");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("@AfterAll - 모든 테스트 후에 1번 실행");
    }

    @Test
    public void test1_테스트케이스1(){
        System.out.println("@Test - 테스트케이스1 실행");
    }

    @Test
    public void test2_테스트케이스2(){
        System.out.println("@Test - 테스트케이스2 실행");
    }
}
