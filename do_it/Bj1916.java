package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Bj1916 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[N+1];
        int[] pay = new int[N+1];
        Arrays.fill(visited,false);
        Arrays.fill(pay,Integer.MAX_VALUE);

        ArrayList<Bus>[] path = new ArrayList[N+1];
        for(int i = 0 ; i < N+1; i++){
            path[i] = new ArrayList<>();
        }
        while(M-- >0){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            path[u].add(new Bus(v,w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        System.out.println(dijkstra(start,end,path,pay,visited));

    }

    private static int dijkstra(int start, int end, ArrayList<Bus>[] path, int[] pay, boolean[] visited) {
        PriorityQueue<Bus> pq = new PriorityQueue<>(Comparator.comparingInt(Bus::getCost));
        pq.offer(new Bus(start,0));
        pay[start] = 0;

        while(!pq.isEmpty()){
            Bus current = pq.poll();
            int currentBus = current.getBus();
            int currentCost = current.getCost();
            visited[currentBus] = true;

            if(pay[currentBus] < currentCost)
                continue;

            for(Bus next : path[currentBus]){
                int nextBus = next.getBus();
                int nextCost = next.getCost();

                if(!visited[nextBus] && pay[nextBus] > pay[currentBus] + nextCost){
                    pay[nextBus] = pay[currentBus] + nextCost;
                }
                if(nextBus == end)
                    return pay[end];
                pq.offer(new Bus(nextBus,pay[nextBus]));
            }
        }
        return pay[end];
    }


}
class Bus{
    private int bus;
    private int cost;

    public int getBus() {
        return bus;
    }

    public int getCost() {
        return cost;
    }

    public Bus(int bus, int cost) {
        this.bus = bus;
        this.cost = cost;
    }
}
