package dfs_bfs;
import java.util.*;

public class Pro43162 {

    private static int[] parent;

    public static void main(String[] args) {
        int ans = solution(3,new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
        System.out.println(ans);
    }
    static int solution(int n, int[][] computers) {
        int answer = 0;
        parent = new int[n];
        Arrays.fill(parent, -1);

        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == j )
                    continue;
                if(computers[i][j] == 1)
                    merge(i,j);
            }
        }

        for(int p : parent){
            if(p < 0)
                answer++;
        }
        return answer;
    }
    //연결되어있으면 merge
    private static int find(int x){
        if(parent[x] < 0)
            return x;
        return parent[x] = find(parent[x]);
    }

    private static void merge(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y)
            return;
        if(parent[x] < parent[y]){
            parent[x] += parent[y];
            parent[y] = x;
        }else{
            parent[y] += parent[x];
            parent[x] = y;
        }
    }


}
