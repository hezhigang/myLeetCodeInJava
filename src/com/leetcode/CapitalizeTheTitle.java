package com.leetcode;

/**
 * 2129. Capitalize the Title
 * https://leetcode.com/problems/capitalize-the-title/
 */
public class CapitalizeTheTitle {

    /**
     * 200 / 200 test cases passed.
     * Runtime: 10 ms, faster than 47.35% of Java online submissions for Capitalize the Title.
     * Memory Usage: 42.8 MB, less than 67.17% of Java online submissions for Capitalize the Title.
     * @param title
     * @return
     */
    public static String capitalizeTitle(String title) {
        String[] arr = title.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() <= 2)
                arr[i] = arr[i].toLowerCase();
            else {
                char[] charArr = arr[i].toCharArray();
                charArr[0] = Character.toUpperCase(charArr[0]);
                for (int j = 1; j < charArr.length; j++)
                    charArr[j] = Character.toLowerCase(charArr[j]);
                arr[i] = new String(charArr);
            }
        }
        return String.join(" ", arr);
    }

    public static void main(String[] args) {
        String title = "capiTalIze tHe titLe";
        String strOut = capitalizeTitle(title);
        System.out.printf("%s\n", title);
        System.out.printf("after Capitalize the Title = %s\n", strOut);
    }

}
