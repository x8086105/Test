package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author ：xuemingming
 * @date ：Created in 2020/5/12 17:35
 */

@Slf4j
public class LeetCode53 {

    @Test
    public void test() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxValue = maxSubArray(nums);
        int maxValue2 = maxSubArray2(nums);
        log.info("maxValue:{}", maxValue);
        log.info("maxValue2:{}", maxValue2);
    }

    /**
     * 贪心算法
     *
     * @param nums
     * @return
     */
    private int maxSubArray(int[] nums) {
        //类似寻找最大最小值的题目，初始值一定要定义成理论上的最小最大值
        int result = Integer.MIN_VALUE;
        int numsSize = nums.length;
        //因为只需要知道dp的前一项，我们用int代替一维数组
        int dp = nums[0];
        result = dp;
        for (int i = 1; i < numsSize; i++) {
            dp = Integer.max(dp + nums[i], nums[i]);
            result = Integer.max(result, dp);
        }

        return result;
    }

    /**
     * 动态规划算法
     *
     * @param nums
     * @return
     */
    private int maxSubArray2(int[] nums) {
        int[] currentNums = new int[nums.length];
        int length = nums.length;
        currentNums[0] = nums[0];
        for (int i = 1; i < length; i++) {
            currentNums[i] = Integer.max( currentNums[i - 1] + nums[i] , nums[i]);
        }
        int max = currentNums[0];
        for (int i = 1; i < length - 1; i++) {
            if (max < currentNums[i]) {
                max = currentNums[i];
            }
        }
        return max;

    }
}

