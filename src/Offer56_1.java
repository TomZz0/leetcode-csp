public class Offer56_1 {
    public static void main(String[] args) {
        int[] nums = {1,2,10,4,1,4,3,3};
        int res = 0;
        //得到所有数字异或的结果
        for (int i :nums) {
            res^=i;
        }
        //找到a^b的不相等的位用这一位可以区分a b 因为a b这一位不相等 异或结果为1
        int div = 1;
        while ((div&res)==0) div<<=1;
        //得到div 只有一位是1 其余全是0 用它与数进行&运算即可区分a b即不相等的数
        int a =0;int b=0;
        for (int i :nums) {
            if ((div&i)==0){
                a^=i;
            }else b^=i;
        }

    }
}
