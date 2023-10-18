package 周赛;

/**
 * @author wzh
 * @date 2023年10月15日 10:34
 * Description:
 */
public class p10_15 {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n =nums.length;
        for (int i=0;i<n;i++){
            for (int j=0;j<=i;j++){
                if (Math.abs(nums[i]-nums[j])>=valueDifference&&Math.abs(i-j)>=indexDifference)
                    return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }
}
