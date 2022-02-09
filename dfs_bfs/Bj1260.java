package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj1260 {
    private static List<Integer>[] path;
    private static StringBuilder sb;
    private static boolean[] visited;
    private static int N;
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken()) -1;

        path = new ArrayList[N];
        visited = new boolean[N];
        for(int i = 0 ;i< N ; i++){
            path[i] = new ArrayList<>();
        }
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;

            path[from].add(to);
            path[to].add(from);
        }
        for(List<Integer> p : path){
            Collections.sort(p);
        }
        sb = new StringBuilder();
        Arrays.fill(visited,false);
        dfs(V);

        Arrays.fill(visited,false);
        sb.append(NEW_LINE);
        bfs(V);

        System.out.println(sb);

    }

    private static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        sb.append(start+1).append(SPACE);

        while(!q.isEmpty()){
            int current = q.poll();
            for(int next : path[current]){
                if(visited[next]) continue;
                q.offer(next);
                visited[next] = true;
                sb.append(next+1).append(SPACE);
            }
        }
    }

    private static void dfs(int current) {
        visited[current] = true;
        sb.append(current+1).append(SPACE);

        for(int next : path[current]){
            if(visited[next]) continue;
            visited[next] = true;

            dfs(next);
        }

    }
}
