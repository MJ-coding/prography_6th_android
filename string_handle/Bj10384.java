package string_handle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj10384 {
    private static final String CASE = "Case ";
    private static final String COLON =": ";
    private static final String NEW_LINE = "\n";
    private static final String[] RESULTS = { "Not a pangram", "Pangram!", "Double pangram!!", "Triple pangram!!!" };

    private static int n;
    private static int answer;
    private static int[] alphaArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i =1 ; i<= n; i++){
            String input = br.readLine();
            findeAlphaNum(input);
            pangram();
            sb.append(CASE).append(i).append(COLON).append(RESULTS[answer > 3 ? 3 : answer]).append(NEW_LINE);
        }
        br.close();
        System.out.println(sb.toString());
    }

    private static void findeAlphaNum(String input) {
        int len = input.length();
        alphaArray = new int[26];
        input = input.toLowerCase();

        for(int i = 0; i< len ;i++){
            char alpha = input.charAt(i);
            if(!('a' <= alpha && alpha <= 'z')) continue;
            alphaArray[alpha%97]++;
        }
    }
    private static int pangram(){
        answer = Integer.MAX_VALUE;
        for(int cnt : alphaArray){
            answer = Math.min(answer,cnt);
        }
        return answer;
    }

}
