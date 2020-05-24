package com.example.demo;

/**
 * @author ：xuemingming
 * @date ：Created in 2019/10/13 17:45
 */
public class LinkNode {
    int value;
    LinkNode next;
    int index;

    public static LinkNode init(Integer [] ints){
        LinkNode nextLinkNode = null;
        LinkNode lastLinkNode = null;
        int i =0;
        for(int j = ints.length - 1;j>=0;j --){

            LinkNode currentLinkNode = new LinkNode();
            currentLinkNode.value = ints[j];
            currentLinkNode.index = i;
            currentLinkNode.next = nextLinkNode;
            nextLinkNode = currentLinkNode;
            if(j == ints.length-1){
                lastLinkNode = currentLinkNode;
            }
            if(j == 0){
                lastLinkNode.next = currentLinkNode;
            }
            i++;
        }

        return nextLinkNode;
    }
    public static Integer[] getByIndex(LinkNode linkNode,Integer index){
        if(linkNode != null){
            do{
                linkNode= linkNode.next;
                if(linkNode.value == index){
                    Integer [] a = {linkNode.value,linkNode.next.value,linkNode.next.next.value};
                    return a;
                }
            }while (index != linkNode.value);
        }
        return null;
    }
}
