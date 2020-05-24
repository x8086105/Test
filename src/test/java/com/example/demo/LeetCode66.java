package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author ：xuemingming
 * @date ：Created in 2020/5/12 17:35
 */

@Slf4j
public class LeetCode66 {

    @Test
    public void test() {
        int[] count = plusOne(new int[]{1,2,3});
        for(int i=0;i<count.length;i++){
            System.out.println(count[i]);
        }
    }

    /**
     * 官方题解
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }


    /**
     * 官方题解
     */
    public int lengthOfLastWord2(String s){
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' '){
            end --;
        }
        if(end < 0){
            return 0;
        }
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }
}

