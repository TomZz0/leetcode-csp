import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wzh
 * @date 2023年03月26日 12:38
 * Description:
 */
public class OfferⅡ_75 {
    public static void main(String[] args) {
        int[] arr1 = {26,21,11,20,50,34,1,18};
        int[] arr2 = {21,11,26,20};
        arr1 = new OfferⅡ_75().relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(arr1));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Integer[] arr = new Integer[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr[i] = arr1[i];
        }
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return getIndex(arr2, o1) - getIndex(arr2, o2);
            }
        });
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[i];
        }
        return arr1;
    }

    public static int getIndex(int[] arr2, int val) {
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] == val) return i;
        }
        return val + arr2.length;
    }
}
