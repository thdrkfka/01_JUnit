package com.ohgiraffers.section01.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class TestAnnotationTests {

    /* 수업목표 - Junit5의 기본 어노테이션을 사용할 수 있다.*/
    /* 필기
     * Junit5는 세 개의 서브 프로젝트로 이루어져 있다.
     * Junit의 구조
     * 1. Junit Platform
     * - JVM에서 테스트 프레임워크를 실행하기 위한 테스트 엔진을 제공한다.
     * 2. Junit Jupiter
     * - Junit5에서 테스트를 작업하고 실행하기 위한 엔진을 제공한다.
     * 3. Junit Vintage
     * - Junit3, 4를 기반으로 돌아가는 테스트 엔진을 제공해준다. (하위 호환용)*/
    /*
     * 테스트 클래스는 적어도 한 개 이상의 @Test 어노테이션이 달린 메소드를 가진 클래스이다.
     * 테스트 클래스는 abstract 이면 안되고, 한개 이상의 생성자를 가지고 있어야 한다.
     * (두개 이상 작성하면 런타임시 PreconditionViolationException이 발생한다.
     *  아무런 생성자도 작성하지 않으면 기본 생성자는 컴파일러가 자동으로 추가한다.)
     */

    public TestAnnotationTests() {
    }

//    public TestAnnotationTests(int value) {} //생성자가 두개라서 에러가 나니 주석 처리함.

    /*
     * 필기. 기본적으로 테스트 이름은 메소드 이름을 따라가지만 @DisplayName에 설정한 이름으로 이름을 표기해준다.*/

    @Test
    @DisplayName("테스트 메소드 1")
    public void testMethod1() {


    }

    @Test
    @DisplayName("displayName 우선순위 테스트")
    public void 테스트_메소드2() {

        /* 필기
         *   클래스 레벨에 @DisplayNameGenerator를 붙이게 되면 언더바를 공백으로 처리하여 테스트 이름 변경 가능
         *   단, @DisplayName과 중복 작성 시에는 @DisplayName에 부여한 테스트 이름이 우선권 가짐.*/

    }

}
