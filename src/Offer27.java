import jdk.nashorn.internal.ir.CallNode;
import sun.reflect.generics.tree.Tree;

public class Offer27 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(9);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        TreeNode treeNode = new Offer27().mirrorTree(t1);
        System.out.println(666);
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode now = new TreeNode(root.val);
        solu(root, now);
        return now;
    }

    private void solu(TreeNode old, TreeNode now) {
        if (old == null) return;
        if (old.right != null) now.left = new TreeNode(old.right.val);
        if (old.left != null) now.right = new TreeNode(old.left.val);
        solu(old.left, now.right);
        solu(old.right, now.left);
    }

}
