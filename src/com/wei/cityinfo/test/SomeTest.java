package com.wei.cityinfo.test;

public class SomeTest {
    public static void main(String[] args) {
        try {
            int a= 100/0;
            System.out.println("bbbb");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("aaaa");
        }
        System.out.println("cccc");
    }
}
