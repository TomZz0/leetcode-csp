/**
 * @author wzh
 * @date 2023年04月03日 12:46
 * Description:
 */
public class OfferⅡ070 {

    public static void main(String[] args) {
        int[] arr = {0,0,1, 1, 2, 3, 3, 4, 4, 8, 8};
        int i = new OfferⅡ070().singleNonDuplicate(arr);
        System.out.println(i);
    }

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid =  (left + right) / 2;;

        while (left < right) {
            mid = (right + left) / 2;
            if (mid % 2 == 0) {
                if (nums[mid] != nums[mid + 1]) {
                    right = mid;
                }else {
                    left = mid+1;
                }
            } else {
                if (nums[mid] != nums[mid - 1]) {
                    right = mid -1;
                }else {
                    left = mid + 1;
                }
            }
        }
        return nums[left];
    }


}
