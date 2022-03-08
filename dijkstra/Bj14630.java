package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj14630 {
    private static String[] robot;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        robot = new String[N];
        for(int i = 0 ; i<N; i++){
            robot[i] = br.readLine();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken())-1;
        int end = Integer.parseInt(st.nextToken())-1;

        System.out.println(findMoney(start,end));

        // bfs/dfs(backtracking), 문자열, 구현(Map), sliding window, two pointer, dijkstra, simulation
        // binary search, dp, greedy, disjoint set

    }

    private static int findMoney(int startIndex, int endIndex) {
        int[] dp = new int[N];
        Arrays.fill(dp,1_000_000_000);

        for(int i = 0 ; i<N; i++){
            int current = 0;
            String start = robot[startIndex];
            String next = robot[i];
            int sum = 0;

            for( int j = 0 ; j< next.length(); j++){
                int dif = (start.charAt(j) - '0') - (next.charAt(j) - '0');
                sum += dif*dif;
            }
              
            if(dp[i] < sum) {
                continue;
            } else{
                dp[i] = sum;
            }
        }
    }
}
