package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj17141 {
    private static int N,M;
    private static final int[][] DIRECTIONS = {{1,0},{0,1},{-1,0},{0,-1}};
    private static int[][] lab;
    private static List<Integer> virusIndex;
    private static int[] index;
    private static boolean[] visited;
    private static int size;
    private static int blocks;
    private static int min = Integer.MAX_VALUE;

    private static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][N];
        virusIndex = new ArrayList<>();

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< N; j++){
                lab[i][j] = Integer.parseInt(st.nextToken());
                if(lab[i][j] == 2){
                    virusIndex.add(i*N + j);
                    lab[i][j] = 0;
                }else if(lab[i][j] == 1){
                    blocks++;
                }
            }
        }

        size = virusIndex.size();
        index = new int[M];
        visited = new boolean[size];

        for(int start = 0 ; start <= size-M; start++){
            Arrays.fill(index,-1);
            recursion(start,0);
        }

        System.out.println(min == INF ? -1: min);

    }

    private static void recursion(int current, int count) {
        visited[current] = true;
        index[count] = virusIndex.get(current);

        if(count == M - 1){
            min = Math.min(bfs(index),min);
            return;
        }

        for(int next = current + 1; next < size; next++){
            if(visited[next]) continue;
            recursion(next,count + 1);

            visited[next] = false;
            index[count + 1] = -1;
        }
    }

    private static int bfs(int[] index) {
        Queue<Location17141> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        int time = 0;
        int virus = 0;

        for(int value : index){
            q.offer(new Location17141(value/N,value%N,0));
            visited[value/N][value%N] = true;
            virus++;
        }

        while(!q.isEmpty()){
            Location17141 current = q.poll();

            for(int[] DIRECTION : DIRECTIONS){
                int nextX = current.getX() + DIRECTION[0];
                int nextY = current.getY() + DIRECTION[1];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
                if(visited[nextX][nextY]) continue;
                if(lab[nextX][nextY] == 1) continue;

                Location17141 next = new Location17141(nextX,nextY,current.getTime()+1);
                time = Math.max(time,next.getTime());
                visited[nextX][nextY] = true;
                q.offer(next);
                virus++;
            }
        }

        return N*N - (virus + blocks) == 0 ? time : INF;
    }
}
class Location17141{
    private int x;
    private int y;
    private int time;

    public Location17141(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTime() {
        return time;
    }
}
