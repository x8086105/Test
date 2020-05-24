package com.example.demo;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：xuemingming
 * @date ：Created in 2019/12/27 10:49
 */
@SpringBootTest
public class StreamTest {

    @Test
    public void test(){
        List<PersonDTO> dtos = initDTOs();
        List<PersonVO> vos = dtos.parallelStream().map(o->{
            System.out.println(1);
            PersonVO vo = o.clone(PersonVO.class);
            return vo;
        }).filter(doo -> doo.getId() != null).collect(Collectors.toList());
        List<PersonVO> vos2 = dtos.parallelStream().map(o->{
            PersonVO vo = BeanUtils.copy(o,PersonVO.class);
            return vo;
        }).filter(doo -> doo.getId() != null).collect(Collectors.toList());
        System.out.println("dtos.size:==="+dtos.size());
        System.out.println("vos.size:==="+vos.size());
        System.out.println("vos2.size:==="+vos2.size());
        vos2.removeAll(vos);
        for(PersonVO vo : vos2){

            System.out.println(vo.getId());
        }
    }

    private List<PersonDTO> initDTOs() {
        List<PersonDTO> dtos = Lists.newArrayList();
        for(int i = 0; i < 1000 ; i++){
            PersonDTO dto = PersonDTO.builder()
                    .age(10)
                    .id(i)
                    .name("xx"+i)
                    .sex("x"+i)
                    .build();
            dtos.add(dto);
        }


        return dtos;
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
