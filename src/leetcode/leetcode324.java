package leetcode;

import java.util.Arrays;

/**
 * @author wzh
 * @date 2023年09月19日 16:19
 * Description:
 */
public class leetcode324 {
    public static void main(String[] args) {
        int[]arr = {1,5,1,1,6,4};
        new leetcode324().wiggleSort(arr);
    }

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int j = n / 2 ;
        int[] res = new int[n];
        for (int k = 0; k < n; k++) {
            if (k%2==0) res[k] = nums[i++];
            else res[k] = nums[j++];
        }
        nums = res;
    }


}
