package com.edu.xust;

enum Second {
    X(1,"xxx"),U(2,"uuu"),P(3,"ppp"),A(4,"aaa"),N(5,"nnn");
    private final int value;
    private final String description;

    Second(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}

public class First{
    public static void main(String[] args) {
        for (Second i : Second.values()) {
            System.out.println(i.getValue() + "   " + i.getDescription());
        }
    }
}
