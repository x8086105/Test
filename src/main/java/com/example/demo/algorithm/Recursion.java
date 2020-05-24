package com.example.demo.algorithm;

/**
 * @author ：xuemingming
 * @date ：Created in 2020/5/23 15:44
 * 递归
 */
public class Recursion {


    public static void main(String[] args) {
        int sideLength = sideLength(1680,640);
        int num = 1680*640/(sideLength*sideLength);
        System.out.println(num);
        int []nums = {1,2,3,45,7};
        int countNums = countNums(nums);
        System.out.println(countNums);
    }

    private static int factorial(int i){
        if(i == 1) {
            return 1;
        }
        return i * factorial(i - 1);
    }


    /**
     * 农场主分地
     * 长1680m 和 宽640m
     * 的土地分地
     * 尽可能分成面积比较大的正方形土地
     */
    private static int sideLength(int length,int weight){
        if(length == weight){
            return weight;
        }
        if(length%weight == 0){
            return weight;
        }
        int temp = weight;
        weight = length - (length/weight * weight);
        length = temp;
        return sideLength(length,weight);
    }

    /**
     * 使用递归方法解决数组之和
     * @param nums
     * @return
     */
    private static int countNums(int []nums){
        if(nums.length == 0){
            return 0;
        }
        int currentValue = nums[nums.length-1];
        int[] nums2 = new int[nums.length - 1];
        for(int i = 0;i<nums.length -1;i++){
            nums2[i] = nums[i];
        }
        return currentValue + countNums(nums2);
    }
}
