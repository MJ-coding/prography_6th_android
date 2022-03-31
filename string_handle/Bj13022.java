package string_handle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj13022 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        System.out.println(isCorrectWord(word));
    }

    private static int isCorrectWord(String word) {
        int len = word.length();
        char[] wolf = {'w', 'o', 'l','f'};
        int next = 0;

        while(next < len){
            int[] count = new int[4];
            int index = 0;

            for(char alpha : wolf){
                for( ; next < len; next++){
                    if(word.charAt(next) != alpha) break;
                    count[index]++;
                }
                index++;
            }

            for(int i = 1 ; i<4; i++){
                if(count[i] != count[i-1]) return 0;
            }
        }

        return 1;
    }

}
