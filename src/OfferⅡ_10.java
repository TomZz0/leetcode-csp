import java.util.HashMap;

/**
 * @author wzh
 * @date 2023年03月26日 13:06
 * Description:
 */
public class OfferⅡ_10 {

    public static void main(String[] args) {
        int[] nums = {0, 0};
        int k = 0;
        System.out.println(new OfferⅡ_10().subarraySum(nums, k));
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap< Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

}
