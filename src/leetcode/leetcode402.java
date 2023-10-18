package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wzh
 * @date 2023年10月02日 10:47
 * Description:
 */
public class leetcode402 {
    public static void main(String[] args) {
        String s = new leetcode402().removeKdigits("10001", 1);
        System.out.println(s);
    }
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        int n = num.length();
        for (int i=0;i<n;i++){
            char c = num.charAt(i);
            while (!deque.isEmpty() && k>0&&c < deque.peekLast()){
                k--;
                deque.pollLast();
            }
            deque.offerLast(c);
        }
        for (int i=0;i<k;i++){
            deque.pollLast();
        }
        StringBuffer sb = new StringBuffer();
        boolean flag = true;
        while (!deque.isEmpty()){
            char ch = deque.pollFirst();
            if (flag && ch == '0') continue;
            flag = false;
            sb.append(ch);
        }
        return sb.toString().equals("") ? "0" : sb.toString();
    }
}
