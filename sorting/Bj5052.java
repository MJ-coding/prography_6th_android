package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bj5052 {
    private static String[] phoneNumber;
    private static int n;
    private static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            n = Integer.parseInt(br.readLine());
            phoneNumber = new String[n];
            for(int i = 0; i< n; i++){
                phoneNumber[i] = br.readLine();
            }
            Arrays.sort(phoneNumber);
            answer = " ";

            for(int i = 0; i < n-1 ; i++){
                int cnt = 0;
                String number = phoneNumber[i];
                String nextNumber = phoneNumber[i+1];
                for(int j = 0 ; j < number.length(); j++){
                    if(number.charAt(j) == nextNumber.charAt(j)){
                        cnt++;
                    }else{
                        answer = "YES";
                        break;
                    }
                }
                if(cnt == number.length()){
                    answer = "NO";
                    break;
                }
            }
            System.out.println(answer);
        }
    }

}
