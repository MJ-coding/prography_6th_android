package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.BiPredicate;

/*
4 6
101111
101010
101011
111011
 */
public class Bj2178 {
    private static final int[][] DIRECTIONS = {{1,0},{0,1},{-1,0},{0,-1}};
    private static int[][] visited;
    private static int[][] map;
    private static final int BLOCK = 0;
    private static int N;
    private static int M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];

        for(int i =0; i< N ; i++){
            String input = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = input.charAt(j) - '0';//charAt
            }
        }

        Point2178 start = new Point2178(0,0);
        Point2178 end = new Point2178(N-1, M-1);

        bfs(start,end);
        System.out.println(visited[end.getX()][end.getY()]);

    }
    private static final BiPredicate<Integer,Integer> OUT_OF_RANGE = (x,y) ->
            x < 0 || x > N-1 || y < 0 || y > M-1;

    private static void bfs(Point2178 start, Point2178 end){
        Queue<Point2178> q = new ArrayDeque<>();
        q.offer(start);
        visited[start.getX()][start.getY()] = 1;

        while(!q.isEmpty()){
            Point2178 current = q.poll();
            for(final int[] DIRECTION : DIRECTIONS){
                int nextX = current.getX() + DIRECTION[0];
                int nextY = current.getY() + DIRECTION[1];

                if(OUT_OF_RANGE.test(nextX,nextY)) continue;
                if(visited[nextX][nextY] != 0) continue;
                if(map[nextX][nextY] == BLOCK) continue;

                visited[nextX][nextY] = visited[current.getX()][current.getY()] + 1;
                Point2178 next = new Point2178(nextX,nextY);
                if(next.equals(end)) return;
                q.offer(next);

            }
        }

    }
}

class Point2178{
    int x;
    int y;

    public Point2178(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj){
        if( obj instanceof Point2178){
            Point2178 point = (Point2178) obj;
            if(this.getX() == point.getX() && this.getY() == point.getY()){
                return true;
            }
        }
        return false;
    }
    @Override
    public int hashCode(){
        return this.hashCode();
    }
}

