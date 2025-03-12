package com.kyungbae.practice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        String[] str1 = {"mislav", "stanko", "mislav", "ana"};
        String[] str2 = {"stanko", "ana", "mislav"};
        System.out.println(solution(str1, str2));
    }

    public static String solution(String[] participant, String[] completion) {
        // 마라톤 문제
        /*
            str1 과 str2 의 중복 검사
            중복횟수 1회 파악 시 제거
            participant, completion 둘 다 제거
            만약 중복 필터링 통과시 바로 리턴
         */

        List<String> list1 = new ArrayList<>(Arrays.asList(participant));
        List<String> list2 = new ArrayList<>(Arrays.asList(completion));
        String answer = null;

        for (int i = 0; i < list1.size();) {
            int count1 = 0;
            int count2 = 0;
            for (int j = 0; j < list2.size();) {
                if(count2 == (list2.size())){break;}
                if(list1.get(0).equals(list2.get(count2))){
                    list1.remove(0);
                    list2.remove(count2);
                    count1++;
                    break;
                }
                count2++;
            }
            if (count1 == 0){
                answer = list1.get(0);
                break;
            }
        }
        return answer;

    }
}
