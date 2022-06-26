package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bj11724 {

    static ArrayList<Integer>[] node;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int ans = 0;
        visited = new boolean[N+1];
        node = new ArrayList[N+1];
        for(int i = 0 ; i < N+1; i++){
            node[i] = new ArrayList<>();
        }

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            node[from].add(to);
            node[to].add(from);//no direction
        }

        for(int i = 1; i < N+1; i++ ){
            if(!visited[i]){
                dfs(i);
                ans++;
            }
        }

        System.out.println(ans);


    }

    private static void dfs(int i) {
        if(visited[i])
            return;
        visited[i] = true;
        for(int v : node[i]){
            if(!visited[v])
                dfs(v);
        }
    }

}
