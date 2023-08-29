public class Offer53_1 {
    public static void main(String[] args) {
        int[]nums = {5,7,7,8,8,10};
        int target = 8;
        int left = 0,right = nums.length-1;
        int mid = (left+right)/2;
        while (left<=right){
            if (nums[mid]==target){
                break;
            }else if (nums[mid]>target){
                right = mid-1;
            }else {
                left = mid+1;
            }
            mid = (left+right)/2;
        }
        int res = 0;
        int index = mid;
        if (mid<0||mid>=nums.length){

        }else {
            for (int i = mid; i >= 0 ; i--) {
                if (nums[i]!=target) break;
                else res++;
            }
            for (int i = mid; i < nums.length ; i++) {
                if (nums[i]!=target) break;
                else res++;
            }
        }
        System.out.println(res-1);
    }
}
