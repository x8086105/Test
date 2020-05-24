package com.example.demo;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：xuemingming
 * @date ：Created in 2020/4/17 21:47
 * 可外观化队列38
 */
@SpringBootTest
public class appearanceQueue {
    @Test
    public void test(){
        int n = 4;
        System.out.println(countAndSay(n));
    }
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String overStr = "1";
        for(int i=2;i <= n;i++){
            overStr = say(overStr);
            System.out.println(i+":"+overStr);
        }
        return overStr;
    }

    private String say(String overStr) {

        char [] c = overStr.toCharArray();
        List<Map<Integer,Integer>> stringList = new ArrayList<>();
        for(int i = 0;i<c.length;i++){

             if(stringList.size()>0){
                 Map<Integer,Integer> integerMap  = stringList.get(stringList.size()-1);
                 if(integerMap.containsKey(Integer.parseInt(c[i]+""))){
                     integerMap.put(Integer.parseInt(c[i]+""),integerMap.get(Integer.parseInt(c[i]+""))+1);
                 }else{
                     integerMap = new HashMap<>();
                     integerMap.put(Integer.parseInt(c[i]+""),1);
                     stringList.add(integerMap);
                 }
            }else{
                 Map<Integer,Integer> integerMap  = new HashMap<>();
                 integerMap.put(Integer.parseInt(c[i]+""),1);
                 stringList.add(integerMap);
             }
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<stringList.size();i++){
            Map<Integer,Integer> integerMap  =  stringList.get(i);
            integerMap.forEach((k,v)->{
                sb.append(v).append(k);
            });
        }
        return sb.toString();
    }
}
