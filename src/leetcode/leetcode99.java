package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wzh
 * @date 2023年10月07日 17:06
 * Description:
 */
public class leetcode99 {
    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<Integer>();
        get(root, nums);
        int[] swapped = findTwoSwapped(nums);
        recover(root, 2, swapped[0], swapped[1]);
    }

    private void recover(TreeNode root, int count, int x, int y) {
        if (root == null) return;
        if (root.val == x||root.val==y){
            root.val = root.val == x?y:x;
            if (--count==0) return;
        }
        recover(root.left,count,x,y);
        recover(root.right,count,x,y);
    }

    private int[] findTwoSwapped(List<Integer> nums) {
        int index1 = -1, index2 = -1;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (index2 != -1) break;
            if (nums.get(i + 1) < nums.get(i)) {
                if (index1 == -1) index1 = i;
                else index2 = i;
            }
            // if (nums.get(i + 1) < nums.get(i)) {
            //     index2 = i + 1;
            //     if (index1 == -1) index1 = i;
            //     else break;
            // }
        }
        return new int[]{nums.get(index1), nums.get(index2)};
    }


    public void get(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        get(root.left, nums);
        nums.add(root.val);
        get(root.right, nums);
    }
    // ArrayList<Integer> list = new ArrayList<>();
    //
    // public void recoverTree(TreeNode root) {
    //     get(root);
    //     list.sort((x,y)->x>y?1:-1);
    //     reform(root);
    // }
    //
    // public void get(TreeNode root) {
    //     if (root == null) return;
    //     list.add(root.val);
    //     get(root.left);
    //     get(root.right);
    // }
    //
    // public void reform(TreeNode root) {
    //     if (root == null) return;
    //     reform(root.left);
    //     root.val = list.get(0);
    //     list.remove(0);
    //     reform(root.right);
    // }
}
