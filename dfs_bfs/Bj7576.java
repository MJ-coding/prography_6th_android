package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Predicate;

public class Bj7576 {
    private static final int[][] DIRECTIONS = {{1,0},{0,1},{-1,0},{0,-1}};
    private static int[][] map;
    private static boolean[][] visited;
    private static Queue<Location7576> q;
    private static int N,M;
    private static final int BLOCK = -1;
    private static final int TOMATO = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        q = new ArrayDeque<>();

        for(int i = 0; i< N; i++){
           st = new StringTokenizer(br.readLine());
           for(int j = 0 ; j < M; j++){
               int data = Integer.parseInt(st.nextToken());
               if(data == 1){
                   q.offer(new Location7576(i,j,0));
                   visited[i][j] = true;
               }
               map[i][j] = data;
           }
        }

        System.out.println(bfs());
    }
    private static final Predicate<Location7576> OUT_OF_RANGE = location -> location.getX() < 0 || location.getX() >= N
            || location.getY() < 0 || location.getY() >= M;


    private static int bfs() {
        int answer = 0;

        while(!q.isEmpty()){
            Location7576 current = q.poll();
            answer = current.getDays();

            for(int[] DIRECTION : DIRECTIONS){
                int nextX = current.getX() + DIRECTION[0];
                int nextY = current.getY() + DIRECTION[1];
                Location7576 next = new Location7576(nextX,nextY, answer+1);

                if(OUT_OF_RANGE.test(next)) continue;
                if(visited[nextX][nextY]) continue;
                if(map[nextX][nextY] == BLOCK) continue;
                if(map[nextX][nextY] == TOMATO) continue;

                q.offer(next);
                visited[nextX][nextY] = true;
                //days = next.getDays();

            }

        }
        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < M ;j++){
                if(map[i][j] == 0 && !visited[i][j]) answer = -1;
            }
        }

        return answer;
    }
}
class Location7576{
    private int x;
    private int y;
    private int days;

    public Location7576(int x, int y, int day){
        this.x = x;
        this.y = y;
        this.days = day;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public int getDays() {
        return days;
    }
}
