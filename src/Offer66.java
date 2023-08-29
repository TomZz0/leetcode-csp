import java.lang.reflect.Array;

public class Offer66 {
//    给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
//    其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
//    即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
//    示例:
//
//    输入: [1,2,3,4,5]
//    输出: [120,60,40,30,24]
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = new int[a.length];
        for (int i = 0; i <b.length; i++) {
            b[i] = method(a,i);
        }

    }
    static int method(int[] a,int index){
        int res = 1;
        for (int i = 0; i < a.length; i++) {
            if (i!=index) res*=a[i];
        }
        return res;
    }
}
