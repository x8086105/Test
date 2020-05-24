package com.example.demo.algorithm;

/**
 * @author ：xuemingming
 * @date ：Created in 2020/5/23 14:18
 * 这个是二分查找算法的实现
 */
public class Search1 {

    public static void main(String[] args) {
        int []nums = {1,2,3,4,5,6,7,8};
        System.out.println(search(nums,2));

        System.out.println(search2(nums,0,nums.length-1,2));
    }

    /**
     * 在一个有序的数组中，查找一个值为num
     *
     * @param nums
     * @param num
     */
    public static int search(int []nums,int num){
       int min = 0;
       int max = nums.length - 1;
       while (min <= max){
           int mid = (min + max)/2;
           if(nums[mid] == num){
               return mid;
           }
           if(nums[mid] < num){
               min = mid + 1;
           }
           if(nums[mid] > num){
               max = mid - 1;
           }
       }
       return -1;
    }

    private static int search2(int []nums,int min,int max,int num){
        if(min > max){
            return -1;
        }
        int mid = (max+min)/2;
        if(nums[mid] < num){
            return search2(nums,mid+1,max,num);
        }
        if(nums[mid] > num){
            return search2(nums,min,mid-1,num);
        }
        return mid;
    }




















}
