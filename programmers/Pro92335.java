package programmers;
import java.util.*;

public class Pro92335 {

    public static void main(String[] args) {
        //n = 1 k = 10
        System.out.println(solution(100110,10));
    }

    public static int solution(int n, int k) {
        int answer = 0;
        String kNum = Integer.toString(n,k);
        //System.out.println(isPrime[2]);
        System.out.println(kNum);
        StringTokenizer st = new StringTokenizer(kNum,"0");
        while(st.hasMoreTokens()){//99
            long tenNum = Long.parseLong(st.nextToken());
            System.out.println(tenNum);
            //System.out.println(isPrime(tenNum));
            if(isPrime(tenNum) == 1 ){
                answer++;
            }
        }


        return answer;
    }
    private static int isPrime(long num){
        if(num == 1){
            return 0;
        }
        for(int i = 2 ; i < (int)Math.sqrt(num) + 1; i++){
            if(num%i == 0){
                return 0;
            }
        }
        return 1;
    }

}
