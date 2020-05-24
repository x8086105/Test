package com.example.demo;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ：xuemingming
 * @date ：Created in 2020/4/25 14:55
 */
@SpringBootTest
public class TheSmastTest {
    @Test
    public void test1(){
        int[] nums = {-3,2,-3,4,2};
        System.out.println(minStartValue(nums));
    }
    public int minStartValue(int[] nums) {
        int min = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(min > min + nums[i]){
                min = min + nums[i];
            }
        }
        if(min>=0){
            min = 1;
        }else{
            min = 1-min;
        }
        return min;
    }
}
