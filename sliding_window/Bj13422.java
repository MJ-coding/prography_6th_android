package sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj13422 {
    private static int N;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            int[] money = new int[N];
            int sum = 0;
            int answer = 0;

            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N; i++){
                money[i] = Integer.parseInt(st.nextToken());
            }

            for(int j = 0 ; j < M ; j++){
                sum += money[j];
            }
            if(sum < K) answer++;

            answer += slidingWindow(money,M,sum);
            sb.append(answer).append("\n");


        }

        System.out.println(sb);

    }

    private static int slidingWindow(int[] money, int M, int sum){
        int answer = 0;
        int prev = 0;

        if(M == N){
            return answer;
        }
        for(int i = M ; i < N+M -1; i++ ) {
            sum += money[i%N];
            sum -= money[prev%N];
            prev++;

            if(sum < K) answer++;
        }

        return answer;
    }
}
