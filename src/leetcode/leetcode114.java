package leetcode;

/**
 * @author wzh
 * @date 2023年10月08日 16:08
 * Description:
 */
public class leetcode114 {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        new leetcode114().flatten(t1);
    }

    public void flatten(TreeNode root) {
        solu(root);
    }

    private TreeNode solu(TreeNode root) {
        if (root == null) return null;
        TreeNode right = root.right;
        root.right = null;
        root.right = solu(root.left);
        root.left = null;
        TreeNode t = root;
        while (t.right != null) t = t.right;
        t.right = solu(right);
        return root;
    }
}
