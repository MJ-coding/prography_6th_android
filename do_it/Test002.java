package do_it;

import java.util.*;

public class Test002{
    private boolean[][] visited;
    private boolean[][] usedStart;
    private int size;
    private boolean isStart;

    public int solution(int[][] board) {
        //배열값 정렬
        //큐에 담고 돌면서 놓을 수 있는 위치인지 체크 후 놓기
        //max 구하기
        int answer = 0;
        size = board.length;
        usedStart = new boolean[size][size];

        for(int choice = 0 ; choice < size*2-1; choice++){
            PriorityQueue<Node1> q = new PriorityQueue<>(Comparator.comparingInt(Node1::getCost));
            visited = new boolean[size][size];
            int max = 0;
            isStart = false;

            for(int i = 0 ; i < size ; i++){
                for(int j = 0 ; j < size ; j++){
                    q.offer(new Node1(i,j,board[i][j]));
                }
            }

            //-cost
            while(!q.isEmpty()){
                Node1 current = q.poll();
                int x = current.getI();
                int y = current.getJ();
                int cost = -current.getCost();

                if(!isStart && !usedStart[x][y]){
                    usedStart[x][y] = true;
                    isStart = true;
                    //System.out.println(usedStart[x][y]);
                }
                if(!visited[x][y] && isStart){
                    //visited[x][y] = true;
                    max += cost;
                    checkVisit(x,y);
                }

            }
            answer = Math.max(max,answer);
        }

        return answer;

    }
    private void checkVisit(int x, int y){

        for(int i = 0 ; i < size ; i++){
            visited[x][i] = true;
            visited[i][y] = true;
        }
    }
}
class Node1{
    private int i;
    private int j;
    private int cost;

    public Node1(int i, int j, int cost){
        this.i = i ;
        this.j = j;
        this.cost = cost;
    }

    public int getI(){
        return this.i;
    }

    public int getJ(){
        return this.j;
    }

    public int getCost(){
        return -this.cost;
    }
}
