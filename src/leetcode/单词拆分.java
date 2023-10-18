package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wzh
 * @date 2023年09月03日 10:26
 * Description:
 */
public class 单词拆分 {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> list = new LinkedList<String>();
        list.add("leet");
        list.add("code");
        System.out.println(wordBreak(s, list));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (int i = 1; i <= s.length(); i++) {
            String substring = s.substring(0, i);
            if (wordDict.contains(substring)) {
                dp[i - 1] = true;
                continue;
            }
            for (int j = 0; j < i; j++) {
                dp[i - 1] = dp[j] && wordDict.contains(s.substring(j + 1, i));
                if (dp[i-1]) break;
            }
        }
        return dp[s.length() - 1];
    }
}
