package com.ohgifatters.assertions.section02.assertj;

public class Member {

    private int sequence;

    private String id;

    private String name;

    private int age;

    //alt+insert 단축키 사용
    //생성자
    public Member(int sequence, String id, String name, int age) {
        this.sequence = sequence;
        this.id = id;
        this.name = name;
        this.age = age;
    }

    //getter
    public int getSequence() {
        return sequence;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
