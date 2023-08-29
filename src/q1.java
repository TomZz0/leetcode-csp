import java.util.*;

/**
 * @author wzh
 * @date 2023年06月11日 14:39
 * Description:
 */
public class q1 {
    static int Max = 100000;
    static LinkedList<Integer>[] relations;
    static boolean[] ifVisited = new boolean[Max];
    static Character[] SexOfEvery = new Character[Max];
    static boolean res;
    static {
        relations = new LinkedList[Max];
        for (int i=0;i<Max;i++){
            relations[i] = new LinkedList<>();
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for (int i=0;i<num;i++){
            int id = in.nextInt();
            SexOfEvery[id] = in.next().charAt(0);
            int father = in.nextInt();
            int mather = in.nextInt();
            if (father!=-1){
                SexOfEvery[father] = 'M';
                relations[id].add(father);
            }
            if (mather!=-1){
                SexOfEvery[mather] = 'F';
                relations[id].add(mather);
            }
        }
        num = in.nextInt();
        for (int i=0;i<num;i++){
            int p1 = in.nextInt();
            int p2 = in.nextInt();
            if (SexOfEvery[p1] == SexOfEvery[p2]){
                if (i!=num-1) System.out.println("Never Mind");
                else System.out.print("Never Mind");
                continue;
            }
            ifVisited[p1] = ifVisited[p2] = true;
            res = false;
            dfs(p1,0);
            dfs(p2,0);
            if(!res){
                if (i!=num-1) System.out.println("Yes");
                else System.out.print("Yes");
            }else {
                if (i!=num-1) System.out.println("No");
                else System.out.print("No");
            }
        }
    }

    private static void dfs(int p, int num) {
        if (num>=4) return ;//
        for(int i=0;i<relations[p].size();i++)
        {
            if(!ifVisited[relations[p].get(i)])
            {
                ifVisited[relations[p].get(i)]=true;//标记出现的人
                dfs(relations[p].get(i),num+1);
            }
            else
                res=true;//五服之内出现一样的人
        }
    }

}

