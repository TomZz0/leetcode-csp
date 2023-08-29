import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author wzh
 * @date 2023年03月27日 15:56
 * Description:
 */
public class OfferⅡ06 {

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int des = 0;
        int index1 = 0;
        int index2 = numbers.length-1;
        while (numbers[index1] + numbers[index2] != target) {
            if (numbers[index1] + numbers[index2] > target) index2--;
            else index1++;
        }
        res[0] = index1;
        res[1] = index2;
        return res;
    }
}
