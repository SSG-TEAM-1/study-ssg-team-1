package com.kyungbae.practice1;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // 하샤드 수 구하기
    public static void main(String[] args) {
        System.out.println(solution(1111111));
    }

    public static boolean solution(int x) {
        boolean answer = false;

        // 리스트 배열에 숫자의 각 자리수 대입
        List<String> nums = new ArrayList<>();
        int y = x;
        while(y > 0){
            int split = y%10;
            nums.add(Integer.valueOf(split).toString());
            y = y/10;
        }

        // 리스트 배열에 들어있는 수를 누적 더하기
        int harshad = 0;
        for (String num : nums) {
            harshad += Integer.parseInt(num);
        }

        // x에 수를 나누어 하샤드수인지 확인
        if (x%harshad == 0){
            answer = true;
        }
        return answer;
    }
}
