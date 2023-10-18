package leetcode;

/**
 * @author wzh
 * @date 2023年09月18日 14:41
 * Description:
 */
public class leetcode148 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode sort = new leetcode148().sortList(l1);
        System.out.println("fi");
    }

    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    private ListNode sort(ListNode head, ListNode last) {
        if (head == null) {
            return head;
        }
        if (head.next == last) {
            head.next = null;
            return head;
        }
        ListNode mid = getMid(head, last);
        ListNode l = sort(head, mid);
        ListNode r = sort(mid.next, last);
        ListNode sorted = merge(l, r);
        return sorted;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

    private ListNode getMid(ListNode l, ListNode r) {
        ListNode fast = l;
        ListNode slow = l;
        while (fast != r && fast.next != r) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
