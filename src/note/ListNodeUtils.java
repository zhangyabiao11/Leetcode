package note;

import java.util.LinkedList;

public class ListNodeUtils {

    public ListNodeUtils(){
        throw new RuntimeException("工具类不需要实例化！");
    }

    public static ListNode addListNode(ListNode node,Integer data){
        ListNode header = node.next;
        while (header != null){
            header = header.next;
        }
        header = new ListNode(data);
        return node;
    }

    public static void print(ListNode listNode){
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        addListNode(listNode,2);
        print(listNode);
    }

    public static ListNode createListNode(LinkedList<Integer> linkedList){

        ListNode header = new ListNode(linkedList.getFirst());


        return header;
    }

}
