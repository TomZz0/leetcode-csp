package leetcode;

/**
 * @author wzh
 * @date 2023年09月18日 19:36
 * Description:
 */
public class leetcode215 {

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int k = 6;
        int kthLargest = new leetcode215().findKthLargest(arr, k);
        System.out.println(kthLargest);
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return  solu(nums, n - k, 0, n - 1);

    }

    public int solu(int[] nums, int k, int l, int r) {
        if (r == l) return nums[k];
        int cl = l-1;
        int cr = r+1;
        int val = nums[l];

        while (cl < cr) {
            do cl++; while (nums[cl] < val);
            do cr--; while (nums[cr] > val);
            if (cl < cr){
                int tmp = nums[cl];
                nums[cl] = nums[cr];
                nums[cr] = tmp;
            }
        }
        if (k  <= cr)
            return  solu(nums, k, l, cr);
        else
          return   solu(nums, k, cr + 1, r);
    }

}
