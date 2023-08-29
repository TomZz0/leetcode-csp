import java.util.Arrays;

/**
 * @author wzh
 * @date 2023年03月28日 12:31
 * Description:
 */
public class OfferⅡ56 {
    public static void main(String[] args) {
        int[] arr = {2,2,2,5,7,3,7,3,5,3,5,7,9};
        int i = new OfferⅡ56().singleNumber(arr);
        System.out.println(i);
    }

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums.length == 1 || nums[i] != nums[i + 1])
                    return nums[i];
            } else {
                if (i == nums.length - 1) {
                    if (nums[i] != nums[i - 1])
                        return nums[i];
                } else {
                    if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1])
                        return nums[i];
                }
            }
        }
        return 0;
    }
}
