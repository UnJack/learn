package org.learn.tech.leetcode;

/**
 * @link Pow(x, n)
 * </br>
 * <a href="https://leetcode.cn/problems/powx-n/solutions/238559/powx-n-by-leetcode-solution/">
 * https://leetcode.cn/problems/powx-n/solutions/238559/powx-n-by-leetcode-solution/
 * </a>
 */
public class test_my_pow {

    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
    }

    public static double myPow(double x, int n) {
        long m = n;
        return m >= 0 ? quickMul(x, m) : 1.0 / quickMul(x, -m);
    }

    private static double quickMul(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

}
