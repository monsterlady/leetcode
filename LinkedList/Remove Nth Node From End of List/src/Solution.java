import java.util.List;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode runner = dummy;
        ListNode toDeleteNode = dummy;
        while (n > 0) {
            runner = runner.next;
            n--;
        }
        while (runner.next != null) {
            runner = runner.next;
            toDeleteNode = toDeleteNode.next;
        }
        toDeleteNode.next = toDeleteNode.next.next;
        return dummy.next;
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