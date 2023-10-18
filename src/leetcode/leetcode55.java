package leetcode;

import java.util.HashMap;

/**
 * @author wzh
 * @date 2023年09月26日 17:09
 * Description:
 */
public class leetcode55 {
    HashMap<Integer,Boolean> map = new HashMap<>();
    public static void main(String[] args) {
        int[] a= {2,2,1,0,4};
        boolean b = new leetcode55().canJump(a);
        System.out.println(b);
    }
    public boolean canJump(int[] nums) {
        int n = nums.length;
        return solu(n - 1, nums);
    }

    public boolean solu(int r, int[] nums) {
        if (r == 0) return true;
        if (r < 0) return false;
        boolean res = false;
        int t = r-1;
        while (t >= 0) {
            int sub = r - t;
            if (nums[t] >= sub){
                if (map.containsKey(t)) res = map.get(t);
                else {
                    res = solu(t,nums);
                    map.put(t,res);
                }
            }
            if (res) break;
            t--;
        }
        return res;
    }
}
