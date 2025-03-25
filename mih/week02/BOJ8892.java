package week02;

import java.util.*;

public class BOJ8892 {
    public static void main(String[] args) {
        int A, B;
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        for (int i = 0; i < A; i++) {
            B = sc.nextInt();
            sc.nextLine();
            List<String> strList = new ArrayList<>();
            for (int j = 0; j < B; j++) {
                strList.add(sc.nextLine());
            }
            String answer = "0";
            for (int k = 0; k < strList.size() - 1; k++) {
                String str1 = strList.get(k);
                for (int l = k + 1; l < strList.size(); l++) {
                    String str2 = strList.get(l);
                    if (isPalindrome(str1 + str2)) {
                        answer = str1 + str2;
                        break;
                    } else if (isPalindrome(str2 + str1)) {
                        answer = str2 + str1;
                        break;
                    }
                }
                if (!answer.equals("0")) {
                    break;
                }
            }
            System.out.println(answer);
        }
    }

    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
