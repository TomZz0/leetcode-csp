package leetcode;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {3,4,6,12,54,76,1,34,7,213,6,5};
        int[] ints = mergeSort(arr);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] mergeSort(int[] arr) {
        int[]temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        return temp;
    }

    private static void mergeSort(int[] arr,int left,int right,int[]temp) {
        //递归终止条件
        if (left==right) return;
        int mid = (left+right)/2;
        //递归分成长为二或一的小部分
        mergeSort(arr,left,mid,temp);
        mergeSort(arr,mid+1,right,temp);
        //排序
        int start = left;int end = mid+1;
        int indexOfTemp=left;
        //比较两个部分的元素 按照从小到大一次加入到temp数组中
        while (start<=mid&&end<=right){
             if (arr[start]<arr[end]) temp[indexOfTemp++] = arr[start++];
             else temp[indexOfTemp++] = arr[end++];
        }
        while(start<=mid) temp[indexOfTemp++]=arr[start++];
        while(end<=right) temp[indexOfTemp++]=arr[end++];
        //更新原数组
        for (int i = left; i <= right; i++) arr[i] = temp[i];
    }


}
