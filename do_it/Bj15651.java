package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj15651 {

    private static int[] num;
    private static int[] sequence;
    private static StringBuilder sb;
    private static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N+1];
        sequence = new int[M];

        for(int i = 1 ; i <= N ; i++){
            num[i] = i;
        }

        for(int i = 1 ; i <= N ; i++){
            reculsive(i , 0);
        }
        System.out.println(sb);
    }

    private static void reculsive(int start, int index) {
        sequence[index] = num[start];

        if(index == M-1){
            for(int answer : sequence){
                sb.append(answer).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int next = 1; next <= N ; next++){
            reculsive(next,index + 1);
        }
    }

}
