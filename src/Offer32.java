import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Offer32 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        int[] ints = new Offer32().levelOrder(treeNode1);
        System.out.println(Arrays.toString(ints));
    }
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<TreeNode> trees = new LinkedList<>();
        trees.add(root);
        while (!trees.isEmpty()){
            TreeNode treeNode = trees.get(0);
            list.add(treeNode.val);
            if (treeNode.left != null)
                    trees.add(treeNode.left);
                if (treeNode.right != null)
                    trees.add(treeNode.right);
                trees.remove(treeNode);
        }
        int [] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void solu(LinkedList<Integer> list, LinkedList<TreeNode> trees) {
//        if (trees.isEmpty()) return;
//        LinkedList<TreeNode> treeNodes = new LinkedList<>();
//        for (TreeNode treeNode : trees) {
//            list.add(treeNode.val);
//            if (treeNode.left != null)
//                treeNodes.add(treeNode.left);
//            if (treeNode.right != null)
//                treeNodes.add(treeNode.right);
//        }
//        solu(list,treeNodes);

    }
}
