import java.util.Arrays;

public class Offer21 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int left = 0;
        int right = nums.length - 1;
        while (left<right){
            if (nums[left]%2==0&&nums[right]%2!=0){
                int t = nums[left];
                nums[left] = nums[right];
                nums[right] = t;
                left++;right--;
            }else if(nums[left]%2==0){
                right--;
            }else if (nums[right]%2!=0){
                left++;
            }else {
                left++;right--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
