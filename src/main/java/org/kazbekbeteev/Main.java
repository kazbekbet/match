package org.kazbekbeteev;

import org.kazbekbeteev.patternMatching.Match;

public class Main {
    public static void main(String[] args) {
        try {
            int age = 29;

            var user = Match.<Integer, String>of(age)
                    .when(28, () -> "Alex")
                    .when(29, () -> "John")
                    .when((val) -> val == 30, () -> "Leo")
                    .otherwise("Default")
                    .check();

            System.out.println(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}