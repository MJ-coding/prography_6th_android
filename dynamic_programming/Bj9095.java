package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bj9095 {
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            dp = new int[n+1];
            Arrays.fill(dp,-1);

            dp[1] = 1;
            System.out.println(recursive(n));
        }
    }

    private static int recursive(int current) {
        if(current == 0 ) return 1;
        if(current < 0) return 0;
        if(dp[current] != -1) return dp[current];

        return dp[current] = recursive(current-1) + recursive(current-2) + recursive(current-3);
    }

}
