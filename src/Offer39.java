import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Offer39 {
    public static void main(String[] args) {
        int[]nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        Map<Integer, Integer> integerIntegerMap = new HashMap<>();
        for (int num :nums) {
            if (integerIntegerMap.containsKey(num)){
                integerIntegerMap.put(num,integerIntegerMap.get(num)+1);
            }else {
                integerIntegerMap.put(num,1);
            }
        }
        for (Map.Entry<Integer,Integer> integerIntegerEntry :integerIntegerMap.entrySet()) {
            if (integerIntegerEntry.getValue()>nums.length/2){
                System.out.println(integerIntegerEntry.getKey());
                break;
            }
        }


    }
}
