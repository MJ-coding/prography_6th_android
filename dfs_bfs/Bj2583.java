
package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiPredicate;

public class Bj2583 {
    private static final int[][] DIRECTIONS =  {{1,0},{0,1},{-1,0},{0,-1}};
    private static final int BLOCK = 1;
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";
    private static int[][] map;
    private static boolean[][] visited;
    private static List<Integer> answer;
    private static int area;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        answer = new ArrayList<>();

        while(K-- >0){
            st = new StringTokenizer(br.readLine());
            Point2583 start = new Point2583(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            Point2583 end = new Point2583(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            for(int i = start.getX(); i < end.getX(); i++){
                for(int j = start.getY(); j < end.getY(); j++){
                    map[i][j] = 1;
                }
            }
        }
        for(int i = 0 ; i< N; i++){
            for(int j = 0; j< M; j++){
                if(visited[i][j] || map[i][j] == BLOCK) continue;
                visited[i][j] = true;
                bfs(i,j);
                area++;
            }
        }
        sb.append(area).append(NEW_LINE);
        Collections.sort(answer);
        for(int i = 0 ; i< answer.size(); i++){
            sb.append(answer.get(i)).append(SPACE);
        }
        System.out.println(sb);

    }
    private static final BiPredicate<Integer,Integer> CHECK_REGION = (x,y) -> x < 0 || x >= N || y < 0 || y >= M;
    
    private static void bfs(int x, int y) {
        int cnt = 1;
        Point2583 start = new Point2583(x,y);
        Queue<Point2583> q = new ArrayDeque<>();
        q.offer(start);

        while(!q.isEmpty()){
            Point2583 current = q.poll();
            for( int[] direction : DIRECTIONS){
                int nextX = current.getX() + direction[0];
                int nextY = current.getY() + direction[1];
                Point2583 next = new Point2583(nextX,nextY);

                if(CHECK_REGION.test(next.getX(),next.getY())) continue;
                if(visited[next.getX()][next.getY()]) continue;
                if(map[next.getX()][next.getY()] == BLOCK) continue;

                visited[next.getX()][next.getY()] = true;
                q.offer(next);
                cnt++;

            }
        }
        answer.add(cnt);

    }
}
class Point2583{
    private int x;
    private int y;

    public Point2583(int x, int y){
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
