package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author wzh
 * @date 2023年09月23日 19:53
 * Description:
 */
public class 蓝桥杯重新排序 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int n = scan.nextInt();
        Integer[] a = new Integer[n];
        Integer[]b = new Integer[n];
        Integer[]c = new Integer[n];
        Arrays.fill(b,0);
        for(int i=0;i<n;i++){
            a[i] = scan.nextInt();
            c[i] = a[i];
            if (i>0)
                a[i]+=a[i-1];

        }
        long sum1 = 0;
        long sum2 = 0;
        int m = scan.nextInt();
        for(int i=0;i<m;i++){
            int l = scan.nextInt()-1;
            int r = scan.nextInt()-1;
            if (l==0)
                sum1+=a[r];
            else
                sum1 += a[r]-a[l-1];
            b[l]++;
            if (r+1<n) b[r+1]--;
        }
        int num=0;
        for (int i=0;i<n;i++){
            num+=b[i];
            b[i] = num;
        }
        Arrays.sort(c, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // 降序排序，所以返回b.compareTo(a)
                return b.compareTo(a);
            }
        });
        Arrays.sort(b, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // 降序排序，所以返回b.compareTo(a)
                return b.compareTo(a);
            }
        });
        for(int i=0;i<n;i++){
            for(int j=0;j<b[i];j++) sum2+=c[i];
        }
        System.out.println(sum2-sum1);
        scan.close();
    }
}
