package com.ohgiraffers.section05.custom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//런타임까지 이 어노테이션이 유지되어야 함.
// Retention -> 어노테이션이 언제까지 유지될지 명시하는 것
@Target(ElementType.METHOD)
// Target -> 이 어노테이션이 적용될 수 있는 JAVA 요소의 종류를 지정.
@EnabledOnOs(value = OS.WINDOWS)
@DisabledOnOs(value = OS.WINDOWS, disabledReason = "윈도우 환경에서는 작동하지 않습니다.")
@Test
public @interface WindowsTest {


}
