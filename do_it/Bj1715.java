package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Bj1715 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0 ; i < N ; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        while(pq.size() != 1){
            int first = pq.poll();
            int second = pq.poll();
            ans += first+second;
            pq.offer(first+second);
        }

        System.out.println(ans);


    }

}
