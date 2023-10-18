package leetcode;

import java.util.Arrays;

/**
 * @author wzh
 * @date 2023年09月24日 18:35
 * Description: the implement of leetcode.MergeSort
 */
public class MergeSortImpl {
    public static void main(String[] args) {
        int[] arr = {5, 3, 223, 0, -8, 695, -41, 16};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        int n = arr.length;
        sortImpl(arr, 0, n - 1, new int[n]);
    }

    public static void sortImpl(int[] arr, int l, int r, int[] temp) {
        if (r <= l) return;
        int mid = (l + r) / 2;
        sortImpl(arr, l, mid, temp);
        sortImpl(arr, mid + 1, r, temp);
        merge(arr, l, r, temp, mid);
    }

    private static void merge(int[] arr, int l, int r, int[] temp, int mid) {
        int index = l;
        int ll = l;
        int rr = mid + 1;
        while (ll <= mid && rr <= r) {
            if (arr[ll] < arr[rr]) temp[index++] = arr[ll++];
            else temp[index++] = arr[rr++];
        }
        while (ll <= mid) temp[index++] = arr[ll++];
        while (rr <= r) temp[index++] = arr[rr++];
        if (r + 1 - l >= 0) System.arraycopy(temp, l, arr, l, r + 1 - l);
    }
}
