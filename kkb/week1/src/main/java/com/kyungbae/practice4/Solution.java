package com.kyungbae.practice4;

public class Solution {
    public static void main(String[] args) {

        String str = "laskdjmfsl";
        System.out.println(str);

        int ran1 = (int)(Math.random() * (str.length()-2) + 1);
        int ran2 = (int)(Math.random() * (str.length()-ran1-1) + (ran1+1));

//        System.out.println("길이 : " + str.length() + ", " + ran1 + ", " + ran2);

        String str1 = str.substring(0, ran1);
        String str2 = str.substring(ran1, ran2);
        String str3 = str.substring(ran2);

        System.out.println(str1 + "/" + str2 + "/" + str3);

        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        char[] charArr3 = str3.toCharArray();

        char[] rotArr1 = new char[charArr1.length];
        for (int i = 0; i < charArr1.length; i++) {
            rotArr1[i] = charArr1[(charArr1.length-1) - i];
        }
        char[] rotArr2 = new char[charArr2.length];
        for (int i = 0; i < charArr2.length; i++) {
            rotArr2[i] = charArr2[(charArr2.length-1) - i];
        }
        char[] rotArr3 = new char[charArr3.length];
        for (int i = 0; i < charArr3.length; i++) {
            rotArr3[i] = charArr3[(charArr3.length-1) - i];
        }

        StringBuilder sb1 = new StringBuilder();
        String rotate1 = sb1.append(rotArr1).toString();

        StringBuilder sb2 = new StringBuilder();
        String rotate2 = sb2.append(rotArr2).toString();

        StringBuilder sb3 = new StringBuilder();
        String rotate3 = sb3.append(rotArr3).toString();

        System.out.println(rotate1 + "/" + rotate2 + "/" + rotate3);

        String result = rotate1+rotate2+rotate3;

        System.out.println(result);



    }

}
