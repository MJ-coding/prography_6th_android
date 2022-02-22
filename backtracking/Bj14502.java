package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj14502 {
    private static int N,M;
    private static int[][] lab;
    private static boolean[] visited;
    private static List<Integer> blanks = new ArrayList<>();
    private static List<Location14502> virus = new ArrayList<>();
    private static int[][] DIRECTIONS = {{1,0},{0,1},{-1,0},{0,-1}};
    private static int blocks = 3;
    private static int size;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][M];

        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                lab[i][j] = Integer.parseInt(st.nextToken());

                if(lab[i][j] == 0){
                    blanks.add(i*M + j);
                }else if(lab[i][j] == 1){
                    blocks++;
                }else{
                    virus.add(new Location14502(i,j));
                }
            }
        }

        size = blanks.size();
        visited = new boolean[size];
        for(int start = 0; start <= size - 3; start++){
            recursion(start,0,new int[]{-1,-1,-1});
        }

        System.out.println(max);

    }

    private static void recursion(int current, int count, int[] blankIndex) {
        visited[current] = true;
        blankIndex[count] = blanks.get(current);

        if(count == 2){
            max = Math.max(bfs(blankIndex),max);
            return;
        }

        for(int next = current + 1; next < size; next++){
            if(visited[next]) continue;
            recursion(next,count + 1,blankIndex);

            visited[next] = false;
            blankIndex[count+1] = -1;
        }
    }

    private static int bfs(int[] blankIndex) {
        Queue<Location14502> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        int virusNum = blocks;

        for(int index : blankIndex){
            lab[index/M][index%M] = 1;
        }

        for(Location14502 start : virus){
            if(visited[start.getX()][start.getY()]) continue;

            q.offer(start);
            visited[start.getX()][start.getY()] = true;
            virusNum++;
        }
        while(!q.isEmpty()){
            Location14502 current = q.poll();
            for(int[] DIRECTION : DIRECTIONS){
                int nextX = current.getX() + DIRECTION[0];
                int nextY = current.getY() + DIRECTION[1];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if(visited[nextX][nextY]) continue;
                if(lab[nextX][nextY] == 1) continue;

                Location14502 next = new Location14502(nextX,nextY);
                q.offer(next);
                visited[nextX][nextY] = true;
                virusNum++;
            }
        }

        for(int index : blankIndex){
            lab[index/M][index%M] = 0;
        }

        return N*M - virusNum;
    }
}
class Location14502{
    private int x;
    private int y;

    public Location14502(int x, int y){
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
