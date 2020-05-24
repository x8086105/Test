package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：xuemingming
 * @date ：Created in 2019/12/27 10:50
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO extends AbstractObject{
    private Integer id;
    private String name;
    private String sex;
    private Integer age;

}
