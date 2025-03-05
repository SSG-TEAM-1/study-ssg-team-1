package com.kyungbae.practice3;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(59842));

    }
    public static int solution(int n) {
        int answer = 0;
        /*
            10 -> 3
            12 -> 11
            573432 ->
         */
        if ((n-1) % 2 == 0){ // n이 홀수일때
            answer = 2;
        } else {
            for (int i = 3; i < n; i += 2) {
                if(n % i == 1){
                    answer = i;
                    break;
                }
            }
        }
        return answer;
    }
}
