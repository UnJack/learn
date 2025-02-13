package org.learn.tech.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @link 电话号码的字母组合
 * </br>
 * <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/">
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/
 * </a>
 */
public class test_phone_num_combination {

    public static void main(String[] args) {
        System.out.println(letterCombinations("799"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        backtrack(result, phoneMap, digits, 0, new StringBuffer());
        return result;
    }

    /**
     * @param combinations 所有组合
     * @param phoneMap     数字字典
     * @param digits       数字
     * @param index        下标
     * @param combination  组合
     */
    private static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index,
                                  StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int letterCount = letters.length();
            for (int i = 0; i < letterCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

}
