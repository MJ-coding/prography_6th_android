package implementation;

import java.util.Scanner;
/*
 *********
  *******
   *****
    ***
     *

 */
public class Bj2443 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int j = 0;

        for(int i = 2*N-1; i>0;i -=2){
            System.out.println(" ".repeat(j)+"*".repeat(i));
            j++;
        }
    }
}
