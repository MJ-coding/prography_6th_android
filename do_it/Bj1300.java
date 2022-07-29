package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1300 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //중앙값 기준으로 범위찾기
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long start = 1;
        long end = k;
        long mid = 0;
        long num = 0;
        long answer = 0;

        while(start <= end){
            num = 0;
            mid = (start+end)/2;

            for(int i = 1 ; i <= N ; i++){
                num += Math.min(N,mid/i);//mid 보다 작거나 같은 개수
            }

            if(num < k) {
                start = mid+1;
            }else{
                answer = mid;
                end = mid -1;
            }
        }
        System.out.println(answer);
    }

}
