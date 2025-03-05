package com.kyungbae.practice1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {

        String today = DateTimeFormatter.ofPattern("yyyy.MM.dd").format(LocalDate.now());
        String[] terms = {"A 3", "B 12", "C 6"};
        String[] privacies = {"2024.10.21 A", "2024.03.04 B", "2025.01.25 C", "2023.01.20 A", "2024.01.01 C" };

        for (int i = 0; i < privacies.length; i++) {
            char term = privacies[i].charAt((privacies[i].indexOf(" "))+1);
            System.out.println("1. " + term);
            // => i번째 개인정보의 term
            int month = 0;
            for (int j = 0; j < terms.length; j++) {
                if (term == (terms[j].charAt(0))) {
                    month = Integer.parseInt(terms[j].substring(terms[j].indexOf(" ")+1));
                    System.out.println("2. " +month);
                    break;
                    // privacies의 약관을 terms에서 검사 후 유효기간 추출
                }
            }
            int mmOfPrivacies = Integer.parseInt(privacies[i].substring(privacies[i].indexOf(".")+1, privacies[i].lastIndexOf(".")));
            // privacies[i]의 월만 int로 추출
            System.out.println("3. " + mmOfPrivacies);
            int sumMonth = mmOfPrivacies + month;
            System.out.println("4. " + sumMonth);

            // 개인정보 수집 일자 추출
            String dateOfPrivacies = privacies[i].substring(0, privacies[i].lastIndexOf(" "));
            System.out.println("5. " + dateOfPrivacies);
            String[] eachDate = dateOfPrivacies.split("\\.");
            if (sumMonth - 12 > 0){
                char y = eachDate[0].charAt(3);
                System.out.println("y : " + y);
                char newY = String.valueOf(Integer.parseInt(String.valueOf(y))+1).charAt(0);
                System.out.println("newY : " + newY);
                eachDate[0] = eachDate[0].replace(eachDate[0].charAt(3), newY);
                sumMonth -= 12;
            }
            String result = DateTimeFormatter.ofPattern("yyyy.MM.dd").format(LocalDate.of(Integer.parseInt(eachDate[0]), sumMonth, Integer.parseInt(eachDate[2])));
//            int intToday = today.;
            System.out.println("유효기간 " + result + "까지, 오늘 : " + today);
            List<Integer> list = new ArrayList<>();
            int count=0;
            if( today.compareTo(result) > 0 ){
                System.out.println("유효기간 넘음 [" + (i +1) + "]");
                list.add(i+1);
                count++;
            }
            int[] finalResult;
            if (count > 0){
                finalResult = new int[count];
                for (int j = 0; j < finalResult.length; j++) {
                    finalResult[i] = list.get(i);
                }
            }


        }
    }
}
