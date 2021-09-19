package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        float sum = 0;
        //String[] str = reader.readLine().split(" ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        float max = Integer.MIN_VALUE;
        for(int i = 0; i< N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = arr[i]>max ? arr[i] : max ;
        }
        for(int i = 0; i< N ; i++){
            sum += arr[i]/max*100;
        }
        System.out.print(sum/N);
    }
}
