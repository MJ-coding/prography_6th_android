package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] sum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i < N+1; i++)
        {
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }

        while(M-- >0)
        {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(sum[j] - sum[i-1]);
        }

    }

}
