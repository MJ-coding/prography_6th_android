package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj15652 {
    private static StringBuilder sb;
    private static int[] sequence;
    private static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        sequence = new int[M];

        for(int i = 1 ; i <= N ; i++){
            permutation(i,0);
        }

        System.out.println(sb);
    }

    private static void permutation(int start, int index) {
        sequence[index] = start;

        if(index == M-1){
            for(int ans : sequence){
                sb.append(ans).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int next = start ; next <= N ; next++){
            permutation(next, index + 1);
        }
    }

}
