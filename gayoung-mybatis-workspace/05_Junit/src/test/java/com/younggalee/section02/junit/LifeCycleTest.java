package com.younggalee.section02.junit;

/*
    ## JUnit ##
    자바 개발에서 가장 많이 사용되는 테스팅 기반 프레임워크이다.
    독립된 단위 테스트를 지원하며 연관된 컴포넌트가 개발되지 않더라도 기능별로 테스트해 볼 수 있음.
    ( 단위 테스트 : 한가지 기능(메소드) 마다 일을 잘 수행하는지 확인하여
    특정 모듈이 의도한 대로 정확히 작동되는지 검증하는 절차 )
    assert(단정문)메소드로 테스트 케이스의 수행결과를 판별할 수 있음
    개발단계초기에 문제점을 발견해서 빠르게 해결할 수 있음
 */
import org.junit.jupiter.api.*;


// 모두 테스트명은 중요하지 않음
public class LifeCycleTest {
    // @BeforeAll : 모든 test메소드가 실행되기전에 최초에 한번 실행되는 메소드
    // 테스트에 필요한 객체를 생성해야하는 경우에 한해
    @BeforeAll
    public static void beforeAll(){
        System.out.println("@BeforeAll - 모든 테스트 메소드 실행 전에 1회 실행됨");
    }


    // @BeforeEach : 각 테스트 메소드 실행전에 반복해서 실행시킬 구문 작성
    @BeforeEach
    public void beforeEach(){
        System.out.println("@BeforeEach - 각 테스트 메소드 전에 매번 실행됨");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("@AfterEach - 각 테스트 메소드 후에 매번 실행됨");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("@AfterAll - 모든 테스트 메소드 후에 최종적으로 한번만 실행됨");
    }

    // @Test : 각 기능별 테스트를 위한 구문 작성
    @Test
    public void test1_테스트케이스1(){
        System.out.println("@Test - 테스트케이스1 실행");
    }
    @Test
    public void test1_테스트케이스2(){
        System.out.println("@Test - 테스트케이스2 실행");
    }

}
