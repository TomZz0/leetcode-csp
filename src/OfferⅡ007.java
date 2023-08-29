import java.util.*;

/**
 * @author wzh
 * @date 2023年03月31日 12:14
 * Description:
 */
public class OfferⅡ007 {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = new OfferⅡ007().threeSum(arr);
        System.out.println(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new LinkedList<>();
        for (int fir = 0; fir < len; fir++) {
            //如果和上次相同 就跳过 因为不能有重复的
            if (fir > 0 && nums[fir] == nums[fir - 1]) continue;
            int thr = len - 1;
            int tar = -nums[fir];
            for (int sec = fir + 1; sec < len; sec++) {
                //如果和上次相同 就跳过 因为不能有重复的
                if (sec > fir + 1 && nums[sec] == nums[sec - 1]) continue;
                //按照2号3号下标寻找 若和比目标大 就前移3号指针
                while (sec < thr && nums[sec] + nums[thr] > tar) thr--;
                //若2号和3号指向了同一个位置说明此时的1、2号位置不存在满足条件的三个数
                if (sec == thr) break;
                //否则按照次序加入到结果集
                if (nums[sec] + nums[thr] == tar) {
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[fir]);
                    list.add(nums[sec]);
                    list.add(nums[thr]);
                    res.add(list);
                }
            }
        }
        return res;
    }
}
