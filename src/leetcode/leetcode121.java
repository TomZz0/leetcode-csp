package leetcode;

/**
 * @author wzh
 * @date 2023年09月12日 18:57
 * Description: 买卖股票的最佳时机
 */
public class leetcode121 {
    public static void main(String[] args) {

    }

    /**
     * 遍历i时记录前i个中最低价
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min) min = prices[i];
            else if(prices[i]-min > res) res = prices[i]-min;
        }
        return res;
    }
}
