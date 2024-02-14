package com.ohgifatters.assertions.section01.jupiter;

public class Person {

    private final String firstName;

    private final String lastName;

    //생성자
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
