import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        //将每个节点都加入priorityqueue
        for (ListNode node:lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()){
            //将最小的节点赋值给目标节点
            tail.next=queue.poll();
            //切换到下个节点
            tail=tail.next;
            //若节点的下一个不为空，则加入priority中进行比较
            if (tail.next!=null) {
                queue.add(tail.next);
            }
        }
        return dummy.next;
    }

    public ListNode mergeTwoLists(ListNode n1,ListNode n2){
        if(n1==null && n2 == null){
            return null;
        }

        if(n1 == null){
            return n2;
        }
        if( n2 == null){
            return n1;
        }

        if(n1.val < n2.val){
            n1.next = mergeTwoLists(n1.next,n2);
            return n1;
        } else {
            n2.next = mergeTwoLists(n1,n2.next);
            return n2;
        }
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
