package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ：xuemingming
 * @date ：Created in 2020/4/26 17:18
 */
@Data
@AllArgsConstructor
@Builder
public class Hello {
    public void h(){
        System.out.println("helloClass----hello");
    }
}
