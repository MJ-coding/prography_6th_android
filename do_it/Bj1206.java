package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj1206 {

    static ArrayList<Integer>[] edge;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        edge = new ArrayList[N+1];
        for(int i = 0 ; i < N+1; i++){
            edge[i] = new ArrayList<>();
        }
        while(M-- >0){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edge[from].add(to);
            edge[to].add(from);
        }
        for(int i = 1 ; i < N+1; i++){
            Collections.sort(edge[i]);
        }

        visited = new boolean[N+1];
        DFS(start);
        System.out.println();
        visited = new boolean[N+1];
        BFS(start);


    }

    private static void BFS(int vertex) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(vertex);
        visited[vertex] = true;

        while(!q.isEmpty()){
            int current = q.poll();
            System.out.print(current + " ");

            for(int v : edge[current]){
                if(!visited[v]){
                    q.offer(v);
                    visited[v]= true;
                }
            }
        }
    }

    private static void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for(int v : edge[vertex]){
            if(!visited[v])
                DFS(v);
        }
    }

}
