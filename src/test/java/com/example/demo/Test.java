package com.example.demo;

import javafx.util.Callback;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Maps;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author ：xuemingming
 * @date ：Created in 2019/10/13 17:45
 */
@SpringBootTest
public class Test {

    @org.junit.Test
    public void test(){
        Integer [] ints = {4,6,8,2,0,5,7};
        LinkNode linkNode = LinkNode.init(ints);
        System.out.println(linkNode);
        Integer []integers = LinkNode.getByIndex(linkNode,0);
        Arrays.stream(integers).forEach(System.out::println);
    }
    @org.junit.Test
    public void test2() throws Exception {
        System.out.println(System.currentTimeMillis());
        PersonVO personVO = new PersonVO();

        CompletableFuture<Map<String,Object>> future1 = CompletableFuture.supplyAsync(() -> {
            HashMap<String,Object> result = new HashMap<>();
            HashMap<Long,Long> map1 = new HashMap<>();
            map1.put(1L,2L);
            result.put("r1",map1);
            HashMap<Long,List<PersonVO>> map2 = new HashMap<>();
            map2.put(1L,Lists.newArrayList(PersonVO.builder().age(1).build()));

            result.put("r2",map2);
            return result;
        });
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                ThreadLocal<PersonVO> threadLocal = new ThreadLocal<>();
                personVO.setAge(222);
                threadLocal.set(personVO);
                System.out.println("k2 start"+System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println(threadLocal.get().getAge());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 0;
        });
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("k3 start"+System.currentTimeMillis());
                Thread.sleep(3000);
                System.out.println("k3 end"+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 0;
        });

        Integer count3 = future3.get();

        Integer count2 =  future2.get();

        Map<String,Object> count = future1.get();
        HashMap<Long,List<PersonVO>> s = (HashMap<Long, List<PersonVO>>) count.get("r2");
        HashMap<Long,Long> s2 = (HashMap<Long, Long>) count.get("r1");


    }
    public void te(){
        HashMap map = null;
        map.isEmpty();
    }

}
