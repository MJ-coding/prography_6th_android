package implementation;

import java.util.Scanner;

/*
문제
첫째 줄에는 별 1개, 둘째 줄에는 별 3개, ..., N번째 줄에는 별 2×N-1개를 찍는 문제

별은 가운데를 기준으로 대칭이어야 한다.
    *4
   ***3
  *****2
 *******1
*********
 */
public class Bj2442 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int j = N-1;

        for(int i =1; i <= 2*N-1; i += 2){
            System.out.println(" ".repeat(j)+"*".repeat(i));
            j--;
        }

    }
}
