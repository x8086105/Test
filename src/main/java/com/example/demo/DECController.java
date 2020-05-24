package com.example.demo;

import com.zuowenzhitiao.des.service.DESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author ：xuemingming
 * @date ：Created in 2019/10/22 18:04
 */
@RestController
@RequestMapping("dec")
public class DECController {
    @Autowired
    private DESService desService;
    @GetMapping("encode")
    public String encode(@RequestParam("phone") String phone){
        String resut = desService.encrypt(phone);
        return resut;
    }
    @PostMapping("dencode")
    public String dencode(@RequestBody String encode){
        String resut = desService.decrypt(encode);
        return resut;
    }
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(Integer.valueOf(x));
        char[] chars = s.toCharArray();
        int length = s.length();
        int size = length/2;
        for(int i = 0;i<size;i++){
            if(chars[i] != chars[chars.length - i - 1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
//        Integer[]userIds2 = {1,2,3,4,5,6,7,8,9,0,12,312,43,53,5,6,5,7,65464,3};
//        Integer[] ids = Arrays.copyOfRange(userIds2,5,userIds2.length);
//        for(Integer i : ids){
//
//            System.out.println(i);
//        }
        boolean flag = isPalindrome(11211);
        System.out.println(flag);
        String s = new StringBuilder("132").reverse().toString();
        int count = romanToInt("MCMXCIV");
        System.out.println(count);

        String commonPrefix = longestCommonPrefix("a,b,v".split(","));
        System.out.println(commonPrefix);
        int [] is = Arrays.stream("1,1,2".split(",")).mapToInt(Integer::valueOf).toArray();
        removeDuplicates(is);
    }

        public static int romanToInt(String s) {
            char[] chars = s.toCharArray();
            LinkNode linkNode = createLinkNode(chars);
            int count = 0;
            while (linkNode != null){
                Integer c = linkNode.score;
                if(linkNode.next!=null &&(c*5 == linkNode.next.score || c*10 == linkNode.next.score)){
                    count += linkNode.next.score-linkNode.score;
                    linkNode = linkNode.next.next;
                }else{
                    count += linkNode.score;
                    linkNode = linkNode.next;
                }
            }
            return count;
        }

    private static LinkNode createLinkNode(char[] chars) {
        LinkNode preLink = null;
        for(int i = chars.length -1;i>=0;i--){
            LinkNode cLink = new LinkNode();
            cLink.init(i,chars[i],preLink);
            preLink = cLink;
        }
        return preLink;
    }

    private static class LinkNode{
            private int index;
            private Character current;
            private LinkNode next;
            private Integer score;

            public LinkNode init(int index, Character current, LinkNode next){
                this.index = index;
                this.current = current;
                this.next = next;
                this.score= ROMENUM.valueOf(this.current.toString()).size;
                return this;
            }

        }
    private enum ROMENUM{
        I("I",1),
        V("V",5),
        X("X",10),
        L("L",50),
        C("C",100),
        D("D",500),
        M("M",1000);
        private String ch;
        private Integer size;
        ROMENUM(String ch,Integer size){
            this.ch = ch;
            this.size = size;
        }

    }

    public static String longestCommonPrefix(String[] strs) {
        String commonPrefix = strs[0];
        for(int i = 1;i<strs.length;i++){
            //获取公共前缀循环的次数
            int forSize = commonPrefix.length()<strs[i].length()?commonPrefix.length():strs[i].length();
            while (forSize>=0){
                if(commonPrefix.substring(0,forSize).equals(strs[i].substring(0,forSize))){
                    commonPrefix = commonPrefix.substring(0,forSize);
                    break;
                }else if(forSize == 0){
                    commonPrefix="";
                }
                forSize--;
            }
        }
        return commonPrefix;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {return 0;}
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        for (int num : nums) {

            System.out.println(num);
        }

        String sss = "sss";
        String s[] = sss.split("sss");
        int is = s.length;
        return i + 1;
    }
}
