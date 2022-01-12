package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.BiPredicate;

/*
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
 */
public class Bj2667 {
    private static final int[][] DIRECTIONS = {{1,0},{0,1},{-1,0},{0,-1}};
    private static final int BLOCK = 0;

    private static int[][] map;
    private static int[][] visited;
    private static LinkedList<Integer> answer;
    private static int cnt = 1;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = new LinkedList<>();

        map = new int[N][N];
        visited = new int[N][N];

        for(int i = 0;i<N ;i++){
            String input = br.readLine();
            for(int j =0; j<N; j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for(int i = 0 ; i<N ;i++){
            for(int j =0; j< N; j++){
                Coordinates start = new Coordinates(i,j);
                if(visited[i][j] == 1 || map[i][j] == BLOCK ) continue;
                cnt = 1;
                visited[i][j] = 1;
                bfs(start);
            }
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");

        while(!answer.isEmpty()){
            sb.append(answer.remove()).append("\n");
        }


    }
    private static final BiPredicate<Integer,Integer> CHECK_REGION =(x,y) -> x < 0 || y < 0 || x >= N || y >= N ;

    private static void bfs(Coordinates start) {
        Queue<Coordinates> q = new ArrayDeque<>();
        q.offer(start);
        while(!q.isEmpty()){
            Coordinates current = q.poll();
            for (final int[] direction : DIRECTIONS){
                int nextX = current.getX() + direction[0];
                int nextY = current.getY() + direction[1];
                Coordinates next = new Coordinates(nextX, nextY);

                if(CHECK_REGION.test(next.getX(), next.getY())) continue;
                if(visited[next.getX()][next.getY()] == 1) continue;
                if(map[next.getX()][next.getY()] == BLOCK) continue;

                visited[next.getX()][next.getY()] = 1;
                cnt++;
                q.offer(next);

            }
        }
        answer.add(cnt);
    }

}
class Coordinates {
    int x;
    int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}