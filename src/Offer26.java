public class Offer26 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(2);
        TreeNode treeNode7 = new TreeNode(2);
        treeNode3.left = treeNode2;
        treeNode3.right = treeNode1;
        treeNode2.left = treeNode4;
        treeNode5.right = treeNode6;
        treeNode6.left = treeNode7;
        System.out.println(solution(treeNode3,treeNode5));
    }

    static boolean solution(TreeNode A, TreeNode B) {
        if (B==null) return true;
        if (A==null) return false;
        boolean l = false;
        boolean r = false;
        if (A.val == B.val) {
            if (A.left!=null&&B.left!=null){
                if (A.left.val!=B.left.val){
                    boolean ll = solution(A.left,B);
                    boolean rr = solution(A.right,B);
                    return ll||rr;
                }
            }
            if (A.right!=null&&B.right!=null){
                if (A.right.val!=B.right.val){
                    boolean ll = solution(A.left,B);
                    boolean rr = solution(A.right,B);
                    return ll||rr;
                }
            }
            l = solution(A.left, B.left);
            r = solution(A.right, B.right);
        }else {
            boolean ll = solution(A.left,B);
            boolean rr = solution(A.right,B);
            return ll||rr;
        }
        return l && r;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
