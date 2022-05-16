package test;

import java.util.ArrayDeque;
import java.util.Queue;

public class Kakao002 {

    private static int[] DIRECTIONS = {0,1};

    public int solution(int[] queue1, int[] queue2) {
        int answer = Integer.MAX_VALUE;
        long sum = 0;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        for(int value : queue1){
            q1.offer(value);
            sum += value;
        }
        for(int value : queue2){
            q2.offer(value);
            sum += value;
        }
        sum /= 2;
        
        answer = Math.min(answer,bfs(q1,q2,sum));
        for(int value : queue1){
            q1.offer(value);
        }
        for(int value : queue2){
            q2.offer(value);
        }
        answer = Math.min(answer,bfs(q2,q1,sum));


        return answer;
    }

    private int bfs(Queue<Integer> q1,Queue<Integer> q2, long sum) {
        int target = 0;
        target++;

        while(!q1.isEmpty()){
            int current = q1.poll();

            for(int dir : DIRECTIONS){
                if(cal(q1) == sum){
                    return target;
                }

                if(dir == 0){
                    q2.offer(current);
                    q2.offer(q1.poll());
                    target++;
                }else{
                    q1.offer(q2.poll());
                    target++;
                }
            }
        }
        return target;
    }

    private long cal(Queue<Integer> q) {
        long ans = 0;

        while(!q.isEmpty()){
            ans += q.poll();
        }

        return ans;
    }

}
