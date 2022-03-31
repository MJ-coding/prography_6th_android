package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj14630 {
    private static String[] robot;
    private static ArrayList<MoneyInfo>[] path;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        robot = new String[N];
        path = new ArrayList[N];

        for(int i = 0 ; i<N; i++){
            robot[i] = br.readLine();
            path[i] = new ArrayList<>();
        }

        for(int i = 0; i< N; i++){
            for(int j = i+1 ; j<N; j++){
                int money = calcMoney(i,j);
                path[i].add(new MoneyInfo(j,money));
                path[j].add(new MoneyInfo(i,money));
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken())-1;
        int end = Integer.parseInt(st.nextToken())-1;

        System.out.println(dijkstra(start,end));


    }

    private static int dijkstra(int startNode, int endNode) {
        PriorityQueue<MoneyInfo> pq = new PriorityQueue<>(Comparator.comparingInt(MoneyInfo::getCost));
        int[] dp = new int[N];
        Arrays.fill(dp,1_000_000_000);

        MoneyInfo start = new MoneyInfo(startNode,0);
        dp[startNode] = 0;
        pq.offer(start);

        while(!pq.isEmpty()){
            MoneyInfo current = pq.poll();

            if(dp[current.getNode()] < current.getCost()) continue;

            for(MoneyInfo next : path[current.getNode()]){
                int nextCost = current.getCost() + next.getCost();

                if(dp[next.getNode()] <= nextCost) continue;

                dp[next.getNode()] = nextCost;
                pq.offer(new MoneyInfo(next.getNode(),nextCost));
            }
        }


        return dp[endNode];
    }

    private static int calcMoney(int start, int end) {
        int sum = 0;
        String from = robot[start];
        String to = robot[end];

        for(int i = 0 ; i < from.length(); i++){
            int diff = (from.charAt(i) - '0') - (to.charAt(i) - '0');
            sum += diff*diff;
        }
        return sum;
    }
}
class MoneyInfo{
    private int node;
    private int cost;

    public int getNode() {
        return node;
    }

    public int getCost() {
        return cost;
    }

    public MoneyInfo(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}
