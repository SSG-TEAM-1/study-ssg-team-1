package com.kyungbae.practice1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {


//        String today = DateTimeFormatter.ofPattern("yyyy.MM.dd").format(LocalDate.now());
        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        int[] result = solution(today, terms, privacies);

        for (int arr : result) {
            System.out.println(arr);
        }
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        /*

            privacies 의 공백 다음 문자를 terms와 비교하여 terms의 공백 다음항목(숫자) 가져오기
            가져온 terms의 공백 다음 문자(숫자)를 privacies의 공백 전(날짜)에 월에 추가
            추가된 날짜가 현재 날짜보다 적은 경우 인덱스 를 int[]에 추가
            int[] 반환
         */

        int count = 0;
        int[] finalResult = null;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            char term = privacies[i].charAt((privacies[i].indexOf(" ")) + 1);
//            System.out.println("1. " + term);
            // => i번째 개인정보의 term
            int month = 0;
            for (int j = 0; j < terms.length; j++) {
                if (term == (terms[j].charAt(0))) {
                    month = Integer.parseInt(terms[j].substring(terms[j].indexOf(" ") + 1));
//                    System.out.println("2. " +month);
                    break;
                    // privacies의 약관을 terms에서 검사 후 유효기간 추출
                }
            }
            int mmOfPrivacies = Integer.parseInt(privacies[i].substring(privacies[i].indexOf(".") + 1, privacies[i].lastIndexOf(".")));
            // privacies[i]의 월만 int로 추출
//            System.out.println("3. " + mmOfPrivacies);
            int sumMonth = mmOfPrivacies + month;
//            System.out.println("4. " + sumMonth);

            // 개인정보 수집 일자 추출
            String dateOfPrivacies = privacies[i].substring(0, privacies[i].lastIndexOf(" "));
//            System.out.println("5. " + dateOfPrivacies);
            String[] eachDate = dateOfPrivacies.split("\\.");
            int year = Integer.parseInt(eachDate[0]);
            if (sumMonth - 12 > 0) {
//                char y = eachDate[0].charAt(3);
////                System.out.println("y : " + y);
//                char newY = String.valueOf(Integer.parseInt(String.valueOf(y))+1).charAt(0);
////                System.out.println("newY : " + newY);
//                eachDate[0] = eachDate[0].replace(eachDate[0].charAt(3), newY);
                year = (Integer.parseInt(eachDate[0])) + 1;
                System.out.println(year);
                sumMonth -= 12;
            }
            String result = DateTimeFormatter.ofPattern("yyyy.MM.dd").format(LocalDate.of(year, sumMonth, Integer.parseInt(eachDate[2])));
            String[] eachToday = today.split("\\.");
            LocalDate date0 = LocalDate.of(Integer.parseInt(eachToday[0]), Integer.parseInt(eachToday[1]), Integer.parseInt(eachToday[2]));
            LocalDate date1 = LocalDate.of(year, sumMonth, Integer.parseInt(eachDate[2]));
//            int intToday = today.;
            System.out.println("유효기간 " + result + "까지, 오늘 : " + today);
            if (date0.isAfter(date1) || date0.equals(date1)) {
                System.out.println("유효기간 넘음 [" + (i + 1) + "]");
                list.add(i + 1);
                count++;
            }


        }
        finalResult = new int[count];
        if (count > 0) {
            for (int j = 0; j < finalResult.length; j++) {
                finalResult[j] = list.get(j);
            }
        }

        return finalResult;

    } // method end
} // class end
