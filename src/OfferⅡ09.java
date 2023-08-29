import jdk.nashorn.internal.ir.CallNode;

/**
 * @author wzh
 * @date 2023年03月27日 16:26
 * Description:
 */
public class OfferⅡ09 {
    public static void main(String[] args) {
        int[] arr = {
                10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3
        };
        int k = 19;
        int i = new OfferⅡ09().numSubarrayProductLessThanK(arr, k);
        System.out.println(i);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        int res = 0;
        int left = 0;
        int right = 0;
        int cur = 1;
        while (right < nums.length) {
            cur *= nums[right];
            while (left <= right && cur >= k) {
                cur /= nums[left];
                left++;
            }
            res += right - left + 1;
            right++;
        }
        return res;
    }
}
