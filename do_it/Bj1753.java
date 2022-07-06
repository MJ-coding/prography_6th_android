package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj1753 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        int[] distance = new int[V+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        boolean[] visited = new boolean[V+1];
        Arrays.fill(visited,false);

        ArrayList<Path>[] path = new ArrayList[V+1];
        for(int i = 0; i < V+1; i++){
            path[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            path[u].add(new Path(v,w));
        }

        PriorityQueue<Path> pq = new PriorityQueue<>(Comparator.comparingInt(Path::getCost));
        pq.offer(new Path(start,0));
        distance[start] = 0;
        visited[start] = true;

        while(!pq.isEmpty()){
            Path current = pq.poll();

            if(distance[current.getNode()] < current.getCost())
                continue;

            for(Path next : path[current.getNode()]){
                int nextNode = next.getNode();
                int nextCost = next.getCost();

                if(distance[nextNode] > distance[current.getNode()]+nextCost){
                    distance[nextNode] = distance[current.getNode()]+nextCost;
                    visited[nextNode] = true;
                    pq.offer(new Path(nextNode,distance[nextNode]));
                }
            }
        }

        for(int i = 1 ; i <= V ; i++){
            if(visited[i]){
                System.out.println(distance[i]);
            }else{
                System.out.println("INF");
            }
        }


    }

}
class Path{
    private int node;
    private int cost;

    public Path(int node, int cost){
        this.node = node;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public int getNode() {
        return node;
    }
}
