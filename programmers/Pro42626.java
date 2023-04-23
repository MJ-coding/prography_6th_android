package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Pro42626 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        int size = scoville.length;
        int min = 0;
        int nextMin = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0 ; i < size ;i++){
            pq.add(scoville[i]);
        }

        while(true){
            if(pq.size() < 2)
                break;
            min = pq.poll();
            if(min >= K)
                break;
            nextMin = pq.poll();

            pq.add(mixScovile(min, nextMin));
            answer++;
        }

        return pq.poll() < K ? -1 : answer;
    }
    public static int mixScovile(int min , int nextMin){
        return min + nextMin*2;
    }


}
