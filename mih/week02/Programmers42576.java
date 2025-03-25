package week02;

import java.util.*;

public class Programmers42576 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> nameMap = new HashMap<>();
        String answer = "";
        for (String str : completion) {
            nameMap.put(str, nameMap.getOrDefault(str, 0) + 1);
        }
        for (String str : participant) {
            if (nameMap.getOrDefault(str, 0) == 0) {
                answer = str;
            } else {
                nameMap.put(str, nameMap.getOrDefault(str, 0) - 1);
            }
        }
        return answer;
    }
}
