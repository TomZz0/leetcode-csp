package 周赛;

import java.util.Arrays;
import java.util.Map;

/**
 * @author wzh
 * @date 2023年10月15日 11:22
 * Description:
 */
public class p3_10_15 {
    public static void main(String[] args) {
    }

    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        return solu(nums, 0, nums.length - 1, indexDifference, valueDifference);
    }

    public int[] solu(int[] nums, int l, int r, int indif, int valdif) {
        int n = nums.length;
        while (l < n && r >= 0) {
            int ll = l;
            int rr = r;
            if (Math.abs(r - l) >= indif && Math.abs(nums[l] - nums[r]) >= valdif)
                return new int[]{l, r};
            if (nums[l] > nums[r]) {
                int v = r - 1;
                while (v >= 0 && nums[v] >= nums[r]) v--;
                if (v >= 0 && nums[v] < nums[r]) r = v;
                v = l + 1;
                while (v < n && nums[v] <= nums[l]) v++;
                if (v < n && nums[v] > nums[l]) l = v;
            } else if (nums[l] < nums[r]) {
                int v = r - 1;
                while (v >= 0 && nums[v] <= nums[r]) v--;
                if (v >= 0 && nums[v] > nums[r]) r = v;
                v = l + 1;
                while (v < n && nums[v] >= nums[l]) v++;
                if (v < n && nums[v] < nums[l]) l = v;
            } else {
                int[] left = solu(nums, l + 1, r, indif, valdif);
                if (left[0] != -1) return left;
                int[] right = solu(nums, l, r - 1, indif, valdif);
                if (right[0] != -1) return right;
            }
            if (l == ll && r == rr) return new int[]{-1, -1};
        }
        return new int[]{-1, -1};
    }
}
