package org.learn.tech.leetcode;

/**
 * @link 最长回文子串
 * </br>
 * <a href="https://leetcode.cn/problems/longest-palindromic-substring/description/">
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 * </a>
 */
public class test_longest_palindrome {

    public static void main(String[] args) {
        String str = "99991992391923";
        System.out.println(longestPalindrome(str));
    }

    public static String longestPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < str.length(); i++) {
            int len1 = expandAroundCenter(str, i, i);
            int len2 = expandAroundCenter(str, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return str.substring(start, end + 1);
    }

    /**
     * 中心扩展算法
     *
     * @param str
     * @param left
     * @param right
     * @return
     */
    private static int expandAroundCenter(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

}
