package leetcode;

import java.util.*;

/**
 * @author wzh
 * @date 2023年09月20日 12:01
 * Description:
 */
public class leetcode347 {
    public static void main(String[] args) {
        // int[] arr = {4, 1, -1, 2, -1, 2, 3};
        // int k = 2;
        // int[] ints = new leetcode347().topKFrequent(arr, k);
        // String r = Arrays.toString(ints);

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        queue.offer(new int[]{1,5});
        queue.offer(new int[]{3,2});
        queue.offer(new int[]{4,7});
        System.out.println(queue.peek()[1]);
    }

    public int[] topKFrequent(int[] nums, int k) {
        int pre = 1;
        int nex;
        int n = nums.length;
        while (pre < n) {
            while (pre < n && nums[pre] == nums[pre - 1]) pre++;
            if (pre >= n) break;
            nex = pre + 1;
            while (nex < n && nums[nex] != nums[pre - 1]) nex++;
            if (nex < n) {
                ;
                int temp = nums[nex];
                nums[nex] = nums[pre];
                nums[pre] = temp;
            }
            pre++;
        }

        int l = 0, r = 0;
        int[] res = new int[100001];
        List<Integer>[] res_num = new List[100001];
        while (l < n) {
            while (r < n && nums[r] == nums[l]) r++;
            res[r - l]++;
            if (res_num[r - l] == null) {
                res_num[r - l] = new LinkedList<>();
                res_num[r - l].add(nums[l]);
            } else res_num[r - l].add(nums[l]);
            l = r;
        }
        int[] arr = new int[k];
        int index = 0;
        int i = 100000;
        while (i >= 0 && index < k) {
            if (res[i] == 0) {
                i--;
            } else {
                List<Integer> list = res_num[i];
                arr[index++] = list.get(0);
                list.remove(0);
                res[i]--;
            }
        }
        return arr;
    }
}
