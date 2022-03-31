package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj2696 {
    private static int M;
    private static int[] sequence;
    private static ArrayList<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-- >0){
            M = Integer.parseInt(br.readLine());
            sequence = new int[M];
            int quotient = M/10;
            int res = M%10;
            int index = 0;
            int times = 0;

            while(quotient-- >0){
                StringTokenizer st = new StringTokenizer(br.readLine());
                times++;
                for( ; index < 10*times ; index++){
                    sequence[index] = Integer.parseInt(st.nextToken());
                }
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            for( ; index < 10*times + res ; index++){
                    sequence[index] = Integer.parseInt(st.nextToken());
            }

            findMedian();

            sb.append(answer.size()).append("\n");
            int cnt = 0;
            for(int median : answer){
                cnt++;
                if(cnt%10 == 0){
                    sb.append(median).append("\n");
                }else{
                    sb.append(median).append(" ");
                }

            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    private static void findMedian() {
        answer = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int maxSize = 0;
        int minSize = 0;

        for(int i = 0; i<M; i++){
            if(i%2 == 0){
                maxHeap.offer(sequence[i]);
            }else{
                minHeap.offer(sequence[i]);
            }
            maxSize = maxHeap.size();
            minSize = minHeap.size();

            if(minSize == 0){
                answer.add(maxHeap.peek());
                continue;
            }

            if(maxHeap.peek() > minHeap.peek()){
                int minPeek = minHeap.poll();
                int maxPeek = maxHeap.poll();

                maxHeap.offer(minPeek);
                minHeap.offer(maxPeek);
            }

            if(maxSize > minSize){
                answer.add(maxHeap.peek());
            }


        }

    }
}
