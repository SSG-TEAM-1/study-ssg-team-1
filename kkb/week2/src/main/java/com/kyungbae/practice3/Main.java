package com.kyungbae.practice3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 펠린드롬


        List<String> answer = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // 문제 입력 받기
        // 문제 개수 입력, 넣을 단어 개수 입력, 단어 입력
        int numOfEx = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numOfEx; i++) {
            List<String> list = new ArrayList<>();
            int numOfStr = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < numOfStr; j++) {
                list.add(sc.nextLine());
            }
            answer.add(solve(list));
        }
        answer.forEach(System.out::println);
    }

    public static String solve(List<String> list){

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (!list.get(i).equals(list.get(j))) {
                    String data = list.get(i) + list.get(j);
                    StringBuilder sb = new StringBuilder(data);
                    String reverse = sb.reverse().toString();
                    if (data.equals(reverse)) {
                        return data;
                    }
                }
            }

        }
        return "0";

    }
}
