package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bj2193 {
    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new long[2][N+1];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);

        System.out.println(findPinaryNumber(0,N) + findPinaryNumber(1,N));
    }

    private static long findPinaryNumber(int last, int n) {
        if (n == 1 && last == 0) return 0;
        if (n == 1 && last == 1) return 1;

        if(dp[last][n] != -1) return dp[last][n];

        if(last == 0){
            return dp[0][n] = findPinaryNumber(0,n-1) + findPinaryNumber(1,n-1);

        }else{
            return dp[1][n] = findPinaryNumber(0,n-1);
        }

    }

}
