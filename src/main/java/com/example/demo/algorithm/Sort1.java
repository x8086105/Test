package com.example.demo.algorithm;

/**
 * @author ：xuemingming
 * @date ：Created in 2020/5/23 15:03
 * 选择排序
 * 从小到大进行排序
 */
public class Sort1 {
    public static void main(String[] args) {
        int[] nums = {5,3,6,2,10};
        int[] nums2 = sort(nums);
        for(int i = 0;i < nums2.length; i++){

            System.out.println(nums2[i]);
        }
    }

    public static int[] sort(int []nums){
        for(int i = 0;i < nums.length - 1; i++){
            int k = i;
            // 选最小的记录
            for(int j = k + 1; j < nums.length; j++){
                if(nums[j] < nums[k]){
                    //记下目前找到的最小值所在的位置
                    k = j;
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            //交换a[i]和a[k]
            if(i != k){
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
            }
        }
        return nums;
    }
}
