package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj23972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //Integer 21억
        long k = Integer.parseInt(st.nextToken());
        long N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append(findCost(k,N));
        System.out.println(sb);

    }

    private static long findCost(long k, long n) {
        if(n == 1) return -1;
        long quotient = k*n/(n-1);
        long remain = k*n%(n-1);

        if(remain >0 ){
            return quotient+1;
        }else{
            return quotient;
        }
    }
}
