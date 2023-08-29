import java.util.HashMap;
import java.util.Map;

/**
 * @author wzh
 * @date 2023年04月03日 12:06
 * Description:
 */
public class OfferⅡ008 {
    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        int tar = 55;
        int i = new OfferⅡ008().minSubArrayLen(tar, arr);
        System.out.println(i);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int res = nums.length + 1;
        int left = 0;
        int right = 0;
        int cur = 0;
        while (left< nums.length && res >= 1) {
            if (right>=nums.length){
                break;
            }
            cur += nums[right];
            if (cur >= target) {
                res = Math.min(res, right - left + 1);
                cur -= nums[left];
                left++;
                while (cur >= target) {
                    cur -= nums[right];
                    right--;
                }
            }
            right++;
        }
        return res == nums.length + 1 ? 0 : res;
    }
}
