package dfs_bfs;
import java.util.*;

public class Pro86971 {

    static ArrayList<Integer>[] graph;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        solution(9,new int[][] {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}});
        System.out.println(min);
    }

    static int solution(int n, int[][] wires) {
        graph = new ArrayList[n+1];

        for(int i = 0 ; i < n+1 ; i++){
            graph[i] = new ArrayList<>();
        }

        //1.양방향 그래프정보를 정보를 넣는다.
        for(int i = 0 ; i < wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];

            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        //2.그래프 간선 하나씩 끊어보며 dfs로 탐색하여 min값 도출
        for(int i = 0 ; i < wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];

            //노드방문여부
            boolean[] visited = new boolean[n+1];

            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));
            //3. 단선 후 하나의 그래프 간선 수
            int cnt = dfs(1,visited);

            int diff = Math.abs(cnt - (n-cnt));
            min = Math.min(min, diff);

            //그래프에 다시 간선 추가하기
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        return min;
    }
    static int dfs(int node, boolean[] visited)
    {
        int cnt = 1;//노드의 개수 카운트
        visited[node] = true;

        for(int next : graph[node])
        {
            if(!visited[next])
                cnt += dfs(next, visited);
        }

        return cnt;
    }


}
