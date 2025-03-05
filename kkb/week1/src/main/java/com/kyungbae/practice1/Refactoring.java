package com.kyungbae.practice1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Refactoring {
    public static void main(String[] args) {
        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

        int[] result = solution(today, terms, privacies);

        for (int arr : result) {
            System.out.println(arr);
        }
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate todayDate = LocalDate.parse(today, formatter);

        // 약관 정보를 Map으로 저장 (key: 약관명, value: 개월 수)
        HashMap<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] splitTerm = term.split(" ");
            termMap.put(splitTerm[0], Integer.parseInt(splitTerm[1]));
        }

        List<Integer> expiredList = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            String[] parts = privacies[i].split(" ");
            LocalDate privacyDate = LocalDate.parse(parts[0], formatter);
            int validMonths = termMap.get(parts[1]); // 해당 약관의 유효 개월 수

            // 개인정보 수집 날짜 + 유효 개월 수 추가
            LocalDate expirationDate = privacyDate.plusMonths(validMonths);

            // 유효 기간이 오늘 날짜보다 이전이면 삭제 대상
            if (!expirationDate.isAfter(todayDate)) {
                expiredList.add(i + 1);
            }
        }

        return expiredList.stream().mapToInt(Integer::intValue).toArray();
    }
}

