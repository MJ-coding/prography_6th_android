package stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            String[] input = br.readLine().split(" ");
            for(int i=0; i<input.length; i++){
                //StringBuffer(동기화처리로 느림)StringBuilder가 빠름
                StringBuilder sb = new StringBuilder(input[i]);
                System.out.print(sb.reverse()+" ");
            }
            System.out.println();
        }


    }
}
