package leetcode;

/**
 * @author wzh
 * @date 2023年09月17日 14:40
 * Description:
 */
public class leetcode109 {
    public static void main(String[] args) {

    }

    public TreeNode sortedListToBST(ListNode head) {
        return solu(head, null);
    }

    public TreeNode solu(ListNode l, ListNode r) {
        if (l == r) return null;
        ListNode mid = getMid(l, r);
        TreeNode cur = new TreeNode(mid.val);
        cur.left = solu(l, mid);
        cur.right = solu(mid.next, r);
        return cur;
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
