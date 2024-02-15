package com.ohgiraffers.parameterized.section01.params;

public class StringValidator {

    public static boolean isNull(String input) {

        return input == null; //null일 때, true 나오는 메소드
    }

    public static boolean isEmpty(String input) {

        return "".equals(input); //빈 값일 때, true 나오는 메소드
    }

    public static boolean isBlank(String input) {

        return input == null || "".equals(input); //null이거나 빈 값일 때, true 나오는 메소드
    }
}
