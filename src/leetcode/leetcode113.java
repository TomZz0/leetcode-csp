package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wzh
 * @date 2023年10月08日 15:40
 * Description:
 */
public class leetcode113 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> cur = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        solu(root, targetSum);
        return res;
    }

    private void solu(TreeNode root, int targetSum) {
        if (root == null) return;
        targetSum -= root.val;
        cur.offerLast(root.val);
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new LinkedList<Integer>(cur));
            return;
        }
        solu(root.left, targetSum);
        solu(root.right, targetSum);
        cur.pollLast();
    }
}
