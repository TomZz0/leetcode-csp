public class Offer28 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        System.out.println(new Offer28().isSymmetric(t1));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return equalOfTree(root.left, root.right);
    }

    public boolean equalOfTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null) return false;
        if (right == null) return false;
        if (left.val != right.val) return false;
        if (left.left != null && right.right != null) {
            if (left.left.val != right.right.val) return false;
        }
        if (left.right != null && right.left != null) {
            if (left.right.val != right.left.val) return false;
        }
        return equalOfTree(left.left, right.right) && equalOfTree(left.right, right.left);
    }
}
