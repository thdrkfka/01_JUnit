package com.ohgiraffers.parameterized.section01.params;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.Month;
import java.util.stream.Stream;

public class ParameterizedTests {

    /* 수업 목표 : junit-jupiter-params 모듈을 이용하여 파라미터를 이용한 테스트를 작성할 수 있다. */

    /* 필기.
     *   테스트 시 여러 값들을 이용하여 검증을 해야 하는 경우 모든 경우의 수 만큼 테스트 메소드를 작성해야 한다.
     *   parameterized-test 는 @ParameterizedTest 어노테이션을 @Test 어노테이션을 대체하여 사용하며,
     *   이 경우 테스트 메소드에 매개변수를 선언할 수 있다. (일반적인 테스트에서는 매개변수를 사용할 수 없다.)
     *   파라미터로 전달할 값의 목 만큼 반복적으로 테스트 메소드를 실행하며, 반복 실행 시 마다 준비된 값 목록을
     *   매개변수로 전달하여 테스트 코드를 실행하게 된다.
     *   given when then 패턴에서 사전에 테스트를 위해 준비하던 given 부분을 대체할 수 있다. */

    /* 목차. 1. @ValueSource 이용한 parameter value 목록 지정*/
    /* 필기.
     *  @ValueSource 를 이용하여 한개의 파라미터로 전달할 값들의 목록을 지정할 수 있다.
     *  이 때 지원하는 타입은 다음과 같다.
     *  short, byte, int, long, float, double, char, java.lang.String, java.lang.Class */
    @DisplayName("홀수 짝수 판별 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, -1, 15, 123})
    void testIsOdd(int number) {

        //when
        boolean result = NumberValidator.isOdd(number);

        //then
        Assertions.assertTrue(result);

    }

    /* 목차. 2. @NullSource 와 @EmptySource */
    /* 필기.
     *  기본 자료형 타입은 null 값을 가질 수 없다.
     *  문자열이나 클래스 타입인 경우 null이나 빈 값을 파라미터로 전달하기 위해 사용되는 어노테이션이다.
     *  null 값과 빈 값을 모두 전달하기 위해 구성되 @NullAndEmptySource 도 이용할 수 있다. */
    @DisplayName("null값 테스트")
    @ParameterizedTest
    @NullSource
    //param을 이용한 테스트는 매개값을 넣을 수 있는데 공백값은 따로 넣을 수 없으니 null값, empty값,
    void testIsNull(String input) {

        //when
        boolean result = StringValidator.isNull(input); //null 값을 넣어줌.

        //then
        Assertions.assertTrue(result);
    }

    @DisplayName("empty값 테스트")
    @ParameterizedTest
    @EmptySource
    void testIsEmpty(String input) {

        //when
        boolean result = StringValidator.isEmpty(input);

        //then
        Assertions.assertTrue(result);
    }

    @DisplayName("blank값 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    void testIsBlank(String input) {

        //when
        boolean result = StringValidator.isBlank(input);

        //then
        Assertions.assertTrue(result);

    }

    /* 목차. 3. 열거형을 이용한 @EnumSource 활용하기 */
    /* 필기.
     *  열거형에 작성된 타입들을 파라미터로 전달하여 테스트에 활용할 수 있다. */
    @DisplayName("Month에 정의된 타입들이 1~12월 사이의 범위인지 테스트")
    @ParameterizedTest
    @EnumSource(Month.class)
    void testMonthValueIsCollect(Month month) {

        //when
        boolean result = DateValidator.isCollect(month);

        //then
        Assertions.assertTrue(result);
    }

    @DisplayName("2월, 4월, 6월, 9월, 11월을 제외한 달이 31일인지 확인")
    @ParameterizedTest
    @EnumSource(
            value = Month.class,
            names = {"FEBRUARY", "APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"},
            mode = EnumSource.Mode.EXCLUDE) //좀 더 자세한 옵션을 줌.//mode - 제외할지 넣을지 인데 exclude 로 뺌. 31일이 안되는 아이들을 뺌.
    void testHasThirtyOneDaysLong(Month month) {

        //given //파라미터로 갖고 온 애가 아닌 다른 애이기 때문에 given 써줌. // 계속 테스트하는 값이 달라질 때 given을 써줌.
        int verifyValue = 31;

        //when
        int actual = DateValidator.getLastDayOf(month);

        //then
        Assertions.assertEquals(verifyValue, actual);
    }

    /* 목차. 4. @CsvSource 를 이용한 CSV 리터럴 */
    /* 필기.
     *  입력값과 예상값을 테스트 메소드에 전달하기 위해 사용할 수 있다.
     *  이 경우 여러 매개변수에 값을 전달할 여러 인자 묶음이 필요하게 된다.
     *  이 때, @CsvSource 를 사용할 수 있다. */
    @DisplayName("영문자를 대문자로 변경하는지 확인")
    @ParameterizedTest
//    @CsvSource({"test,TEST", "tEsT,TEST", "JavaScript,JAVASCRIPT"})//앞에 있는 문자(입력값) : input, 뒤에 있는 문자(결과값) : verifyValue
    @CsvSource(value = {"test:TEST", "tEsT:TEST", "JavaScript:JAVASCRIPT"},
                delimiter = ':')// , 가 기본 디폴트 구분값
    void testToUpperCase(String input, String verifyValue) {

        //when
        String actual = input.toUpperCase();

        //then
        Assertions.assertEquals(verifyValue, actual);//결과값 과 입력값 비교하여 테스트
    }

    @DisplayName("CSV 파일을 읽은 테스트 데이터를 테스트에 활용하는지 확인")
    @ParameterizedTest
    @CsvFileSource(resources = "/parameter-test-data.csv", numLinesToSkip = 1) //csv파일 안, 필드명을 지정한 첫번째 줄은 무시해줌.
    void testToUpperCaseWithCSVFileData(String input, String verifyValue) {

        //when
        String actual = input.toUpperCase();

        //then
        Assertions.assertEquals(verifyValue, actual);
    }

    /* 목차. 5. @MethodSource 를 활용한 메소드 인수 활용하기 */
    /* 필기.
     *  Stream 을 반환하는 메소드를 만들어서 이를 테스트에 활용 할 수 있다. */
    private static Stream<Arguments> providerStringSource() {
        return Stream.of(
                Arguments.of("hello world", "HELLO WORLD"),
                Arguments.of("JavaScript", "JAVASCRIPT"),
                Arguments.of("tEsT", "TEST")
        );
    }

    @DisplayName("메소드 소스를 활용한 대문자 변환 테스트")
    @ParameterizedTest
    @MethodSource("providerStringSource")
    void testToUpperCaseWithMethodSource(String input, String verifyValue) {

        //when
        String actual = input.toUpperCase();

        //then
        Assertions.assertEquals(verifyValue, actual);
    }

    /* 목차. 6. 인수 변환기 (암시적 변환과 명시적 변환) */
    /* 필기.
     *  JUnit5 는 인수로 지정된 String을 Enum 으로 변환한다.
     *  이처럼 기본적으로 제공하는 변환을 '암시적 변환' 이라고 한다.
     *  UUID, LocalDate, LocalDateTime, Year, Month, 파일 및 경로, URL, 열거형 서브클래스 들을 암시적으로 변환해준다. */
    @DisplayName("암시적 변환 테스트")
    @ParameterizedTest(name = "[{0}] is 30 days long")//ParameterizedTest 에서 지원하는 기능 = > [{0}]
    @CsvSource({"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"})
    void testAutoConverting(Month month) { //String 으로 온 {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"} 이 친구들이 매개값으로 들어가면서 enum 타입으로 변환됨.=>암시적 변환.

        //given
        int verifyValue = 30;

        //when
        int actual = DateValidator.getLastDayOf(month);

        //then
        Assertions.assertEquals(verifyValue, actual);


    }
}
