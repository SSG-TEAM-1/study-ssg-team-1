package com.kyungbae.practice2;

import java.util.HashMap;

public class Refactoring {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        // 참가자 명단을 HashMap에 저장 (이름별 출현 횟수)
        for (String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }

        // 완주한 선수들을 HashMap에서 제거
        for (String player : completion) {
            map.put(player, map.get(player) - 1);
        }

        // 값이 1인 선수가 완주하지 못한 사람
        for (String key : map.keySet()) {
            if (map.get(key) > 0) {
                return key;
            }
        }

        return ""; // 예외 처리 (모든 선수 완주 시)
    }
}

