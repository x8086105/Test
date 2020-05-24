package com.example.demo;

import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author ：xuemingming
 * @date ：Created in 2019/12/27 10:49
 */
@SpringBootTest
public class Stream2Test {

    @Test
    public void test(){
        System.out.println(minTime(new int[] {5,3,2,1,1,4,1,4,1}, 2));
        System.out.println(minTime(new int[] {999, 999, 999}, 3));
    }
    class Result {
        boolean success;
        int maxTime;
        int count;

        public Result(boolean success, int maxTime, int count) {
            this.success = success;
            this.maxTime = maxTime;
            this.count = count;
        }
    }

    public int minTime(int[] time, int m) {
        if (time == null || time.length == 0 || time.length <= m) {
            return 0;
        }
        int total = 0;
        for (int t : time) {
            total += t;
        }
        int left = 0, right = total;
        int minTime = Integer.MAX_VALUE;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            Result res = tryTime(time, m, mid);
            if (!res.success) {
                left = mid;
            } else if (res.count <= m) {
                minTime = Math.min(minTime, res.maxTime);
                right = mid;
            }
        }
        Result res = tryTime(time, m, left);
        if (res.success) {
            minTime = Math.min(minTime, res.maxTime);
        }
        res = tryTime(time, m, right);
        if (res.success) {
            minTime = Math.min(minTime, res.maxTime);
        }
        return minTime;
    }

    private Result tryTime(int[] time, int m, int t) {
        int count = 0;
        int index = 0;
        int cur = 0;
        int max = 0;
        int maxTime = Integer.MIN_VALUE;
        while (index < time.length) {
            while (index < time.length && cur + time[index] - Math.max(max, time[index]) <= t) {
                cur += time[index];
                max = Math.max(max, time[index]);
                index++;
            }
            maxTime = Math.max(cur - max, maxTime);
            cur = 0;
            max = 0;
            count++;
            if (count > m) {
                return new Result(false, -1, -1);
            }
        }
        return new Result(true, maxTime, count);

    }
}
