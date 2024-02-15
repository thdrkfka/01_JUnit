package com.ohgiraffers.parameterized.section01.params;

import java.time.Month;

public class DateValidator {

    //받아온 매개변수 month가 1월~12월 사이인지 확인을 하고, 맞다면 true 반환하고 틀리면 false 반환
    public static boolean isCollect(Month month) {

        int monthValue = month.getValue(); //month 에서 string으로 가져온 아이들을 getvalue로 숫자로 바꿔줌.

        return monthValue >= 1 && monthValue <= 12;
    }

    public static int getLastDayOf(Month month) {

        return month.maxLength();
    }

}
