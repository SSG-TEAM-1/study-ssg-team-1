package com.kyungbae.practice3;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        // 펠린드롬
        List<String> list = List.of ("aaba", "ba", "ababa", "bbaa", "baaba");

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (!list.get(i).equals(list.get(j))) {
                    String data = list.get(i) + list.get(j);
                    StringBuilder sb = new StringBuilder(data);
                    String reverse = sb.reverse().toString();
                    if (data.equals(reverse)) {
                        System.out.println(data);
                        count++;
                    }
                }
            }

        }
        if (count == 0){
            System.out.println(0);
        }
    }
}
