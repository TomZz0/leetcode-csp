package leetcode;

/**
 * @author wzh
 * @date 2023年09月24日 14:03
 * Description:
 */
public class leetcode918 {
    public static void main(String[] args) {
        int[]arr = {-1,-2,-3,-4,-9};
        System.out.println(maxSubarraySumCircular(arr));
    }
    public static int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int preMax = nums[0], maxRes = nums[0];
        int preMin = nums[0], minRes = nums[0];
        int sum = nums[0];
        for (int i = 1; i < n; i++) {
            preMax = Math.max(preMax + nums[i], nums[i]);
            maxRes = Math.max(maxRes, preMax);
            preMin = Math.min(preMin + nums[i], nums[i]);
            minRes = Math.min(minRes, preMin);
            sum += nums[i];
        }
        if (maxRes < 0) {
            return maxRes;
        } else {
            return Math.max(maxRes, sum - minRes);
        }
    }

    // public static int maxSubarraySumCircular(int[] nums) {
    //     int n = nums.length;
    //     //前缀最大值
    //     int[] preMax = new int[n];
    //     preMax[0] = nums[0];
    //     int pre = nums[0];
    //     int res=nums[0];
    //     int leftSum = nums[0];
    //     for(int i=1;i<n;i++){
    //         pre = Math.max(pre+nums[i],nums[i]);
    //         res = Math.max(pre,res);
    //         leftSum +=  nums[i];
    //         preMax[i] = Math.max(preMax[i-1],leftSum);
    //     }
    //     int rightSum=0;
    //     for(int i=n-1;i>0;i--){
    //         rightSum += nums[i];
    //         res = Math.max(res,rightSum + preMax[i-1]);
    //     }
    //     return res;
    // }
}
