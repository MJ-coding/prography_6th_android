package string_handle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1213 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int len = input.length();
        int[] alpha = new int[26];
        int oddNum = 0;
        int oddIndex = 0;

        for(int i = 0 ; i < len ; i++){
            alpha[input.charAt(i)%65] += 1;
        }

        for(int i = 0 ; i < 26; i++){
            if(alpha[i]%2 == 1){
                oddNum++;
                oddIndex = i;
            }
            if(oddNum >= 2) break;
        }

        if(oddNum >= 2){
            System.out.println("I'm Sorry Hansoo");
        }else{
            printing(alpha,oddNum,oddIndex);
        }
    }

    private static void printing(int[] alpha, int oddNum, int oddIndex) {
        StringBuilder sb = new StringBuilder();
        char alphabet = 'A';

        for(int num : alpha){
            for(int i = 0 ; i<num/2; i++){
                sb.append(alphabet);
            }
            alphabet++;
        }
        if(oddNum == 1){
            char mid = (char)('A'+oddIndex);
            sb.append(mid);
        }
        alphabet = 'Z';
        for(int i = 25; i >= 0 ; i--){
            for(int j = 0 ; j < alpha[i]/2; j++){
                sb.append(alphabet);
            }
            alphabet--;
        }

        System.out.println(sb);
    }

}
