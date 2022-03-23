package com.winston.array;

import java.util.Objects;

/**
 * 双指针解决数组相关问题（单数组）
 * 一，快速分区，根据某种限定条件，对数组进行划分；
 *
 */
public class TwoPointer {

    /**
     * 使用双指针，去除有序数组的重复项
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums == null){
            return 0;
        }
        int slowPointer = 0, fastPointer = 1;
        while(fastPointer < nums.length){
            if(nums[slowPointer] != nums[fastPointer]){
                slowPointer++;
                nums[slowPointer] = nums[fastPointer];
            }
            fastPointer++;
        }
        return slowPointer + 1;
    }


    /**
     * 在数组中删除指定的数字
     * https://leetcode-cn.com/problems/remove-element/
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if(Objects.isNull(nums)){
            return 0;
        }
        int finalResultPointer = -1, pointer = 0;
        while(pointer < nums.length){
            if(nums[pointer] != val){
                finalResultPointer++;
                nums[finalResultPointer] = nums[pointer];
            }
            pointer++;
        }
        return finalResultPointer + 1;
    }


    /**
     * 将0移到一边
     * https://leetcode-cn.com/problems/move-zeroes/submissions/
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if(Objects.isNull(nums)){
            return;
        }
        int nonZeroPointer = -1, pointer = 0;
        while(pointer < nums.length){
            if(nums[pointer] != 0){
                nonZeroPointer++;
                swap(nums, nonZeroPointer, pointer);
            }
            pointer++;
        }
    }

    private void swap(int[] nums, int x, int y){
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }







}
