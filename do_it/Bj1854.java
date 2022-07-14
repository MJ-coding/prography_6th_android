package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Bj1854 {

    public static void main(String[] args) throws IOException {
        //n, m, k
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] time = new int[n+1];
        Arrays.fill(time, Integer.MAX_VALUE);
        PriorityQueue<City>[] path = new PriorityQueue[n+1];
        for(int i = 0 ; i < n+1 ; i++){
            path[i] = new PriorityQueue<>(Comparator.comparingInt(City::getAscendingCost));
        }

        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(path[a].peek().getCost() > c ){
                path[a].poll();
                path[a].offer(new City(b,c));
            }

        }

        PriorityQueue<City> pq = new PriorityQueue<>(Comparator.comparingInt(City::getCost));
        pq.offer(new City(1,0));
        time[1] = 0;

        while(!pq.isEmpty()){
            City current = pq.poll();
            int currentCity = current.getCity();
            int currentCost = current.getCost();
            if(time[currentCity] < currentCost)
                continue;

            for(City next : path[currentCity]){
                int nextCity = next.getCity();
                int nextCost = next.getCost();

                if(time[nextCity] > time[currentCity] + nextCost){
                    time[nextCity] = time[currentCity] + nextCost;
                }

                if(pq.size() > k)
                {
                    City top = pq.poll();
                    if(top.getCost() > time[nextCity]){
                        pq.offer(new City(nextCity,time[nextCity]));
                    }else{
                        pq.offer(top);
                    }

                }else
                {
                    pq.offer(new City(nextCity,time[nextCity]));
                }
            }
        }

        for(int i = 1; i <= n ; i++){
            if(time[i] == Integer.MAX_VALUE){
                System.out.println(-1);
            }else{
                System.out.println(time[i]);
            }

        }
    }

}
class City{
    private int city;
    private int cost;

    public int getCity() {
        return city;
    }

    public int getCost() {
        return cost;
    }

    public int getAscendingCost(){
        return -cost;
    }

    public City(int city, int cost) {
        this.city = city;
        this.cost = cost;
    }
}
