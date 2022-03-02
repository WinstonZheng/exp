package com.winston.binary_search;

public class Main {

    /**
     * 基础的二分查找
     * https://leetcode-cn.com/problems/binary-search/
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int start = 0 , end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            // 如果target >= nums[mid]，边界不断往右移，所以，能找到最靠右与目标相等的数
            if(target < nums[mid]){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(nums[end] == target){
            return end;
        }
        if(nums[start] == target){
            return start;
        }
        return -1;
    }







}
