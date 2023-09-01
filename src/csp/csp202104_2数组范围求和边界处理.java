package csp;

import java.util.Scanner;

/**
 * @author wzh
 * @date 2023年09月01日 10:03
 * Description:将矩阵扩充 因为是求平均值 所以多加n个值为阈值t的数平均值比较结果不会变 考虑边界问题不好处理
 * 这里将矩阵初步扩充到n+r 小矩阵(即要求平均值的矩阵)边长为2r+1.这样就不会出现不完整矩阵
 * 在具体求解时 将矩阵进行处理使得 A[i][j]的值是从 0 0 到 i j 所有元素的和
 * 这样求小矩阵时直接用小矩阵右上方顶点对左下角顶点在往左下的顶点进行处理即可 类似矩阵范围求和
 * 这里为了防止越界 再加一环0边，比如如下矩阵
 * t t t t
 * t 1 2 t
 * t 3 4 t
 * t t t t 进行求解时若矩阵中心为1 则要求的矩阵为
 *
 * t t t 在进行减法时要减去的下标越界了 而且这里右下角在处理后的值就是这个矩阵的和 减去0即可
 * t 1 2 所以考虑再加一层0 使得其变为
 * t 3 4
 *
 * 0 0 0 0 0
 * 0 t t t 0
 * 0 t 1 2 0
 * 0 t 3 4 0
 * 0 0 0 0 0 这样在进行计算就不会出现任何越界问题 不过要注意遍历i j 的开始结束点 可以在纸上模拟
 */
public class csp202104_2数组范围求和边界处理 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = in.nextInt();
        int r = in.nextInt();
        int t = in.nextInt();
        int[][]arr = new int[n+r*2+2][n+r*2+2];
        //接收键盘输入同时将中间层设置为t
        for (int i=1;i<arr.length-1;i++){
            for (int j=1;j<arr[i].length-1;j++){
                if (i<r+1 || i > r+n || j <r+1 ||j>r+n) arr[i][j] = t;
                else arr[i][j] = in.nextInt();
            }
        }
        //进行矩阵求和 先将最上边和最左边初始化 累加即可
        for (int i=1;i<=n+r*2;i++) arr[1][i]+=arr[1][i-1];
        for (int i=1;i<=n+r*2;i++) arr[i][1]+=arr[i-1][1];
        //将其余矩阵求和 不包括外层0
        for (int i=2;i<=n+r*2;i++){
            for (int j=2;j<=n+r*2;j++){
                arr[i][j] += arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
            }
        }
        //遍历内层矩阵 求得小矩阵和, 与整个矩阵的阈值(矩阵元素个数*单个阈值t) 比较即可
        int res = 0;
        for (int i=r+1;i<=n+r;i++){
            for (int j=r+1;j<=n+r;j++){
                if (arr[i+r][j+r] - arr[i-r-1][j+r] - arr[i+r][j-r-1]+arr[i-r-1][j-r-1] <=(r*2+1)*(r*2+1)*t) res++;
            }
        }
        System.out.println(res);
    }
}
