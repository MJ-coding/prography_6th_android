package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.BiPredicate;

/**
 * bfs : 깼는지 확인해가며 탐색
 * 벽을 만나면 부수고 탐색 (어차피 bfs는 모두 탐색함)
 * visited[0][][] 안부순거
 * visited[1][][] 부순거
 */
public class Bj2206 {
    private static final int[][] DIRECTIONS = {{1,0},{0,1},{-1,0},{0,-1}};
    private static int[][][] visited;
    private static int[][] map;
    private static final int INIT = 1_000_000;
    private static final int BLOCK = 1;

    private static int N;
    private static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j = 0; j<M ; j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }

        System.out.println(bfs());

    }
    private static int bfs(){
        int answer = 0;
        Queue<Point2206> q = new ArrayDeque<>();
        initVisited();
        Point2206 start = new Point2206(0,0,0);

        q.offer(start);
        visited[0][0][0] = 1;

        while(!q.isEmpty()){
            Point2206 current = q.poll();

            for(final int[]DIRECTION : DIRECTIONS){
                int nextX = current.getX() + DIRECTION[0];
                int nextY = current.getY() + DIRECTION[1];

                if(OUT_OF_RANGE.test(nextX,nextY)) continue;
                if(map[nextX][nextY] == BLOCK){
                    if(current.getIsBroken() == 1) continue;
                    if(visited[1][nextX][nextY] != INIT) continue;

                    visited[1][nextX][nextY] = visited[current.getIsBroken()][current.getX()][current.getY()]+1;
                    Point2206 next = new Point2206(1,nextX, nextY);
                    q.offer(next);

                }else{
                    if(visited[current.getIsBroken()][nextX][nextY] != INIT) continue;

                    visited[current.getIsBroken()][nextX][nextY] = visited[current.getIsBroken()][current.getX()][current.getY()]+1;
                    Point2206 next = new Point2206(current.getIsBroken(), nextX,nextY);
                    q.offer(next);

                }
            }

        }
        answer = Math.min(visited[0][N-1][M-1], visited[1][N-1][M-1]);
        return answer == INIT ? -1 : answer;
    }
    private static final BiPredicate<Integer,Integer> OUT_OF_RANGE = (x, y) -> x < 0 || x >=N || y < 0 ||y >=M ;
    private static void initVisited() {
        visited = new int[2][N][M];
        for(int i = 0 ; i < 2; i++){
            for(int j=0 ; j < N ; j++){
                Arrays.fill(visited[i][j],INIT);
            }
        }
    }
}

class Point2206{
    int isBroken;
    int x;
    int y;

    public Point2206( int isBroken,int x, int y) {
        this.isBroken = isBroken;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getIsBroken() {
        return isBroken;
    }
}
