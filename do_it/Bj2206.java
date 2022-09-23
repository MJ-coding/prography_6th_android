package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj2206 {
    private static int N, M;
    private static int[][] map;
    private static int[][][] visited;
    private static final int INIT = 1_000_000;
    private static final int BLOCK = 1;
    private static int[][] DIRECTIONS = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        //broken 1 unbroken 0
        visited = new int[2][N][M];
        for(int i = 0 ; i < 2; i++){
            for(int j = 0 ; j < N ; j++){
                Arrays.fill(visited[i][j],INIT);
            }
        }

        for(int i = 0 ; i < N ;i++){
            String input = br.readLine();
            for(int j = 0 ; j < M ;j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        int answer = 0;
        Queue<Position> q = new ArrayDeque<>();
        q.offer(new Position(0,0,0));
        visited[0][0][0] = 1;

        while(!q.isEmpty()){
            Position current = q.poll();
            int currentX = current.getX();
            int currentY = current.getY();
            int currentIsBroken = current.getIsBroken();

            for(int[] DIRECTION : DIRECTIONS){
                int nextX = currentX + DIRECTION[0];
                int nextY = currentY + DIRECTION[1];

                if(nextX < 0 || nextY < 0 || nextX > N-1 || nextY > M-1)
                    continue;
                if(map[nextX][nextY] == BLOCK && currentIsBroken == 0 ){//안부셨으면 부수기
                    //이미방문했으면 넘기기
                    if(visited[1][nextX][nextY] != INIT)
                        continue;
                    //부순상태로 큐에 넣기
                    q.offer(new Position(1,nextX,nextY));
                    //방문경로값 갱신
                    visited[1][nextX][nextY] = visited[currentIsBroken][currentX][currentY] + 1;

                }
                if(map[nextX][nextY] == 0){
                    //벽이아니라면 방문체크 후 큐에 담기
                    if(visited[currentIsBroken][nextX][nextY] != INIT)
                        continue;
                    q.offer(new Position(currentIsBroken,nextX,nextY));
                    //방문경로값 갱신
                    visited[currentIsBroken][nextX][nextY] = visited[currentIsBroken][currentX][currentY] + 1;
                }
            }
        }

        answer = Math.min(visited[1][N-1][M-1],visited[0][N-1][M-1]);
        return answer == INIT ? -1 : answer;
    }

}
class Position
{
    private int isBroken;
    private int x;
    private int y;

    public Position(int isBroken, int x, int y){
        this.isBroken = isBroken;
        this.x = x;
        this.y = y;
    }

    public int getIsBroken() {
        return isBroken;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
