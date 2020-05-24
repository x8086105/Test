package com.example.demo;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ：xuemingming
 * @date ：Created in 2020/4/17 21:06
 * leetCode 35
 */
@SpringBootTest
public class SearchInsertPoint {

    @Test
    public void test(){
        int[] nums= {1,2};
        int target = 0;
        int point = searchInsert(nums,target);
        System.out.println(point);
    }

    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        for(int i = 0;i<length;i++){
            if(target <= nums[i]){
                return i;
            }
            if(i + 1 < length){
                if(target<=nums[i+1]){
                    return i+1;
                }
            }

        }

        return length;
    }
}
