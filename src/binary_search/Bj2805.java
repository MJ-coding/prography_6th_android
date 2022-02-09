package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj2805 {
    private static int M;
    private static long sum;
    private static int[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);

        System.out.println(binarySearchHigh(0,trees[N-1]));


    }

    private static int binarySearchHigh(int start, int end) {
        int mid = 0;
        int answer = 0;

        while(start <= end){
            mid = (start+end)/2;
            if(getTree(mid) >= M ){
                answer = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return answer;
    }

    private static long getTree(long cutter) {
        sum = 0;
        for(int tree : trees){
            if(tree <= cutter) continue;
            sum += tree-cutter;
        }
        return sum;
    }
}

