package com.kyungbae.practice2;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

         System.out.println(palindrom(str));

    }

    public static String palindrom(String str){

        String result = "I'm Sorry Hansoo";

        /*
            알파벳 요소별로 모아서 개수 및 짝수 체크,
            홀수가 2개 이상이면 무조건 false
            알파벳 순서대로 반으로 나누어 양쪽끝에 배치
            홀수개 있는 알파벳 1개는 가운데 배치
         */

        // 알파벳 요소별로 묶기
        Map<Character, Integer> alpha = new HashMap<>();
        for (int i = 0; i <str.length() ; i++) {
            alpha.put(str.charAt(i), alpha.getOrDefault(str.charAt(i), 0) + 1);
        }

        // 홀수 개수 확인
        int oddCount = 0;
        char oddChar = ' ';
        for (Map.Entry<Character, Integer> count : alpha.entrySet()){
            if (count.getValue() % 2 != 0) {
                oddCount++;
                oddChar = count.getKey();
            }
        }

        // 홀수가 2개 이상이면 종료
        if (oddCount > 1) {
            return result;
        }

        // 알파벳 순서대로 정렬하기
        List<Character> sortAlpha = new ArrayList<>(alpha.keySet());
        Collections.sort(sortAlpha);

        // 문자 합치기
        StringBuilder leftChar = new StringBuilder();
        StringBuilder rightChar = new StringBuilder();
        StringBuilder cenChar = new StringBuilder();

        for (char c : sortAlpha) {
            int count = alpha.get(c);
            String r = String.valueOf(c).repeat(count/2);
            leftChar.append(r);
            rightChar.insert(0, r);

            if (count % 2 != 0) {
                cenChar.append(c);
            }
        }

        result = leftChar.toString() + cenChar.toString() + rightChar.toString();

        return result;
    }

}
