package com.ohgiraffers.section05.custom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
//@EnabledOnOs(value = OS.MAC, disabledReason = "mac 환경에서만 작동합니다.")
@DisabledOnOs(value = OS.MAC, disabledReason = "mac 환경에서는 작동하지 않습니다.")
@Test
public @interface MacTest {

}
