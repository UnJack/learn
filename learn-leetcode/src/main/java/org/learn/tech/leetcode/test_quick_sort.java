package org.learn.tech.leetcode;

/**
 * @link 快速排序
 * Created by jimjian on 2017/8/7.
 */
public class test_quick_sort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 7, 2, 4, 9, 6, 10, 8};
        sort(arr, 0, arr.length - 1);
        for (Integer i : arr)
            System.out.print(i + " ");
    }

    public static void sort(int[] arr, int l, int r) {
        if (l > r) {
            return;
        }
        int i = l, j = r, x = arr[l];
        while (i < j) {
            while (i < j && arr[j] >= x) {
                j--;
            }
            if (i < j) {
                arr[i++] = arr[j];
            }
            while (i < j && arr[i] < x) {
                i++;
            }
            if (i < j) {
                arr[j--] = arr[i];
            }
        }
        arr[i] = x;
        sort(arr, l, i - 1);
        sort(arr, i + 1, r);
    }

}
