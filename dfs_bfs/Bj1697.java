package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj1697 {
    private static int K;
    private static int size;
    private static int[] visited;
    private static final int[] MOVE = {2,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        size = Math.max(N,K)*2;
        visited = new int[size+10];

        if(K <= N){
            System.out.println(N-K);
        }else{
            System.out.println(bfs(N)-1);
        }
    }
    private static boolean checkRange(int x){
        return 0 <= x && x <= K+2 ? true : false;
    }

    private static int bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        visited[start] = 1;
        q.offer(start);

        while(!q.isEmpty()){
            int current = q.poll();

            for(int move : MOVE){
                int next = current;
                if(move == 2) {
                    next *= move;
                } else{
                    next += move;
                }
                if(!checkRange(next)) continue;
                if(visited[next] != 0) continue;
                if(visited[K] != 0) return visited[K];

                q.offer(next);
                visited[next] = visited[current] + 1;
            }
        }
        return visited[K];
    }
}
