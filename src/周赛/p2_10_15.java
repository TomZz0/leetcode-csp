package 周赛;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wzh
 * @date 2023年10月15日 10:43
 * Description:
 */
public class p2_10_15 {


    public static void main(String[] args) {
        String s = "0000101111001";int k = 5;
        String s1 = new p2_10_15().shortestBeautifulSubstring(s, k);
        System.out.println(s1);
    }

    public String shortestBeautifulSubstring(String s, int k) {
        LinkedList<Character> list = new LinkedList<>();
        LinkedList<String> res = new LinkedList<>();
        int n = s.length();
        if (n<k) return null;
        int t = k;
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '1' && t > 0) {
                t--;
                list.addLast(ch);
                if (t == 0) {
                    StringBuffer sb = new StringBuffer();
                    int ind = 0;
                    while (ind<list.size()&&list.get(ind)=='0')ind++;
                    for (int j = ind; j < list.size(); j++) sb.append(list.get(j));
                    if (list.size() == len) {
                        res.add(sb.toString());
                    } else if (list.size() < len){
                        res.clear();
                        res.add(sb.toString());
                        len = sb.length();
                    }
                    while (!list.isEmpty()&&(list.getFirst() == '0' || t == 0)) {
                        if (list.getFirst() == '1') t++;
                        list.removeFirst();
                    }
                }
            }else list.addLast(ch);
        }
        String[] arr = new String[res.size()];
        res.toArray(arr);
        Arrays.sort(arr);
        return arr.length>0?arr[0]:"";
    }
}
