package DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj17128 {
    private static final String NEW_LINE = "\n";
    private static int N;
    private static int sum;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] cows = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i< N ;i++){
            cows[i] = Integer.parseInt(st.nextToken());
        }
        calculation(cows);
        //부호결정
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        while(Q-- > 0){
            int minusIndex = Integer.parseInt(st.nextToken()) - 1;
            getMinus(minusIndex);
            sb.append(sum).append(NEW_LINE);
        }
        System.out.println(sb);
    }

    private static void getMinus(int minusIndex) {
        for(int i = 0; i< 4; i++){
            sum -= dp[check(minusIndex-i)]*2;
            dp[check(minusIndex-i)] *= -1;
        }
    }

    private static void calculation(int[] cows){
        //dp계산
        dp = new int[N];
        Arrays.fill(dp,1);

        int index = 0;
        //S0
        for(int i = 0 ; i< 4; i++){
            dp[0] *= cows[index++];
        }

        for(int i = 1; i< N; i++){
            dp[i] = dp[i-1]/cows[check(index-4)]*cows[check(index++)];
        }
        for(int num :dp){
            sum += num;
        }

    }

    private static int check(int index) {
        if(index >= N){
            return index%N;
        }else if(index < 0){
            return N + index;
        }
        return index;
    }
}
