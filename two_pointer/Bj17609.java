package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//option+command+L : line
public class Bj17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String str = br.readLine();
            int length = str.length();
            int front = 0;
            int rear = length - 1;

            if (isPalindrome(str, front, rear)) {
                sb.append(0).append("\n");
            }

            while (front <= rear) {
                if (str.charAt(front) == str.charAt(rear)) {
                    front++;
                    rear--;
                } else if (isPalindrome(str, front + 1, rear)) {
                    sb.append(1).append("\n");
                    break;
                } else if (isPalindrome(str, front, rear - 1)) {
                    sb.append(1).append("\n");
                    break;
                } else {
                    sb.append(2).append("\n");
                    break;
                }
            }


        }

        System.out.println(sb);
    }

    private static boolean isPalindrome(String str, int front, int rear) {
        boolean answer = true;

        while (front <= rear) {
            if (str.charAt(front) == str.charAt(rear)) {
                front++;
                rear--;
            } else {
                answer = false;
                break;
            }
        }

        return answer;
    }
}
