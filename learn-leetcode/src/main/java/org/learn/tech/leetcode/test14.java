package org.learn.tech.leetcode;

/**
 * @link 验证回文串
 * </br>
 * <a href="https://leetcode.cn/problems/XltzEq/solutions/1398915/you-xiao-de-hui-wen-by-leetcode-solution-uj86/">
 * https://leetcode.cn/problems/XltzEq/solutions/1398915/you-xiao-de-hui-wen-by-leetcode-solution-uj86/
 * </a>
 */
public class test14 {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        StringBuilder stringBuffer = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (Character.isLetterOrDigit(aChar)) {
                stringBuffer.append(Character.toLowerCase(aChar));
            }
        }
        String newString = stringBuffer.toString();
        int l = 0;
        int r = newString.length() - 1;
        while (l < r) {
            if (newString.charAt(l++) != newString.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

}
