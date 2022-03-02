package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj18352 {
    private static int K;
    private static int INF = 1_000_000_000;
    private static ArrayList<Vertex>[] path;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken())-1;

        ArrayList<Integer> answer = new ArrayList<>();
        dp = new int[N];
        Arrays.fill(dp,INF);

        path = new ArrayList[N];
        for(int i = 0 ; i < N; i++){
            path[i] = new ArrayList<>();
        }


        while(M-- >0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;

            path[start].add(new Vertex(end,1));
        }

        answer = dijkstra(X);
        Collections.sort(answer);
        if(answer.size() != 0){
            for(int ans : answer){
                sb.append(ans).append("\n");
            }

            System.out.println(sb);
        }else{
            System.out.println(-1);
        }

    }

    private static ArrayList<Integer> dijkstra(int start) {
        Queue<Vertex> q = new ArrayDeque<>();
        ArrayList<Integer> answer = new ArrayList<>();
        q.offer(new Vertex(start,0));
        dp[start] = 0;

        while(!q.isEmpty()){
            Vertex current = q.poll();

            if(dp[current.getCity()] < current.getCost()) continue;

            for(Vertex next : path[current.getCity()]){
                int nextCost = current.getCost() + next.getCost();
                if(dp[next.getCity()] <= nextCost) continue;
                if(nextCost == K) answer.add(next.getCity()+1);

                dp[next.getCity()] = nextCost;
                q.offer(new Vertex(next.getCity(),nextCost));
            }
        }
        return answer;
    }
}
class Vertex{
    private int city;
    private int cost;

    public Vertex(int city, int cost) {
        this.city = city;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public int getCity(){
        return this.city;
    }
}
