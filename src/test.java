import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * @author wzh
 * @date 2023年08月16日 10:26
 * Description:
 */
public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] s = new String[110];
        for (int i=0;i<n;i++){
            s[i] = "";
            for (int j=0;j<8;j++){
                String ss = in.next();
                s[i]+=ss;
            }

            int count = 1;
            for (int j=0;j<i;j++){
                if (s[i].equals(s[j])) count++;
            }
            if (i!=n-1)
            System.out.println(count);
            else
                System.out.print(count);
        }
    }
}
