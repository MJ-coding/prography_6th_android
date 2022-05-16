package test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Test011 {

    public static void main(String[] args) {
        int[] answer = new int[2];
        answer = solution(9,new int[][]{{0,2},{2,1},{2,4},{3,5},{5,4},{5,7},{7,6},{6,8}});
        System.out.println(answer[0] + answer[1]);
    }
    private static ArrayList<Integer> splitedSize;
    public static int[] solution(int n, int[][] edges) {
        int[] answer = new int[2];
        int[][] connected = new int[n][n];

        for(int i = 0 ; i < edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];

            connected[a][b] = 1;
            connected[b][a] = 1;
        }

        for(int i = 0 ; i< edges.length -1; i++){
            for(int j = i+1; j< edges.length; j++){
                //first edge
                int a = edges[i][0];
                int b = edges[i][1];
                //second edge
                int c = edges[j][0];
                int d = edges[j][1];

                connected[a][b] = 0;
                connected[b][a] = 0;

                connected[c][d] = 0;
                connected[d][c] = 0;

                splitedSize = bfs(connected,n);
                if(checkSize(splitedSize)){
                    answer[0] = i<j ? i : j;
                    answer[1] = i>j ? i : j;
                }

                connected[a][b] = 1;
                connected[b][a] = 1;
                connected[c][d] = 1;
                connected[d][c] = 1;
            }
        }

        return answer;
    }

    private static boolean checkSize(ArrayList<Integer> splitedSize) {
        if(splitedSize.size() == 3 &&
            (splitedSize.get(0) == splitedSize.get(1)) && (splitedSize.get(1) == splitedSize.get(2)))
            return true;
        return false;
    }

    private static ArrayList<Integer> bfs(int[][] connected, int n) {
        splitedSize = new ArrayList<>();
        int[] visited = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        int size  = 0;

        for(int start = 0 ; start < n; start++){
            if(visited[start] == 0){
                q.offer(start);
                visited[start] = 1;
                size = 1;
                while(q.size() > 0){
                    int current = q.poll();
                    for( int j = 0 ; j < n; j++){
                        if(connected[current][j] == 1 && visited[j] == 0){
                            size++;
                            q.offer(j);
                            visited[j] = 1;
                        }
                    }
                }
                splitedSize.add(size);
            }
        }

        return splitedSize;

    }

}
