package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1072 {
    private static long X;
    private static long Y;
    private static long Z;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        Z = Y*100/X;
        System.out.println(binarySearchWinningCount(0,1_000_000_000));
    }
    private static int binarySearchWinningCount(int start, int end){
        int mid = 0;
        int answer = -1;

        while(start <= end){
            mid = (start+end)/2;
            if(newWinningRate(mid) > Z ){
                answer = mid;
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return  answer;
    }

    private static long newWinningRate(int mid) {
        return (Y+mid)*100/(X+mid);
    }
}
