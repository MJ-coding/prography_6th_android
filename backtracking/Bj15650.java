package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj15650 {
    private static int N,M;
    private static int[] data;
    private static int[] sequence;
    private static boolean[] visited;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[N];
        sequence = new int[M];
        sb = new StringBuilder();

        for(int i = 0 ; i < N ;i++){
            data[i] = i+1;
        }

        for(int start = 0 ; start <= N-M; start++){
            visited = new boolean[N];
            recursion(start,0);
        }

        System.out.println(sb);
    }

    private static void recursion(int current, int count) {
        visited[current] = true;
        sequence[count] = data[current];

        if(count == M-1){
            for(int value : sequence){
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return ;
        }

        for(int next = current+1; next < N; next++){
            if(visited[next]) continue;

            recursion(next,count+1);
            visited[next] = false;
        }

    }

}
