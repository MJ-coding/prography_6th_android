package financial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Test02 {

    public static void main(String[] args) {

    }

    private static ArrayList<Information>[] path;
    private static int[] dp;

    public String[] solution(String[] cities, String[] roads, String[] cars,
        String[] customers) {
        String[] answer = new String[customers.length];

        HashMap<String, Integer> map = new HashMap<>();
        path = new ArrayList[cities.length];
        for (int i = 0; i < cities.length; i++) {
            map.put(cities[i], i);
            path[i] = new ArrayList<>();
        }
        for (int i = 0; i < roads.length; i++) {
            String input = roads[i];
            StringTokenizer st = new StringTokenizer(input);
            String fromCity = st.nextToken();
            String toCity = st.nextToken();
            int distance = Integer.parseInt(st.nextToken());

            path[map.get(fromCity)].add(new Information(map.get(toCity), distance));
            path[map.get(toCity)].add(new Information(map.get(fromCity),distance));

        }
        for (int i = 0; i < customers.length; i++) {
            String customerInfo = customers[i];
            StringTokenizer st = new StringTokenizer(customerInfo);
            String fromCity = st.nextToken();
            String toCity = st.nextToken();
            int weight = Integer.parseInt(st.nextToken());

            int prevCost = Integer.MAX_VALUE;
            ArrayList<String> list = new ArrayList<>();
            for(int j = 0 ; j < cars.length; j++){
                String carInfo = cars[j];
                StringTokenizer sst = new StringTokenizer(carInfo);
                String busStation = sst.nextToken();
                int busWeight = Integer.parseInt(sst.nextToken());
                int cost = Integer.parseInt(sst.nextToken());

                if (busWeight >= weight) {
                    int firstCost = dijkstra(cities,map.get(busStation), map.get(fromCity),cost);
                    int secondCost = dijkstra(cities,map.get(fromCity), map.get(toCity),cost);

                    if(firstCost == 0 || secondCost == 0){
                        continue;
                    }
                    int minCost = firstCost + secondCost;

                    if(minCost == prevCost){
                        list.add(busStation);
                    }
                    if(minCost < prevCost){
                        answer[i] = busStation;
                        prevCost = minCost;
                    }

                }
            }

            if(list.size() > 0){
                Collections.sort(list);
                answer[i] = list.get(0);
            }


        }

        return answer;
    }

    private static int dijkstra(String[] cities,int start, int end, int cost) {
        dp = new int[cities.length + 10];
        PriorityQueue<Information> q = new PriorityQueue<>(
            Comparator.comparingInt(Information::getDistance));
        q.offer(new Information(start, 0));

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[start] = 0;

        while (!q.isEmpty()) {
            Information current = q.poll();
            if (dp[current.getCity()] < current.getDistance())
                continue;

            for (Information next : path[current.getCity()]) {
                if (dp[next.getCity()] <= dp[current.getCity()] + next.getDistance())
                    continue;
                dp[next.getCity()] = dp[current.getCity()] + next.getDistance();

                q.offer(new Information(next.getCity(), dp[next.getCity()]));
            }
        }

        return dp[end] == Integer.MAX_VALUE ? 0 :  dp[end]*cost;
    }
}
class Information{
    private int city;
    private int distance;

    public Information(int city, int distance){
        this.city = city;
        this.distance = distance;
    }

    public int getCity() {
        return city;
    }

    public int getDistance() {
        return distance;
    }
}
