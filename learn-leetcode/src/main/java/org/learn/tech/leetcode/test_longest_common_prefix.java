package org.learn.tech.leetcode;

/**
 * @link 最长公共前缀
 * </br>
 * <a href="https://leetcode.cn/problems/longest-common-prefix/description/">
 * https://leetcode.cn/problems/longest-common-prefix/description/
 * </a>
 */
public class test_longest_common_prefix {

    public static void main(String[] args) {
        String[] str = {"aaa", "aa", "aaa"};
        String commonPrefixString = "";
        for (int i = 1; i < str.length; i++) {
            String prefixString = longestCommonPrefix(str[0], str[i]);
            if (commonPrefixString.isEmpty() && !prefixString.isEmpty()) {
                commonPrefixString = prefixString;
            } else {
                commonPrefixString = commonPrefixString.length() < prefixString.length() ?
                        commonPrefixString : prefixString;
            }
        }
        System.out.println(commonPrefixString);
    }

    public static String longestCommonPrefix(String pre, String str) {
        int length = Math.min(pre.length(), str.length());
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (pre.charAt(i) == str.charAt(i)) {
                index++;
            }
        }
        return pre.substring(0, index);
    }
}
