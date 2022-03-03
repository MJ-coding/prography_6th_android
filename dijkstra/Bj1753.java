package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj1753 {
    private static ArrayList<Vertex1753>[] path;
    private static final String NO_PATH = "INF";
    private static final int INF = 1_000_000_000;
    private static final String NEW_LINE = "\n";
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        path = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            path[i] = new ArrayList<>();
        }

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            path[from].add(new Vertex1753(to, cost));
        }

        dijkstra(K-1, V);
        System.out.println(sb);

    }

    private static void dijkstra(int start, int V) {
        PriorityQueue<Vertex1753> pq = new PriorityQueue<>(Comparator.comparingInt(Vertex1753::getCost));
        sb = new StringBuilder();
        int[] dp = new int[V];
        Arrays.fill(dp, INF);

        pq.offer(new Vertex1753(start, 0));
        dp[start] = 0;


        while (!pq.isEmpty()) {
            Vertex1753 current = pq.poll();
            if(dp[current.getNode()] < current.getCost()) continue;

            for (Vertex1753 next : path[current.getNode()]) {
                int nextCost = current.getCost() + next.getCost();
                if (dp[next.getNode()] <= nextCost) continue;

                dp[next.getNode()] = nextCost;
                pq.offer(new Vertex1753(next.getNode(),nextCost));
            }
        }


        for (int cost : dp) {
            if (cost == INF) {
                sb.append(NO_PATH).append(NEW_LINE);
            } else {
                sb.append(cost).append(NEW_LINE);
            }
        }
    }
}

class Vertex1753 {
    private int node;
    private int cost;

    public Vertex1753(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    public int getNode() {
        return this.node;
    }

    public int getCost() {
        return this.cost;
    }
}
