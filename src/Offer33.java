public class Offer33 {
    int index;

    public static void main(String[] args) {
        int[] arr = {4, 8, 6, 12, 16, 14, 10};
        System.out.println(new Offer33().verifyPostorder(arr));
    }

    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length <= 1) return true;
        index = postorder.length-1;
        build(postorder, Integer.MAX_VALUE, Integer.MIN_VALUE);
        return index<0;
    }
    private void  build(int[]arr,int max,int min){
        //全部构建且满足二叉排序树
        if (index < 0) return;
        int val = arr[index];
        //如果出现越界值 说明(左)右子树构建完毕或者不是二叉排序树 返回
        if (index>max||index<min) return;

        index--;
        //递归构建左右子树 注意左子树比当前小 右子树比当前大
        //因为是后序遍历 所以先构建右子树 右子树构建完毕 才能构建左子树
        build(arr,max,val);
        build(arr,val,min);
    }

}
