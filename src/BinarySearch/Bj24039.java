package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Bj24039 {
    private static ArrayList<Integer> prime;
    private static int n;
    private static final int ISPRIME_SIZE = 5000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        eratosthenes();
        int start = 0;
        int end = prime.size() - 1;

        System.out.println(binarySearch(start, end));

    }

    private static int binarySearch(int start, int end) {
        int answer = 0;
        int mid = 0;

        while(start <= end){
            mid = (start+end)/2;
            int multiply = prime.get(mid)*prime.get(mid+1);
            if(n < multiply){
                end = mid - 1;
                answer = multiply;
            }else{
                start = mid + 1;
            }
        }

        return answer;

    }

    private static void eratosthenes(){
        prime = new ArrayList<>();
        boolean[] isPrime = new boolean[ISPRIME_SIZE];
        Arrays.fill(isPrime,true);

        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2; i*i < ISPRIME_SIZE ; i++){
            for(int j = i*i ; j< ISPRIME_SIZE; j += i){
                isPrime[j] = false;
            }
        }
        for(int i =0 ; i < ISPRIME_SIZE ; i++){
            if(isPrime[i] == true)   prime.add(i);
        }

    }
}
