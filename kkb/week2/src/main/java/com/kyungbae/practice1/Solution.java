package com.kyungbae.practice1;

public class Solution {
    public static void main(String[] args) {
        // 콜라 문제

        int a = 3;
        int b = 1;
        int n = 20;

        int count = 0;
        int less = 0;
        while (n >= 1){
            n = n+less;
            less = (n%a);
            n = (n/a)*b;
            count += n;
        }
        System.out.println(count);
    }
}
