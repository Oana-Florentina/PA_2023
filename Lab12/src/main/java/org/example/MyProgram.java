package org.example;

import org.example.annotation.Test;

public class MyProgram {
    @Test
    public static void m1() {
        System.out.println("m1");
    }
    public static void m2() {
        System.out.println("m2");
    }
    @Test
    public static void m3() {
        System.out.println("m3");
    }
    public static void m4() { }
    @Test public static void m5() {
        System.out.println("m5");
    }
    public static void m6() { }
    @Test public static void m7() {
        System.out.println("m7");
    }
    @Test
    public void m8() {
        System.out.println("m8");
    }
}