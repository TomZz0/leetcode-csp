package leetcode;

/**
 * @author wzh
 * @date 2023年09月26日 16:15
 * Description:
 */
public class leetcode11 {
    public static void main(String[] args) {
        int[]arr = {1,2,1};
        int x = maxArea(arr);
        System.out.println(x);
    }
    public static int maxArea(int[] height) {
        int l = 0, r = 0;
        int n = height.length;
        int resl=0, resr=n-1, reslh=height[0], resrh=height[n-1];
        while (l < n - 1) {
            r = n - 1;
            int rp = r;
            int lh = height[l];
            int rh = height[rp];
            while (r > l){
                if (height[r] <= rh) r--;
                else if (judge(l,lh,rp,rh,l,lh,r,height[r])) r--;
                else {
                    rp = r;rh = height[rp];
                }
            }
            if (judge(l,lh,rp,rh,resl,reslh,resr,resrh)){
                resl = l;reslh = lh;
                resr = rp;resrh = rh;
            }
            l++;
            while (l<n && height[l] <=height[resl]) l++;
        }
        return (resr-resl)*Math.min(reslh,resrh);
    }

    private static boolean judge(int l, int lh, int rp, int rh, int l1, int lh1, int r, int i) {
        return (rp-l)*Math.min(lh,rh) > (r-l1)*Math.min(lh1,i);
    }
}
