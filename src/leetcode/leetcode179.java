package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wzh
 * @date 2023年09月30日 10:21
 * Description:
 */
public class leetcode179 {

    public static void main(String[] args) {
        int[] arr = {3,30,34,5,9};
        String s = new leetcode179().largestNumber(arr);
        System.out.println(s);
    }

    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] s = new String[n];
        for (int i=0;i<n;i++){
            s[i] = nums[i] +  "";
        }
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;
                return s2.compareTo(s1);
            }
        });
        StringBuilder res = new StringBuilder();
        for (int i=0;i<n;i++){
            res.append(s[i]);
        }
        return res.toString();
    }
}
