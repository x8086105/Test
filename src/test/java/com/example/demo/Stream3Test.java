package com.example.demo;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：xuemingming
 * @date ：Created in 2019/12/27 10:49
 */
@SpringBootTest
public class Stream3Test {

    @Test
    public void test(){
        int []time = {1,2,3,3};
        int m =2;
        System.out.println(minTime2(time,m));
    }
    public int minTime(int[] time, int m) {
        int count = time.length;
        //m天时间内完成count的题目
        int avg = count/m;
        if(avg == 0){
            return 0;
        }
        int shengxiade = count - m*avg;
        if(shengxiade == 0){
            //每天平均下来完成avg道题目 avg-1 就是题主完成的题目
            int zijisuan = avg -1;
            if(zijisuan == 0){
                return 0;
            }else{
                //两两组合那最小，或者多个组合那最小 至于几个组合那最小要看降下来的数字是什么
                return zijisuanTime(zijisuan,time);

            }
        }else {
            int zijisuan = avg -1 + shengxiade;
            return zijisuanTime(zijisuan,time);
        }
    }

    public int zijisuanTime(int zijisuan,int[]time){

        int min = 0;
        for(int i =0;i<zijisuan;i++){
            min +=time[i];
        }
        for (int i =1;i<time.length-zijisuan;i++){
            int min2 = 0;
            for(int j =i;j<zijisuan+i;j++){
                min2 +=time[j];
            }
            if(min > min2){
                min = min2;
            }
        }
        return min;
    }


    public int minTime2(int[] time, int m) {

        int count = time.length;

        //m天时间内完成count的题目
        int zijisuan = count - m;
        return zijisuanTime(zijisuan,time);
    }
//    private List<PersonDTO> initDTOs1() {
//        List<PersonDTO> dtos = Lists.newArrayList();
//        dtos.parallelStream().forEach(e->{
//            int i = 1;
//            PersonDTO dto = PersonDTO.builder()
//                    .age(10)
//                    .id(i)
//                    .name("xx" + i)
//                    .sex("x" + i)
//                    .build();
//            dtos.add(dto);
//                }
//        );
//        for(int i = 0; i < 5 ; i++){
//
//        }
//
//
//        return dtos;
//    }
}
