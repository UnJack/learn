package org.learn.tech.leetcode;

/**
 * Created by jimjian on 2016/9/1.
 */
public class test_binarySearch {

    public static void main(String[] args) {
        int[] arrays = {2, 8, 10, 16, 64, 512, 1024};
        System.out.println(BinSearch(arrays, 10));
        System.out.println(BinSearch(arrays, 0, arrays.length - 1, 10));
    }

    /**
     *
     * @param arr
     * @param tag
     * @return
     */
    public static int BinSearch(int[] arr, int tag) {
        int mid;
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            mid = (l + r) / 2;
            if (arr[mid] > tag) {
                r = mid - 1;
            } else if (arr[mid] < tag) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 递归方法实现二分查找法.
     *
     * @param arr
     * @param l   数组第一位置
     * @param r   最高
     * @param tag 要查找的值.
     * @return 返回值.
     */
    public static int BinSearch(int[] arr, int l, int r, int tag) {
        if (l <= r) {
            int mid = (l + r) / 2;
            if (tag > arr[mid]) {
                return BinSearch(arr, mid + 1, r, tag);
            } else if (tag < arr[mid]) {
                return BinSearch(arr, l, mid - 1, tag);
            } else {
                return mid;
            }
        } else {
            return -1;
        }
    }
}