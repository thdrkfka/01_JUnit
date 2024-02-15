package com.ohgiraffers.assertions;

import com.ohgifatters.assertions.section01.jupiter.Calculator;
import com.ohgifatters.assertions.section01.jupiter.Person;
import com.ohgifatters.assertions.section02.assertj.Member;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class JupiterAssertionsTests {

    /* 수업 목표 - Junit5(Jupiter)에서 제공하는 Assertions 메소드(로직이 잘 도는지 검증하는 메소드)에 대해 이해 할 수 있다. */

    /* 필기
    *   Junit Jupiter는 Junit4로부터 온 assertion 메소드와 새롭게 자바 8 람다 표현식으로 추가된 메소드를 제공한다.
    *   모든 Jupiter Assertions의 메소드는 정적(static) 메소드 형태로 제공하고 있다. */

    // 대부분의 테스트는 이 포맷에서 사용됨.
    //given : 테스트 시 필요한 파라미터를 준비한다.
    //when : 테스트할 메소드를 호출한다.
    //then : 실행 결과를 검증한다.
    // 하나의 테스트 메소드에는 한가지를 검증할 수 있도록 작성하는 게 좋다.
    // 테스트할 메소드와 검증을 동시에 하는 경우도 있다.(when & then)

    /* 목차. 1. assertEquals */
    /* 필기. assertEquals(expected, actual) 메소드는 실제 값과 기대 값의 일치 여부를 동일성(같은주소)으로 판단한다.*/
    @Test
    @DisplayName("더하기 기능 테스트")
    void testAssertEqual() {

        //given
        int firstNum = 10;
        int secondNum = 19;//19로 바꿔도 오차범위 1은 허용
        int expected = 30;

        //when
        Calculator calculator = new Calculator();
        int result = calculator.plusTwoNumbers(firstNum, secondNum);

        //then
//        Assertions.assertEquals(expected, result);//기대한 값인 expected와 결과값이 result가 같은지 검증

        //delta : 오차 허용 범위를 의미한다.
//        Assertions.assertEquals(expected, result, 1);

        // 3번째 인자로 문자열로 테스트 실패 시 보여줄 메시지를 작성할 수 있다.
//        Assertions.assertEquals(expected, result, "실패할 때 보여줄 메시지");

        // 람다를 이용해도 결과는 동일하지만 불필요한 경우 메시지를 만들지 않도록 지연로딩을 이용한다.
        Assertions.assertEquals(expected, result, () -> "실패할 때 보여줄 메시지");

    }

    /* 목차. 2. assertNotEquals */
    /* 필기. assertNotEquals(expected, actual) 메소드는 실제 값과 기대 값의 불일치 여부를 동일성(같은주소)으로 판단한다.*/
    @Test
    @DisplayName("인스턴스 동일성 비교 테스트")
    void testAssertNotEqualsWithInstances() {

        //given
        Object obj1 = new Object(); //메모리상 주소가 다르게 저장됨.

        //when
        Object obj2 = new Object();

        //then
        /* 단, equals 와 hashcode 가 오버라이딩 되어 있는 경우는 같다고 판단함. */
        Assertions.assertNotEquals(obj1, obj2);
    }

    /* 목차. 3. assertNull */
    /* 필기. assertNull(actual) 메소드는 레퍼런스 변수가 null 값을 가지는지를 판단한다. */
    @Test
    @DisplayName("null 인지 확인")
    void testAssertNull() {

        //given
        String str;

        //when
        str = null;
//        str = "null";//이렇게 하면 텍스트로 들어가니까 오류남.

        //then
        Assertions.assertNull(str);

    }

    /* 목차. 4. assertNotNull */
    /* 필기. assertNotNull(actual) 메소드는 레퍼런스 변수가 null 값을 가지지 않는지를 판단한다. */
    @Test
    @DisplayName("null이 아닌지 확인")
    void testAssertNotNull() {

        //given
        String str;

        //when
        str = "java";
//        str = null;

        //then
        Assertions.assertNotNull(str);
    }

    /* 목차. 5. assertTrue */
    /* 필기. assertTrue(actual) 메소드는 결과값이 true인지 확인하는 메소드 */
    @Test
    @DisplayName("두 값이 같은지 확인")
    void testAssertTrue() {

        //given
        int num1 = 10;
        int num2 = 10;

        //when
        boolean result = num1 == num2;//boolean => true/false 값

        //then
        /* assertEquals로 true값과 일치하는지를 확인하는 기능과 동일하다. */
//        Assertions.assertTrue(result);
        Assertions.assertEquals(true, result);
    }

    /* 목차. 6. assertFalse */
    /* 필기. assertFalse(actual) 메소드는 결과값이 false인지 확인하는 메소드 */
    @Test
    @DisplayName("두 값이 다른지 확인")
    void testAssertFalse() {

        //given
        int num1 = 10;
        int num2 = 20;

        //when
        boolean result = num1 == num2;

        //then
        /* assertEquals로 false값과 일치하는지를 확인하는 기능과 동일하다. */
        Assertions.assertFalse(result);
        Assertions.assertEquals(false, result);
    }

    /* 목차. 7. assertAll */
    /* 필기. assertAll(Executable...) 모든 Assertion이 실행되고 실패가 함께 보고되는 그룹화된 Assertion */
    @Test
    @DisplayName("동시에 여러가지 값에 대한 검증을 수행하는 경우 테스트")
    void testAssertAll() {

        //given
        String firstName = "길동";
        String lastName = "홍";

        //when //person 클래스를 만들어서 import
        Person person = new Person(firstName, lastName);

        //then
        Assertions.assertAll(
                "그룹화된 테스트의 이름(테스트 실패시 보여짐)",
                () -> Assertions.assertEquals("길길", person.getFirstName(), () -> "firstName이 잘못됨."),
                () -> Assertions.assertEquals(lastName, person.getLastName(), () -> "lastName이 잘못됨.")
        );
    }

    /* 목차. 8. 객체 프로퍼티 추출 하기 */
    /* 필기.
        객체의 특정 프로퍼티를 추출하여 List를 이용한 검증을 할 수 있다.
        property를 확인하는 것은 getter 메소드가 필요하지 않다. */
    @Test
    @DisplayName("프로퍼티 추출 테스트하기")
    void testExtractProperty() {

        //given
        Member member1 = new Member(1, "user01", "홍길동", 20);
        Member member2 = new Member(2, "user02", "유관순", 16);
        Member member3 = new Member(3, "user03", "이순신", 40);
        Member member4 = new Member(4, "user04", "신사임당", 43);
        Member member5 = new Member(5, "user05", "임꺽정", 19);

        List<String> excpected = Arrays.asList("홍길동", "유관순", "이순신", "신사임당","임꺽정");

        //when
        List<Member> members = Arrays.asList(member1, member2, member3, member4, member5);

        //then
        //위에서 사용한 Assertions 과 다른 Assertions 사용해야하는데 이름이 같아서 경로를 지정해줘야 원하는 것 사용 가능
        org.assertj.core.api.Assertions.assertThat(members)
                .extracting("name", String.class)//members 안의 이름이라는 필드 추출해서 내용들이 String 값으로 되어 있는지 테스트
                .containsAll(excpected);
    }


    /* 목차. 9. 객체의 프로퍼티를 여러 개 튜플로 추출하기 */
    /* 필기. 객체의 여러 프로퍼티들을 추출하여 튜플로 생성하고, 튜플을 이용하여 검증할 수 있는 기능을 제공 */
    @Test
    @DisplayName("튜플로 추출하여 테스트하기")
    void testExtractPropertyTuple() {

        //given
        Member member1 = new Member(1, "user01", "홍길동", 20);
        Member member2 = new Member(2, "user02", "유관순", 16);
        Member member3 = new Member(3, "user03", "이순신", 40);
        Member member4 = new Member(4, "user04", "신사임당", 43);
        Member member5 = new Member(5, "user05", "임꺽정", 19);

        //when
        List<Member> members = Arrays.asList(member1, member2, member3, member4, member5);

        //then
        org.assertj.core.api.Assertions.assertThat(members)
                .extracting("name", "age")
                .contains(
                        Tuple.tuple("홍길동", 20),
                        Tuple.tuple("유관순", 16)//튜플 값이 일치하지 않으면 테스트 검증x
                );
    }

}
