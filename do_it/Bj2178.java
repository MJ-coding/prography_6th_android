package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj2178 {
    static int[][] DIRECTIONS = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] visited;
    static int[][] map;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[N][M];
        map = new int[N][M];

        for(int i = 0 ; i < N ; i++){
            String input = br.readLine();
            for(int j = 0 ; j < M; j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }

        System.out.println(BFS());

    }

    private static int BFS() {
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(new Pos(0,0));
        visited[0][0] = 1;

        while(!q.isEmpty()){
            Pos current = q.poll();

            for(int[] DIRECTION : DIRECTIONS){
                int nextX = current.x + DIRECTION[0];
                int nextY = current.y + DIRECTION[1];
                if( nextX >= 0 && nextX < N  && nextY >= 0 && nextY < M
                    && visited[nextX][nextY] == 0 && map[nextX][nextY] != 0){
                   visited[nextX][nextY] = visited[current.x][current.y] + 1;
                   q.offer(new Pos(nextX,nextY));
                }
            }
        }

        return visited[N-1][M-1];

    }

}
class Pos{
    public int x;
    public int y;

    public Pos(int x,int y){
        this.x = x;
        this.y = y;
    }
}
