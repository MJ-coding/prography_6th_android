package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj12101 {
    private static int[] dp;
    private static List<String> result = new ArrayList<>();

    private static final char PLUS = '+';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new int[n+1];
        int[] arr = new int[n];

        Arrays.fill(dp,-1);
        Arrays.fill(arr, - 1);

        recursion(n, arr, 0);

        Collections.sort(result);
        String answer = "";
        for(int i = 0; i < k; i++) {
            answer = result.get(i);
        }

        System.out.println(answer);
    }
    private static int recursion(int current, int[] arr, int index){
        if(current == 0){
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == -1) continue;
                sb.append(arr[i]).append(PLUS);
            }

            result.add(sb.substring(0, sb.length() - 1));
            return 1;
        }

        if(current < 0) return 0;
        if(dp[current] != -1) return dp[current];

        int answer = 0;
        for(int i = 1; i < 4; i++){
            arr[index] = i;
            answer += recursion(current - i, arr, index + 1);
            arr[index] = -1;
        }

        dp[current] = answer;
        return dp[current];
    }

}
