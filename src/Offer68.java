import java.math.BigDecimal;

public class Offer68 {
    Boolean find = false;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(1);
        root.left=treeNode2;root.right=treeNode3;
        treeNode2.left=treeNode4;treeNode2.right=treeNode5;
        treeNode4.left=treeNode6;
        TreeNode treeNode = new Offer68().lowestCommonAncestor(root, treeNode2, treeNode6);
        System.out.println(treeNode.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) return null;
        midTra(p,q);
        if (find) return p;
        midTra(q,p);
        if (find) return q;
        return lowestCommonAncestor(root,getFather(root,p),getFather(root,q));
    }

    /**
     * 在根为root的二叉排序树中搜索node的父节点并返回
     * @param root
     * @param node
     * @return
     */
    private TreeNode getFather(TreeNode root,TreeNode node){
        TreeNode cur = root;
        while (cur!=null){
            if (cur.left==node||cur.right==node) return cur;
            cur = cur.val>node.val?cur.left:cur.right;
        }
        return node;
    }
    private void midTra(TreeNode p,TreeNode q){
        if (p==null) return;
         midTra(p.left,q);
        if (p==q){
            find = true;
            return;
        }
         midTra(p.right,q);
    }
}
