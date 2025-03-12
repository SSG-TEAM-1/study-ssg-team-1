package com.kyungbae.practice3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Refectoring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfEx = sc.nextInt(); // 문제 개수 입력
        sc.nextLine(); // 개행 문자 제거

        List<String> answer = new ArrayList<>();

        for (int i = 0; i < numOfEx; i++) {
            int numOfStr = sc.nextInt(); // 단어 개수 입력
            sc.nextLine(); // 개행 문자 제거

            List<String> list = new ArrayList<>();
            for (int j = 0; j < numOfStr; j++) {
                list.add(sc.nextLine());
            }
            answer.add(findPalindromePair(list));
        }

        answer.forEach(System.out::println);
        sc.close();
    }

    public static String findPalindromePair(List<String> list) {
        int size = list.size();

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                String combined1 = list.get(i) + list.get(j);
                String combined2 = list.get(j) + list.get(i);

                if (isPalindrome(combined1)) {
                    return combined1;
                }
                if (isPalindrome(combined2)) {
                    return combined2;
                }
            }
        }

        return "0"; // 회문이 없을 경우
    }

    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
