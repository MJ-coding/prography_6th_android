package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj2512 {
    private static int[] budgets;
    private static int M;
    private static long sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        budgets = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;  i< N; i++){
            budgets[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(budgets);
        
        M = Integer.parseInt(br.readLine());
        System.out.println(binarySearchMaxBudget(1,budgets[N-1]));
    }

    private static int binarySearchMaxBudget(int start, int end) {
        int mid = 0;
        int answer = 0;

        while(start <= end){
            mid = (start+end)/2;
            
            if(calcTotal(mid) <= M){
                start = mid + 1;
                answer = mid;
            }else{
                end = mid - 1;
            }
        }
        return answer;
    }

    private static long calcTotal(int target) {
        sum = 0 ;
        for(int budget : budgets){
            if(budget > target){
                sum += target;
            }else{
                sum += budget;
            }
        }
        return sum;
    }
}
