package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj2110 {
    private static int[] house;
    private static int C;
    private static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        house = new int[N];
        for(int i = 0; i < N; i++){
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        System.out.println(binarySearchRouter(0,house[N-1]-house[0]));
    }

    private static  int binarySearchRouter(int start, int end) {
        int mid, answer = 0;

        while(start <= end){
            mid = (start+end)/2;
            int routerCount = getRouter(mid);
            if( C <= routerCount) {
                start = mid + 1;
                answer = mid;
            }
            else {
                end = mid - 1;
            }
        }
        return answer;
    }

    private static int getRouter(int k) {
        int count = 1;
        int prevHouse = house[0];

        for(int i = 1; i < N; i++) {
            if(k > house[i] - prevHouse) continue;
            count++;
            prevHouse = house[i];
        }

        return count;
    }
}
