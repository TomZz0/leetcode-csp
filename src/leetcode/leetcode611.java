package leetcode;

import java.util.Arrays;

/**
 * @author wzh
 * @date 2023年10月05日 9:47
 * Description:
 */
public class leetcode611 {

    public static void main(String[] args) {
        int[]arr = {0,0,0,2,3,4,6};
        int i = new leetcode611().triangleNumber(arr);
        System.out.println(i);
    }

    public int triangleNumber(int[] nums) {
        int n = nums.length;
        //排序
        Arrays.sort(nums);
        //跳过所有0
        int start = 0;
        while (start < n && nums[start]==0)start++;
        //更新n为非零边个数
        n = n-start;
        if (n <= 2) return 0;
        //利用排列组合计算总的组合数
        int total = n * (n - 1) * (n - 2) / 6;
        //设置max记录最大值
        int max = Integer.MIN_VALUE;
        //定义桶
        int[] arr = new int[2001];
        //更新桶，同时记录最大值
        for (int i = start;i<n+start;i++) {
            arr[nums[i]]++;
            if (nums[i] > max) max = nums[i];
        }
        //从后向前累加，操作完成后,arr[i]代表大于等于i的数的个数
        for (int i = max - 1; i >= 0; i--) {
            arr[i] += arr[i + 1];
        }
        //disable变量代表有多少个无法组成三角形的组合
        int disable = 0;
        for (int i = start; i < n+start; i++) {
            int x = nums[i];
            for (int j = i + 1; j < n+start; j++) {
                int y = nums[j];
                disable += arr[x + y];
            }
        }
        return total - disable;
    }
}
