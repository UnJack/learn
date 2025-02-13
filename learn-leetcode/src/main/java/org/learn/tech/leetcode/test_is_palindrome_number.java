package org.learn.tech.leetcode;

/**
 * @link 回文数
 * </br>
 * <a href="https://leetcode.cn/problems/palindrome-number/description/">
 * https://leetcode.cn/problems/palindrome-number/description/
 * </a>
 */
public class test_is_palindrome_number {

    public static void main(String[] args) {
        int num = 4;
        System.out.println(isPalindrome(num));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int num = 0;
        while (x > num) {
            num = num * 10 + x % 10;
            x /= 10;
        }
        return x == num || x == num / 10;
    }
}
