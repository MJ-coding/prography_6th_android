package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj15652 {
    private static int N,M;
    private static StringBuilder sb;
    private static int[] data;
    private static int[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sequence = new int[M];
        data = new int[N];

        for(int i = 0 ; i < N; i++){
            data[i] = i+1;
        }

        for(int start = 0 ; start < N; start++){
            recursion(start,0);
        }

        System.out.println(sb);
    }

    private static void recursion(int current, int count) {
        sequence[count] = data[current];

        if(count == M-1){
            for(int value : sequence){
                sb.append(value).append(" ");
            }
            sb.append("\n");

            return;
        }
        for(int next = current; next < N; next++){
            recursion(next,count+1);
        }
    }
}
