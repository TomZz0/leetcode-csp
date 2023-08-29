public class Offer04 {
    public static void main(String[] args) {
        int[][] matrix = new int[12][12];
        long start = System.currentTimeMillis();
        int target = 6753;
        int high = 0,low = 0;
        for (; high < matrix.length; high++) {
            if (matrix[high][0] > target){
                break;
            }
        }
        while (low<matrix.length&&matrix[low][matrix[low].length-1] < target) low++;
        for (int i = low; i < high; i++) {
            int left = 0, right = matrix[i].length - 1;
            int mid = (left + right) / 2;
            while (left >= 0 && right < matrix[0].length && left <= right) {
                if (matrix[i][mid]==target){
                    System.out.println(true);
                    long end = System.currentTimeMillis();
                    System.out.println(end-start);
                    return;
                }else if (matrix[i][mid] > target) {
                    right = mid - 1;
                }else{
                    left = mid+1;
                }
                mid = (left + right) / 2;
            }
        }
        System.out.println(false);
    }
}
