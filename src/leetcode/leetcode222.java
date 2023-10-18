package leetcode;

/**
 * @author wzh
 * @date 2023年10月11日 16:13
 * Description:
 */
public class leetcode222 {
    public static void main(String[] args) {
        System.out.println(12 & 3);
    }
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        //计算层数
        int level = 0;
        TreeNode t = root;
        while (t.left != null) {
            level++;
            t = t.left;
        }
        //求得范围
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private boolean exists(TreeNode root, int level, int mid) {
        int bits = 1 << (level - 1);
        TreeNode t = root;
        while (t != null && bits > 0) {
            //实际每次只比了第二位 因为bits除了第一位每一位都为0
            // 比如12-1100 和 1000 比完结果为1000 不为零 然后说明为1 右移；否则左移
            if ((bits & mid) == 0) {
                t = t.left;
            }else {
                t=t.right;
            }
            bits>>=1;
        }
        return t !=  null;
    }
}
