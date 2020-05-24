package com.example.demo;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ：xuemingming
 * @date ：Created in 2020/4/25 18:45
 */
@SpringBootTest
public class TT {
    @Test
    public void test() throws InterruptedException {
//        PersonVO personVO = PersonVO.builder()
//                .age(12)
//                .id(1)
//                .build();
//        Field [] fields = personVO.getClass().getDeclaredFields();
//        System.out.println(personVO);
//        for(int i=0;i<fields.length;i++){
//            Field field = fields[i];
//            field.setAccessible(true);
//            if("age".equals(field.getName())){
//                field.set(personVO,null);
//            }
//        }
//        Hello hello = (Hello) personVO.getClass().getField("hello").get(personVO);
//        hello.h();
//        System.out.println(personVO);

        ThreadSafe safe = new ThreadSafe();
        safe.start();
        Thread.sleep(5000);
        safe.stop();
        Thread.sleep(5000);
    }


}
