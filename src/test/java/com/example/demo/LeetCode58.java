package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author ：xuemingming
 * @date ：Created in 2020/5/12 17:35
 */

@Slf4j
public class LeetCode58 {

    @Test
    public void test() {
        int count = lengthOfLastWord2("Hello World");
        System.out.println(count);
    }

    public int lengthOfLastWord(String s){
        s = s.trim();
        if(s.equals("")){
            return 0;
        }
        char []chars = s.toCharArray();
        int count = 0;

        for(int i = chars.length - 1; i >= 0; i--){
            char c = chars[i];
            if((c +"").equals(" ")){
                break;
            }
            count++;
        }
        return count;
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

