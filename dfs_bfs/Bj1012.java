package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.BiPredicate;

public class Bj1012 {
    private static final int[][] DIRECTIONS = {{1,0},{0,1},{-1,0},{0,-1}};
    private static Location[] locations;
    private static boolean[][] visited;
    private static int[][] map;
    private static int worms;
    private static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            worms = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            visited = new boolean[N][M];
            map = new int[N][M];
//            Arrays.fill(map,0);

            locations = new Location[K];
            for(int i = 0 ; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int lettuceY = Integer.parseInt(st.nextToken());
                int lettuceX = Integer.parseInt(st.nextToken());

                locations[i] = new Location(lettuceX,lettuceY);
                map[lettuceX][lettuceY] = 1;

            }
            for(Location location : locations){
                if(visited[location.getX()][location.getY()]) continue;
                bfs(location.getX(),location.getY());

            }
            System.out.println(worms);
        }
    }
    private static final BiPredicate<Integer,Integer> OUT_OF_RANGE = (x,y) -> x < 0 || y < 0 || x >= N || y >= M;

    private static void bfs(int x, int y) {
        Location start = new Location(x,y);
        Queue<Location> q = new ArrayDeque<>();
        q.offer(start);
        visited[x][y] = true;

        while(!q.isEmpty()){
            Location current = q.poll();

            for(int[] direction : DIRECTIONS){
                Location next = new Location(current.getX()+direction[0], current.getY()+direction[1]);

                if(OUT_OF_RANGE.test(next.getX(), next.getY())) continue;
                if(visited[next.getX()][next.getY()]) continue;
                if(map[next.getX()][next.getY()] == 0) continue;

                visited[next.getX()][next.getY()] = true;
                q.offer(next);

            }
        }
        worms++;
    }

}
class Location{
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
