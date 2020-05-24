package com.example.demo;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author ：xuemingming
 * @date ：Created in 2020/1/18 15:30
 */
@SpringBootTest
public class TwoNumberCount {

    @Test
    public void addTwoNumbers() {
        //this.countListNode(l1,l2);
        ListNode l1 = new ListNode(1,new ListNode(2,new ListNode(3)));
        ListNode l2 = this.insert(l1,10);
        System.out.println(l2);

    }

    private ListNode countListNode(ListNode listNode1, ListNode listNode2) {
        ListNode listNode3 = null;
        while (listNode1 != null || listNode2 != null) {
            int currentValue = (listNode1 == null ? 0 :listNode1.val) + (listNode2 == null ? 0 :listNode2.val);
            int newValue;
            if(currentValue/10 == 1){
                if(listNode1.next == null){
                    listNode1.next = new ListNode(1,null);
                }else{
                    listNode1.next.val = listNode1.next.val + 1;
                }
                newValue = currentValue % 10;
            }else{
                newValue = currentValue;
            }
            if(listNode3 == null){
                listNode3 = new ListNode(newValue,null);
            }else{
                // 找到末尾的节点
                ListNode node = listNode3;
                while (node.next != null) {
                    node = node.next;
                }
                // 在尾节点插入新的节点
                node.next = new ListNode(newValue,null);

            }
            listNode1 = listNode1 == null ? null : listNode1.next;
            listNode2 = listNode2 == null ? null : listNode2.next;
        }

        return listNode3;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
        ListNode(int x,ListNode next) { val = x; this.next = next; }
    }


    public ListNode insert(ListNode l1,int value){
        // 找到末尾的节点
        ListNode node = l1;
        while (node.next != null) {
            node = node.next;
        }
        // 在尾节点插入新的节点
        node.next = new ListNode(value);
        return l1;
    }
}
