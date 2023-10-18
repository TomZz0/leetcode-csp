package leetcode;

/**
 * @author wzh
 * @date 2023年10月07日 16:01
 * Description:
 */
public class leetcode98 {

    public boolean isValidBST(TreeNode root) {
        return solu(root, (long)Integer.MAX_VALUE+1,(long)Integer.MIN_VALUE-1);
    }

    public boolean solu(TreeNode root, long max,long min) {
        if (root == null) return true;
        if ((long)root.val >= max || (long)root.val <= min) return false;
        return solu(root.left,root.val,min) &&
                solu(root.right,max, root.val);
    }
}
