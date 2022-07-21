package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input,"-");
        int answer = 0;
        StringTokenizer nextSt = new StringTokenizer(st.nextToken(),"+");
        while(nextSt.hasMoreTokens())
            answer += Integer.parseInt(nextSt.nextToken());

        while(st.hasMoreTokens()){
            nextSt = new StringTokenizer(st.nextToken(),"+");
            int sum = 0 ;
            while(nextSt.hasMoreTokens())
                sum += Integer.parseInt(nextSt.nextToken());
            answer -= sum;
        }

        System.out.println(answer);

    }

}
