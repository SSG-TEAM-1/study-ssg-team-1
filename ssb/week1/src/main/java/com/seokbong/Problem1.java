package com.seokbong;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("a : ");
        int a = sc.nextInt();
        System.out.println("b : ");
        int b = sc.nextInt();
        for (int j = 0; j < b; j++) {
            for (int i = 0; i < a; i++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}
