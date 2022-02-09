package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.BiPredicate;

public class Bj1697 {
    private static int K;
    private static boolean[] visited;
    private static final int[] MOVE = {-1,1,2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[Math.max(N,K) + 1];

        System.out.println(bfs(N));
    }
    private static boolean checkRange(int x){
        return 0 <= x && x <= K ? true : false;
    }

    private static int bfs(int start){
        int time = 0;
        Queue<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        q.offer(start);

        while(!q.isEmpty()){
            int current = q.poll();

            for(int next : MOVE){
                if(next == 2) next = current*2;
                if(!checkRange(next)) continue;
                if(visited[next]) continue;

                q.offer(next);
                visited[next] = true;
                time++;
            }
        }
        return time;
    }
}
