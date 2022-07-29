package do_it;
import java.util.*;


public class Test{

    public static void main(String[] args) {
        int[][] answer = solution(new int[][] {{0,0,0,0}, {0,1,1,0},{0,1,1,1},{0,1,1,1}});
        for(int i = 0 ; i < answer.length; i++){
            for(int j = 0 ; j <answer.length; j++){
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static int[][] DIRECTIONS = {{1,0},{0,1},{-1,0},{0,-1}};
    private static int[][] visited;
    private static int[][] answer;
    private static int size;

    private static int[][] solution(int[][] city){
        size = city.length;
        answer = new int[size][size];

        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ;j++){
                if(city[i][j] == 1){
                    bfs(i,j,city);
                }
            }
        }
        return answer;
    }
    private static void bfs(int i, int j, int[][] city){
        visited = new int[size][size];
         Queue<Pos1> q = new ArrayDeque<>();
         q.offer(new Pos1(i,j));
         visited[i][j] = 1;

        while(!q.isEmpty()){
            Pos1 current = q.poll();
            int currentX = current.getX();
            int currentY = current.getY();

            for(int[] DIRECTION : DIRECTIONS){
                int nextX = currentX + DIRECTION[0];
                int nextY = currentY + DIRECTION[1];

                if(nextX >= 0 && nextX < size && nextY >= 0 && nextY < size && visited[nextX][nextY] == 0){

                    if(city[nextX][nextY] == 0){
                        visited[nextX][nextY] = visited[currentX][currentY] + 1;
                        answer[i][j] = visited[nextX][nextY];
                        return;
                    }
                    if(answer[nextX][nextY] != 0){
                        answer[i][j] = answer[nextX][nextY] + 1;
                        return;

                    }
//                    if(city[nextX][nextY] == 1 && answer[nextX][nextY] != 0){
//                        answer[i][j] = answer[nextX][nextY] + 1;
//                        return;
//                    }
                    if(city[nextX][nextY] == 1 ){
                         visited[nextX][nextY] = visited[currentX][currentY] + 1;
                         q.offer(new Pos1(nextX,nextY));
                    }

                }
            }
        }
    }
}
class Pos1{
    private int x;
    private int y;

    public Pos1(int x,int y){
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
