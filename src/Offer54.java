public class Offer54 {
    TreeNode res = null;
    int t = 0;
    public int kthLargest(TreeNode root, int k) {
        t = k;
        solu(root);
        return res.val;
    }
    private void solu(TreeNode root){
        if (root.right!=null) solu(root.right);
        t--;
        if (t==0){
            res = root;
            return;
        }
        if (root.left!=null) solu(root.left);
    }
}
