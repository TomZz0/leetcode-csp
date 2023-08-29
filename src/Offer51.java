import java.lang.reflect.Array;
import java.util.Arrays;

public class Offer51 {
    int count  = 0;
    public static void main(String[] args) {
        int[] nums = {1,3,2,3,1};
        System.out.println(new Offer51().reversePairs(nums));
        System.out.println(Arrays.toString(nums));
    }
    public int reversePairs(int[] nums) {
         mergeSort(nums);
        return count;
    }

    public int[] mergeSort(int[] arr) {
        int[]temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        return temp;
    }

    private void mergeSort(int[] arr,int left,int right,int[]temp) {
        //递归终止条件
        if (left==right) return;
        int mid = (left+right)/2;
        //递归分成长为二或一的小部分
        mergeSort(arr,left,mid,temp);
        mergeSort(arr,mid+1,right,temp);
        //排序
        int start = left;int end = mid+1;
        int indexOfTemp=left;
        while (start<=mid&&end<=right){
            if (start>mid){
                temp[indexOfTemp++] = arr[end++];
            }else if (end>right){
                temp[indexOfTemp++] = arr[start++];
            }else if (arr[start]<=arr[end]){
                temp[indexOfTemp++] = arr[start++];
            }else {
                temp[indexOfTemp++] = arr[end++];
                count += (mid - start+1);
            }
        }
        if (right + 1 - left >= 0) System.arraycopy(temp, left, arr, left, right + 1 - left);
    }
}
