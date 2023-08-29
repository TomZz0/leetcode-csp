import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Offer3 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10,0,1};
        List<Integer> integers = new LinkedList<Integer>();
        for (int value : a) {
            if (integers.contains(value)) System.out.println(value);
            else integers.add(value);
        }
    }
}
