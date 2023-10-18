package leetcode;

import java.util.HashMap;

/**
 * @author wzh
 * @date 2023年09月15日 15:23
 * Description:
 */
public class leetcode377 {


    public static void main(String[] args) {
        int t = 32;
        int[] nums = {4, 2, 1};
        int i = new leetcode377().combinationSum4(nums, t);
        System.out.println(i);
    }

    HashMap<Integer, Integer> haved = new HashMap<>();

    public int combinationSum4(int[] nums, int target) {
        return solu(nums, target);
    }

    public int solu(int[] nums, int target) {
        if (target == 0) return 1;
        if (target < 0) return 0;

        if (haved.containsKey(target)) {
            return haved.get(target);
        }
        int res = 0;
        for (int i=0;i<nums.length;i++){
            res += solu(nums,target-nums[i]);
        }
        haved.put(target,res);
        return res;
    }
}
