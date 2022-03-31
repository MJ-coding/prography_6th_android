package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj17951 {
    private static int[] score;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        score = new int[N];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            score[i] = Integer.parseInt(st.nextToken());
            sum += score[i];
        }

        System.out.println(binarySearchScore(0,sum));

    }

    private static int binarySearchScore(int front, int rear) {
        int answer = 0;

        while(front <= rear){
            int count = 0;//그룹 수
            int mid = (front+rear)/2;
            int sum = 0;

            for(int s : score){
                sum += s;
                if(sum >= mid) {//mid == 최대가되는 최소 점수
                    count++;
                    sum = 0;
                }
            }

            if(count >= K) {
                front = mid + 1;
                answer = mid;
            }
            else {
                rear = mid - 1;
            }
        }

        return answer;
    }
}
