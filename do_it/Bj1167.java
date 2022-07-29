package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj1167 {

    private static boolean[] visited;
    private static int[] distance;
    private static ArrayList<Tree>[] path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        StringTokenizer st;
        visited = new boolean[V+1];
        distance = new int[V+1];
        path = new ArrayList[V+1];
        for(int i = 0 ; i < V+1 ; i++){
            path[i] = new ArrayList<>();
        }


        for(int i = 1 ; i <= V ; i++){
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());

            while(st.hasMoreTokens()){
                int node = Integer.parseInt(st.nextToken());
                if(node == -1)
                    break;
                int cost = Integer.parseInt(st.nextToken());
                path[index].add(new Tree(node,cost));
            }
        }
        bfs(1);
        int max = 0;
        int start = 0 ;
        for(int i = 1 ; i < V+1 ; i++){
            if( distance[i] > max){
                max = distance[i];
                start = i;
            }
        }
        visited = new boolean[V+1];
        distance = new int[V+1];
        bfs(start);
        Arrays.sort(distance);
        System.out.println(distance[V]);

    }
    private static void bfs(int start){
        visited[start] = true;
        Queue<Tree> q = new ArrayDeque<>();
        q.offer(new Tree(start,0));

        while(!q.isEmpty()){
            Tree current = q.poll();

            for(Tree next : path[current.getNode()]){
                if(!visited[next.getNode()]){
                    distance[next.getNode()] = distance[current.getNode()] + next.getCost();
                    visited[next.getNode()] = true;
                    q.offer(next);
                }
            }
        }

    }

}
class Tree{
    int node;
    int cost;

    public Tree(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    public int getNode() {
        return node;
    }

    public int getCost() {
        return cost;
    }
}
