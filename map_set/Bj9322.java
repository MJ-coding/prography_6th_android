package map_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj9322 {
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";
    private static int n;
    private static String[] firstPublicKey;
    private static Map<String,Integer> secondPublicKey;
    private static String[] encryptKey;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            n = Integer.parseInt(br.readLine());
            String[] answer = new String[n];

            inputFirstKey(br.readLine());
            inputSecondKey(br.readLine());
            inputEncryption(br.readLine());

            Map<Integer,Integer> decryption = new HashMap<>();

            for(int i = 0; i < n; i++){
                decryption.put(secondPublicKey.get(firstPublicKey[i]),i);
            }
            for(int i = 0; i < n; i++){
                answer[decryption.get(i)] = encryptKey[i];
            }

            for(String ans : answer){
                sb.append(ans).append(SPACE);
            }
            sb.append(NEW_LINE);

        }

        System.out.println(sb);
    }

    private static void inputEncryption(String input) {
        StringTokenizer st = new StringTokenizer(input);
        encryptKey = new String[n];
        for(int i = 0; i< n; i++){
            encryptKey[i] = st.nextToken();
        }
    }

    private static void inputSecondKey(String input) {
        secondPublicKey = new HashMap<>();
        StringTokenizer st = new StringTokenizer(input);
        for(int i = 0 ; i < n ; i++){
            secondPublicKey.put(st.nextToken(),i);
        }
    }

    private static void inputFirstKey(String input) {
        StringTokenizer st = new StringTokenizer(input);
        firstPublicKey = new String[n];
        for(int i = 0 ; i < n ; i++){
            firstPublicKey[i] = st.nextToken();
        }
    }

}
