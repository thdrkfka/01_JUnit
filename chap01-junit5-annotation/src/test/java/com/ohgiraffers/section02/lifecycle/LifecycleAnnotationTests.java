package com.ohgiraffers.section02.lifecycle;

import org.junit.jupiter.api.*;

public class LifecycleAnnotationTests {

    /* 수업목표 - 테스트 메소드의 실행 전, 후에 동작하는 어노테이션 활용 */

    /* 필기. 테스트가 실행되기 전 딱 한번만 실행(테스트가 없으면 실행되지 않음.) */

    @BeforeAll //모든 테스트가 실행되기 전에 한번 실행
    public static void beforeAll(){
        System.out.println("beforeAll");
    }

    /* 필기
     *  각각의 테스트 메소드가 실행되기 전 실행되나
     *  @Test, @RepeatedTest, @ParameterizedTest, @TestFactory 가 실행되기 전에 동작.
     *  주로 테스트 하기 전에 필요한 목업데이터(테스트를 위한 데이터)를 미리 세팅해 줄 목적으로 사용.
        */

    @BeforeEach //각각의 테스트가 실행되기 전에 한번 실행
    public void beforeEach() {
        System.out.println("beforeEach");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    /* 필기
    *   각각의 테스트 메소드가 동작한 직후 동작
    *   @Test, @RepeatedTest, @ParameterizedTest, @TestFactory 가 실행된 이후에 동작.
    *   주로 단위 테스트들이 수행된 이후 사용한 자원을 해제할 목적으로 사용*/
    @AfterEach
    public void afterEach() {
        System.out.println("afterEach");
    }

    /* 필기
     *   모든 단위테스트가 완전히 끝난 후 딱 한번만 실행
     * */
    @AfterAll
    public static void afterAll() {
        System.out.println("afterAll");
    }



}
