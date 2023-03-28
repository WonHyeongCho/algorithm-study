package test;

import java.util.Objects;

public class MyTest {
    public static void main(String[] args) {
        String s1 = "1";
        String s2 = "2";

        System.out.println("First, s1: " + s1 + ", s2: " + s2);
        System.out.println("First, s1: " + Objects.hash(s1) + ", s2: " + Objects.hash(s2));

        swap(s1, s2);

        System.out.println("Second, s1: " + s1 + ", s2: " + s2);
        System.out.println("Second, s1: " + Objects.hash(s1) + ", s2: " + Objects.hash(s2));
    }

    static private void swap(String s1, String s2) {
        String temp = s1;
        s1 = s2;
        s2 = temp;

        System.out.println("Third, s1: " + s1 + ", s2: " + s2);
        System.out.println("Third, s1: " + Objects.hash(s1) + ", s2: " + Objects.hash(s2));
    }
}
