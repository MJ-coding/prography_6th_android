package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Bj1744 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        boolean isZero = false;

        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        for(int i = 0 ; i < N ;i++){
            int num = Integer.parseInt(br.readLine());
            if(num > 0){
                plusPq.offer(num);
            }else if(num < 0){
                minusPq.offer(num);
            }else{
                isZero = true;
            }

        }

        while(!plusPq.isEmpty()){
            if(plusPq.size() == 1){
                ans += plusPq.poll();
                break;
            }
            int first = plusPq.poll();
            int second = plusPq.poll();

            ans += first+ second > first*second ? first + second : first*second ;
        }

        while(!minusPq.isEmpty()){
            if(minusPq.size() == 1 && isZero){
                ans += minusPq.poll()*0;
                break;
            }
            if(minusPq.size() == 1) {
                ans += minusPq.poll();
                break;
            }
            int first = minusPq.poll();
            int second = minusPq.poll();

            ans += first*second ;
        }


        System.out.println(ans);

    }

}
