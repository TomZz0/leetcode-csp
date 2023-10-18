package leetcode;

/**
 * @author wzh
 * @date 2023年10月01日 10:31
 * Description:
 */
public class leetcode376 {
    public static void main(String[] args) {
        int[]nums={1,17,5,10,13,15,10,5,16,8};
        int i = new leetcode376().wiggleMaxLength(nums);
        System.out.println(i);
    }

    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n == 1 || (n == 2 & nums[0] != nums[1])) return n;
        if (n == 2) return 1;
        int res = n;
        int i = 0, j = 1;
        int sub = nums[j] - nums[i];
        while (j < n && sub == 0) {
            i++;
            j++;
            res--;
            sub = nums[j] - nums[i];
        }
        i++;
        j++;
        while (j < n) {
            int ssub = nums[j] - nums[i];
            if (ssub * sub >= 0) {
                res--;
            } else if (ssub * sub < 0) {
                sub = ssub;
            }
            i++;
            j++;
        }
        return res;
    }
}
