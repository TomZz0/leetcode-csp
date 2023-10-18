package leetcode;

/**
 * @author wzh
 * @date 2023年09月17日 14:10
 * Description:
 */
public class leetcode106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return solu(postorder, inorder, 0, postorder.length - 1, postorder.length - 1);
    }

    private TreeNode solu(int[] postorder, int[] inorder, int l, int r, int start) {
        if (l > r || l < 0 || r >= postorder.length || start < 0) return null;
        TreeNode cur = new TreeNode(postorder[start]);
        int des = getDes(postorder[start], inorder, l, r);
        cur.left = solu(postorder, inorder, l, des - 1, start - (r-des+1));
        cur.right = solu(postorder, inorder, des + 1, r, start - 1);
        return cur;
    }

    private int getDes(int i, int[] inorder, int l, int r) {
        for (int j = l; j <= r; j++) {
            if (inorder[j] == i) return j;
        }
        return 0;
    }
}
