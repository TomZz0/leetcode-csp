package leetcode;

import java.util.*;

/**
 * @author wzh
 * @date 2023年09月21日 11:53
 * Description:
 */
public class leetcode395 {
    public static void main(String[] args) {
        Integer[]arr = {2,3,6,8,4};
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // 降序排序，所以返回b.compareTo(a)
                return b.compareTo(a);
            }
        });
        System.out.println(Arrays.toString(arr));
    }
    public int longestSubstring(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> r = new HashMap<>();
        LinkedList<Character> c = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (r.containsKey(ch)) r.put(ch, r.get(ch) + 1);
            else r.put(ch, 1);
        }
        for (char ch : r.keySet()) {
            if (r.get(ch) < k) c.add(ch);
        }
        return solu(s, 0, n - 1, c);
    }

    private int solu(String s, int l, int r, LinkedList<Character> c) {
        if (l > r) return 0;
        int index = l;
        while (index <= r) {
            if (c.contains(s.charAt(index))) break;
            index++;
        }
        if (index>r) return r-l+1;
        return Math.max(solu(s, l, index - 1, c), solu(s, index + 1, r, c));
    }
}
