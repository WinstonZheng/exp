package com.winston.array;

import java.util.Objects;

/**
 * 双指针解决数组相关问题（单数组），双指针技巧主要分为两类：左右指针和快慢指针。
 * 典型题目：
 * 一，快速分区，根据某种限定条件，对数组进行划分；
 * 二、nSum问题（TODO）
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


    /**
     * 反转字符串数组
     * https://leetcode-cn.com/problems/reverse-string/submissions/
     * @param s
     */
    public void reverseString(char[] s) {
        for(int i = 0; i < s.length / 2; i++){
            swap(s, i, s.length - 1 - i);
        }
    }

    private void swap(char[] s, int n, int m){
        char tmpChar = s[n];
        s[n] = s[m];
        s[m] = tmpChar;
    }

    /**
     * https://leetcode-cn.com/problems/longest-palindromic-substring/submissions/
     * 计算最长回文子串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int longestPalindromeStartIndex = 0;
        int longestLength = 1;
        char[] cs = s.toCharArray();
        for(int startPointer = 0; startPointer + longestLength < s.length(); startPointer++){
            for(int endPointer = startPointer + 1; endPointer < s.length(); endPointer++){
                if(cs[endPointer] == cs[startPointer]){
                    if((endPointer - startPointer + 1 > longestLength) &&
                            isPalindrome(cs, startPointer, endPointer)){
                        longestLength = endPointer - startPointer + 1;
                        longestPalindromeStartIndex = startPointer;
                    }
                }
            }
        }
        return s.substring(longestPalindromeStartIndex, longestPalindromeStartIndex + longestLength);
    }


    private Boolean isPalindrome(char[] cs, int startIndex, int endIndex){
        while(startIndex < endIndex){
            if(cs[startIndex] != cs[endIndex]){
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }


    /** -------------nSum 问题------------- **/
    /**
     * 两数和，twoSum
     * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int leftPointer = 0, rightPointer = numbers.length - 1;
        while(leftPointer < rightPointer){
            int sum = numbers[leftPointer] + numbers[rightPointer];
            if(sum > target){
                rightPointer--;
            }else if(sum < target){
                leftPointer++;
            }else{
                return new int[]{leftPointer + 1, rightPointer + 1};
            }
        }
        return new int[]{};
    }




}
