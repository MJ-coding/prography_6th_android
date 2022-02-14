package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Bj14226 {
    private static final int[] CALCULATE = {1,2,3};
    private static int[][] time;
    private static int S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        time = new int[S*2][S*2];
        Sticker start = new Sticker(1,0);
        System.out.println(bfs(start)-1);


    }

    private static int bfs(Sticker start) {
        Queue<Sticker> q = new ArrayDeque<>();
        q.offer(start);
        time[start.getDisplay()][start.getBoard()] = 1;
        int nextBoard = 0;

        while(!q.isEmpty()){
            Sticker current = q.poll();
            for(int cal : CALCULATE){
                Sticker next;
                if(cal == 1){
                    next = new Sticker(current.getDisplay(), current.getDisplay());
                }else if( cal == 2){
                    if(current.getBoard() == 0) continue;
                    next = new Sticker(current.getDisplay() + current.getBoard(), current.getBoard());
                }else{
                    next = new Sticker(current.getDisplay()-1, current.getBoard());
                }
                if(next.getDisplay() < 0 || next.getDisplay() > S) continue;
                if(time[next.getDisplay()][next.getBoard()] != 0) continue;

                time[next.getDisplay()][next.getBoard()] = time[current.getDisplay()][current.getBoard()] + 1;
                if(next.getDisplay() == S) return time[S][next.getBoard()];
                q.offer(next);
            }
        }

        return time[S][nextBoard];
    }
}
class Sticker{
    private int display;
    private int board;

    public Sticker(int display, int board){
        this.display = display;
        this.board = board;
    }

    public int getDisplay(){
        return this.display;
    }
    public int getBoard(){
        return  this.board;
    }

}