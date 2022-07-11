package solution;

import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

import java.util.PriorityQueue;

/**
 * @id 23
 * @author linglifan
 * @date 2022/07/10 11:16
 */
public class MergekSortedLists23 {
    /**
     * 将合并K个有序链表拆分为合并两个有序链表（顺序合并）
     * 时间复杂度：O(k^2 n)
     * 空间复杂度：O(1)
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists){
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = mergeTwoList(ans,lists[i]);
        }
        return ans;
    }

    public ListNode mergeTwoList(ListNode a, ListNode b){
        if (a == null || b == null){
            return a != null? a :b;
        }
        ListNode head = new ListNode(0);
        ListNode prev = head;
        while (a != null && b != null){
            if (a.val < b.val){
                prev.next = a;
                a = a.next;
            }else {
                prev.next = b;
                b = b.next;
            }
            prev = prev.next;
        }
        prev.next = a == null? b : a;
        return head.next;

    }


    /**
     * 分治法合并两个链表
     * @param lists
     * @return
     */
    public ListNode mergeKListsDivide(ListNode[] lists){
        return merge(lists,0, lists.length-1);
    }

    public ListNode merge(ListNode[] lists, int left, int right){
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int middle = left + (right - left) / 2;
        return mergeTwoList(merge(lists, left, middle), merge(lists, middle + 1, right));
    }



    /**
     * 使用优先队列
     * 渐进时间复杂度为 O(kn×logk)
     * 渐进空间复杂度为 O(k)
     * @param lists
     * @return
     */
    public ListNode mergeKListsByPriorityQueue(ListNode[] lists) {
        PriorityQueue<ListNode> merge = new PriorityQueue<>((a,b) -> a.val-b.val);
        for (ListNode list :
                lists) {
            if (list != null){
                merge.offer(list);
            }
        }
        ListNode head = new ListNode(0);
        ListNode prev = head;
        while (!merge.isEmpty()){
            ListNode currentPoll = merge.poll();//要注意这个currentPoll是弹出来的链表结点，他仍然可以指向自己所在链表的下一个结点
            prev.next = currentPoll;
            prev = prev.next;
            if (currentPoll.next != null){
                merge.offer(currentPoll.next);
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        MergekSortedLists23 mergekSortedLists23 = new MergekSortedLists23();

        ListNode list1 = new ListNode(1);
        ListNode present, node;
        present = list1;

        node = new ListNode(4);
        present.next = node;
        present = present.next;

        node = new ListNode(5);
        present.next = node;
        present = present.next;

        ListNode list2 = new ListNode(1);
        present = list2;
        int[] l2_data = {3,4};
        for (int i :
                l2_data) {
            node = new ListNode(i);
            present.next = node;
            present = present.next;
        }

        ListNode[] lists = new ListNode[]{list1,list2};
        ListNode listNode = mergekSortedLists23.mergeKListsByPriorityQueue(lists);
        ListNode i = listNode;
        while (i != null){
            System.out.println(i.val);
            i = i.next;
        }
    }

}
