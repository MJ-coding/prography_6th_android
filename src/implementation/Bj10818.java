package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i =0 ;i<N; i++){
            min = Integer.parseInt(input[i]) < min? Integer.parseInt(input[i]): min;
            max = Integer.parseInt(input[i]) > max? Integer.parseInt(input[i]): max;
        }
        System.out.println(min+" "+ max);

    }
}
