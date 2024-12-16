package org.learn.tech.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @link 无重复字符的最长子串
 * </br>
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * </a>
 */
public class test04 {

    public static void main(String[] args) {
        String s = "abcbbcbb";
        System.out.println(maxSubLength(s));
    }

    public static int maxSubLength(String s) {
        //滑动窗口
        char[] ss = s.toCharArray();
        Set<Character> set = new HashSet<>();//去重
        int left = 0;
        int res = 0;//结果
        for (int right = 0; right < s.length(); right++) {//每一轮右端点都扩一个。
            char ch = ss[right];//right指向的元素，也是当前要考虑的元素
            while (set.contains(ch)) {//set中有ch，则缩短左边界，同时从set集合出元素
                set.remove(ss[left++]);
            }
            set.add(ch);//别忘。将当前元素加入。
            res = Math.max(res, right - left + 1);//计算当前不重复子串的长度。
        }
        return res;
    }
}
