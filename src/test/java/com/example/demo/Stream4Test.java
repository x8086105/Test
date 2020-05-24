package com.example.demo;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ：xuemingming
 * @date ：Created in 2019/12/27 10:49
 */
@SpringBootTest
public class Stream4Test {

    @Test
    public void test(){
        int []time = {1,2,3,3};
        int m =2;
    }
    public int minimalSteps(String[] maze) {

        String[][] ss = new String[3][3];
        for(int i = 0;i<maze.length;i++){
            char [] chars = maze[i].toCharArray();
            for(int j = 0;i<chars.length;j++){
                ss[i][j] = chars[j] +"";
            }
        }
        //计算第一段
        //S--->O
        //墙壁
        int[][] foodindex = new int[3][3];
        //石碓
        int[][] storeindex = new int[3][3];
        //机关
        int[][] biubiuindex =  new int[3][3];
        //终点
        int[][] overindex = new int[3][3];
        for(int i=0;i<ss.length;i++){
            for(int j=0;j<ss[i].length;j++){
                foodindex[i][j]= 0;
                storeindex[i][j]= 0;
                biubiuindex[i][j]= 0;
                overindex[i][j]= 0;
                if (ss[i][j].equals("#")) {
                    foodindex[i][j]= 1;
                }
                if(ss[i][j].equals("O")){
                    storeindex[i][j]=1;
                }
                if(ss[i][j].equals("T")){
                    foodindex[i][j]=1;
                }
                if(ss[i][j].equals("M")){
                    biubiuindex[i][j]=1;
                }
                if(ss[i][j].equals("T")){
                    overindex[i][j]=1;
                }
            }
        }
        int count = 0;
        for(int i=0;i<ss.length;i++){
            for (int j = 0; j < ss[i].length; j++) {
                count ++;

                if(ss[i][j].equals("O")){
                    //找到了石碓
                    System.out.println("找到了石碓，走过的路程是"+count);
                }
            }
        }
        return 0;
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
