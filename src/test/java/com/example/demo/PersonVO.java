package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：xuemingming
 * @date ：Created in 2019/12/27 10:51
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonVO extends AbstractObject{
    private Integer id;
    private String name;
    private String sex;
    private volatile Integer age;

    public Hello hello;


    public void hello2(){
        System.out.println("person hello");
    }
}
