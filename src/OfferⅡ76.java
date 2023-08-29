/**
 * @author wzh
 * @date 2023年03月28日 12:58
 * Description:
 */
public class OfferⅡ76 {
    int res;

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 9;
        int kthLargest = new OfferⅡ76().findKthLargest(arr, k);
        System.out.println(kthLargest);
    }

    public int findKthLargest(int[] nums, int k) {
        QuickSortMethod(nums, 0, nums.length - 1, k);
        return res;

    }

    void QuickSortMethod(int[] arr, int start, int end, int k) {//快速排序
        if (start==end) res = arr[start];
        if (end - start < 1) return;
        int hub = (end + start) / 2;
        int val = arr[hub];
        int l = start;
        int r = end;
        while (l < r) {
            //找位置
            while (arr[l] < val) l++;
            while (arr[r] > val) r--;
            //判断是否需要交换位置
            if (l >= r) break;
            //交换位置
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            //如果等于目标值 移动
            if (arr[l] == val) r--;
            if (arr[r] == val) l++;
        }
        if (l == r) {
            r--;
            l++;
        }
        if (l - 1 == arr.length - k) {
            res = arr[l - 1];
            return;
        }
        if (l - 1 > arr.length - k) QuickSortMethod(arr, start, r, k);
        else QuickSortMethod(arr, l, end, k);
    }
}
