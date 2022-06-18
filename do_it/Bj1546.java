package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1546 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];
        float max = Integer.MIN_VALUE;
        float sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i  < N ; i++)
        {
            scores[i] = Integer.parseInt(st.nextToken());
            max = scores[i] > max ? scores[i] : max;
        }

        for(int score : scores)
        {
            sum += score/max*100;
        }

        System.out.println(sum/N);

    }

}
