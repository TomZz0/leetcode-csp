import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 二叉树的序列化
 */
public class Offer37 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(1);
        treeNode3.left = treeNode2;
        treeNode3.right = treeNode1;
        treeNode2.left = treeNode4;
        String serialize = serialize(treeNode3);
        System.out.println(serialize);
    }

    public static String serialize(TreeNode root) {
        if (root==null) return "";
        StringBuilder sb = new StringBuilder("");
        sb.append(root.val+",");
        int high = getHeight(root);
        s1(root,sb,high,1);
        if (sb.charAt(sb.length()-1)==',') sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static void s1(TreeNode root, StringBuilder sb,int high,int curHeight) {
        if (root == null) return;
        if (curHeight!=high)
        {
            sb.append(root.left==null?"null":root.left.val);
            sb.append(",");
            sb.append(root.right==null?"null":root.right.val);
            sb.append(",");
        }
        s1(root.left,sb,high,curHeight+1);
        s1(root.right,sb,high,curHeight+1);
    }
    public static int getHeight(TreeNode root){
        if (root==null) return 0;
        return 1 + Math.max(getHeight(root.left),getHeight(root.right));

    }


}
