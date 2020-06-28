package first;
import java.util.*;
import java.io.*;

public class Bj10430 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		
		if(a>=2 && a<=10000 && b>=2 && b<=10000 && c >=2 && c<=10000){
            		
		System.out.println((a+b)%c);
		System.out.println((a%c +b%c)%c);
		System.out.println((a*b)%c);
		System.out.println((a%c*b%c)%c);
        }
	}
}
