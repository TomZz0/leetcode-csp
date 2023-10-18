package leetcode;

/**
 * @author wzh
 * @date 2023年09月05日 16:21
 * Description:
 */
public class leet91 {
    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }
    public static int numDecodings(String s) {
        if(s.charAt(0)=='0') return 0;
        int res = 1;
        String[] split = s.split("0");
        for (int i=0;i<split.length;i++){
            String s1 = split[i];
            int[] arr = new int[s1.length()+(i==split.length-1?0:1)];
            arr[0] = 1;
            for (int j=1;j<arr.length;j++){
                if (j==arr.length-1&&arr.length!=s1.length()){
                    if (j-2>=0) arr[j]= arr[j-2];
                    else arr[j] = 1;
                    break;
                }
                int x = Integer.parseInt(s1.charAt(j-1)+""+s1.charAt(j));
                arr[j] = arr[j-1]+ (x<=26?1:0);
            }
            res*=arr[arr.length-1];
        }
        return res;
    }
}
