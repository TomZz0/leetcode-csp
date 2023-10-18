package leetcode;

/**
 * @author wzh
 * @date 2023年09月13日 19:43
 * Description:
 */
public class leetcode213 {
    public static void main(String[] args) {

    }
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        int max = Math.max(nums[0],nums[1]);
        int[] arr = new int[nums.length-1];
        arr[0] = nums[0];arr[1] = max;
        for(int i=2;i<nums.length-1;i++){
            arr[i] = Math.max(arr[i-1],arr[i-2]+nums[i]);
            if(arr[i] > max) max = arr[i];
        }
        arr[0] = nums[1];arr[1] = Math.max(nums[1],nums[2]);
        max = Math.max(nums[1],nums[2]);
        for(int i=3;i<nums.length;i++){
            arr[i-1] = Math.max(arr[i-2],arr[i-3]+nums[i]);
            if(arr[i] > max) max = arr[i-1];
        }
        return max;
    }
}
