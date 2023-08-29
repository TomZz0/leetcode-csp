public class Offer07 {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = getRoot(preorder, inorder, 0, 0, preorder.length-1);
        System.out.println(666);
    }
    static TreeNode getRoot(int[]preorder,int[]inorder,int index,int left,int right){
        if (left>right||index>=inorder.length||left>=inorder.length||index<0||right<0) return null;
        TreeNode treeNode = new TreeNode(preorder[index]);
        int leftStart=0;
        for (int i = left; i <= right; i++) {
            if (inorder[i]==preorder[index]){
                leftStart = i;
                break;
            }
        }
        treeNode.left = getRoot(preorder,inorder,index+1,left,leftStart-1);
        treeNode.right = getRoot(preorder,inorder,index+leftStart-left+1,leftStart+1,right);
        return treeNode;
    }
}
