package leetcode;

import java.util.HashMap;

/**
 * @author wzh
 * @date 2023年10月02日 9:37
 * Description:
 */
public class leetcode397 {
    HashMap<Integer,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int i = new leetcode397().integerReplacement(1073741824);
        System.out.println(i);
    }

    public int integerReplacement(int n) {
        if (n==Integer.MAX_VALUE) return 2+ solu((n-1)/2 + 1);
        return solu(n);
    }

    public int solu(int n){
        if(n <= 2) return n-1;
        if(n%2==0){
            if (map.containsKey(n/2)) return 1+map.get(n/2);
            int t = solu(n/2);
            map.put(n/2,t);
            return 1+t;
        }else{
            int x = map.containsKey(n+1)?map.get(n+1):solu(n+1);
            int y = map.containsKey(n-1)?map.get(n-1):solu(n-1);
            map.put(n+1,x);
            map.put(n-1,y);
            return 1+Math.min(x,y);
        }
    }
}
