package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj1916 {
    private static ArrayList<Information>[] path;
    private static long[] cost;

    private static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        path = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            path[i] = new ArrayList<>();
        }

        cost = new long[N];

        while(M-- >0){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());

            path[start].add(new Information(end,cost));

        }

//        for(int i = 0 ; i< N;i++){
//            Collections.sort(path[i], Comparator.comparingInt(Information::getCost));
//        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken())-1;
        int end = Integer.parseInt(st.nextToken())-1;

        System.out.println(dijkstra(start,end));

    }

    private static long dijkstra(int start, int end) {
        PriorityQueue<Information> q = new PriorityQueue<>(Comparator.comparingLong(Information::getCost));
        q.offer(new Information(start, 0));

        Arrays.fill(cost, INF);
        cost[start] = 0;

        while(!q.isEmpty()) {
            Information current = q.poll();
            if(cost[current.getCity()] < current.getCost()) continue;

            for(Information next: path[current.getCity()]) {
                if(cost[next.getCity()] <= cost[current.getCity()] + next.getCost()) continue;
                cost[next.getCity()] = cost[current.getCity()] + next.getCost();

                q.offer(new Information(next.getCity(), cost[next.getCity()]));
            }
        }

        return cost[end];
    }

}
class Information{
    private int city;
    private long cost;

    public int getCity() {
        return city;
    }

    public long getCost() {
        return cost;
    }

    public Information(int city, long cost) {
        this.city = city;
        this.cost = cost;
    }
}
