package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj15649 {
    private static int N,M;
    private static boolean[] visited;
    private static int[] sequence;
    private static int[] num;
    private static StringBuilder sb;
    private static String SPACE = " ";
    private static String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        sequence = new int[M];
        sb = new StringBuilder();

        for(int i = 0 ; i < N; i++){
            num[i] = i+1;
        }
        for(int start = 0; start < N; start++){
            visited = new boolean[N];
            recursive(start,0);
        }
        System.out.println(sb);

    }

    private static void recursive(int current, int count) {
        visited[current] = true;
        sequence[count] = num[current];

        if(count == M-1){
            for(int answer : sequence){
                sb.append(answer).append(SPACE);
            }
            sb.append(NEW_LINE);
            return;
        }
        for(int next = 0; next < N; next++){
            if(visited[next]) continue;


            recursive(next,count+1);
            visited[next] = false;
        }

    }
}
