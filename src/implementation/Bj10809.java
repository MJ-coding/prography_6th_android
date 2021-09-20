package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bj10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] alpha = new int[26];
        Arrays.fill(alpha,-1);
        int n = input.length();
        for(int i = 0 ; i< n ;i++){
            if( alpha[input.charAt(i)%97] == -1){
                alpha[input.charAt(i)%97] = i;
            }
        }
        for(int i = 0; i<26; i++){
            System.out.print(alpha[i]+" ");
        }
    }
}
