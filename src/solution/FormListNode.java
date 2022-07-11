package solution;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.ArrayList;

/**
 * @author linglifan
 * @date 2022/07/11 13:30
 */
public class FormListNode {
    public static ListNode formListNode(ArrayList<Integer> list){
        ListNode present,node;
        ListNode listNode = new ListNode(0);
        present = listNode;

        for (int i : list){
            node = new ListNode(i);
            present.next = node;
            present = present.next;
        }

        return listNode.next;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);
        ListNode formedListNode = formListNode(list);
        while (formedListNode != null){
            System.out.println(formedListNode.val);
            formedListNode = formedListNode.next;
        }
    }
}
