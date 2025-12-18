package com.leetcode.utils;

/**
 * 数组工具类
 * 包含常用的数组操作方法
 */
public class ArrayUtils {

    /**
     * 冒泡排序
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     * 
     * @param nums 待排序的数组
     * @return 排序后的数组（原地排序）
     */
    public static int[] bubbleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    // 交换元素
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    /**
     * 打印数组
     * @param nums 要打印的数组
     */
    public static void printArray(int[] nums) {
        if (nums == null) {
            System.out.println("null");
            return;
        }
        
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * 交换数组中两个位置的元素
     * @param nums 数组
     * @param i 第一个位置
     * @param j 第二个位置
     */
    public static void swap(int[] nums, int i, int j) {
        if (nums == null || i < 0 || j < 0 || i >= nums.length || j >= nums.length) {
            return;
        }
        
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
