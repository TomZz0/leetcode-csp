import java.lang.reflect.Array;
import java.time.chrono.MinguoDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Offer38 {
    public String[] permutation(String s) {
        List<String> pre=new ArrayList<>();

        char[] arr=s.toCharArray();
        Arrays.sort(arr);


        StringBuilder path=new StringBuilder();

        //注意创建的类型
        boolean[] visited=new boolean[arr.length];
        // Arrays.fill(visited,false);

        dfs(pre,path,visited,arr);

        // String[] res=new String[pre.size()];

        // int i=0;
        // for(String str:pre){
        // 	res[i++]=str;
        // }

        //注意这里是0，不是pre.length()
        return pre.toArray(new String[0]);
    }


    private void dfs(
            List<String> pre,
            StringBuilder path,
            boolean[] visited,
            char[] arr
    ){
        if(path.length()==arr.length){
            pre.add(path.toString());
            return;
        }


        for(int i=0;i<arr.length;i++){
            if(visited[i]){
                continue;
            }

            //防止重复
            if(i>0&&arr[i]==arr[i-1]&& !visited[i - 1]){
                continue;
            }

            path.append(arr[i]);
            visited[i]=true;

            dfs(pre,path,visited,arr);

            path.deleteCharAt(path.length()-1);
            visited[i]=false;
        }


    }

}
