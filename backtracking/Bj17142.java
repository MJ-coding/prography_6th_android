package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj17142 {
    private static int N,M;
    private static int min = 1_000_000_000;
    private static int blocks = 0;
    private static int initVirus;
    private static int virusNum;
    private static int[][] lab;
    private static boolean[] visited;
    private static ArrayList<Integer> virus;
    private static int[] activeVirus;
    private static int[][] DIRECTIONS = {{1,0},{0,1},{-1,0},{0,-1}};

    private static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][N];
        activeVirus = new int[M];
        virus = new ArrayList<>();

        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N; j++){
                lab[i][j] = Integer.parseInt(st.nextToken());
                if(lab[i][j] == 2){
                    virus.add(i*N+j);
                }else if(lab[i][j] == 1){
                    blocks++;
                }

            }
        }
        virusNum = virus.size();
        for(int start = 0 ; start <= virusNum-M; start++){
            visited = new boolean[virusNum];
            recursion(start,0);
        }

        System.out.println(min == INF ? -1: min);


    }

    private static void recursion(int current, int count) {
        visited[current] = true;
        activeVirus[count] = virus.get(current);

        if(count == M-1){
            min = Math.min(min,bfs());
            return;
        }
        for(int next = current+1; next < virusNum; next++){
            if(visited[next]) continue;
            recursion(next,count+1);
            visited[next] = false;
        }
    }

    private static int bfs() {
        Queue<Location17142> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        int time = 0;
        initVirus = blocks + M;

        for(int index : activeVirus){
            q.offer(new Location17142(index/N,index%N,0));
            visited[index/N][index%N] = true;
        }
        while(!q.isEmpty()){
            Location17142 current = q.poll();

            for(int[] DIRECTION : DIRECTIONS){
                int nextX = current.getX() + DIRECTION[0];
                int nextY = current.getY() + DIRECTION[1];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                if(visited[nextX][nextY]) continue;
                if(lab[nextX][nextY] == 1) continue;

                visited[nextX][nextY] = true;
                Location17142 next = new Location17142(nextX,nextY,current.getTime()+1);
                q.offer(next);
                if(lab[nextX][nextY] == 0 )
                    time = Math.max(time,next.getTime());
                initVirus++;

            }
        }

        return N*N - initVirus == 0 ? time : INF;

    }
}
class Location17142{
    private int x;
    private int y;
    private int time;

    public Location17142(int x, int y, int time) {
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

    public int getTime(){
        return time;
    }
}
