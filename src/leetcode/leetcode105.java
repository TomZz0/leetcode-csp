package leetcode;

/**
 * @author wzh
 * @date 2023年09月17日 13:43
 * Description:
 */
public class leetcode105 {

    public static void main(String[] args) {
        int[] pre = {3, 9, 20, 15, 7};
        int[] ino = {9, 3, 15, 20, 7};
        TreeNode treeNode = new leetcode105().buildTree(pre, ino);
        System.out.println("finish");
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {

       return solu( preorder, inorder, 0, preorder.length-1, 0);
    }

    private TreeNode solu( int[] preorder, int[] inorder, int l, int r, int start) {
        if (l > r || l < 0 || r >= preorder.length || start>= preorder.length) return null;
        TreeNode cur = new TreeNode(preorder[start]);
        int des = getDes(preorder[start], inorder, l, r);
        cur.left = solu( preorder, inorder, l, des - 1, start + 1);
        cur.right = solu( preorder, inorder, des + 1, r, start + des - l + 1);
        return cur;
    }

    private int getDes(int i, int[] inorder, int l, int r) {
        for (int j = l; j <= r; j++) {
            if (inorder[j] == i) return j;
        }
        return 0;
    }

}
