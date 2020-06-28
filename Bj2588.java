package first;

import java.io.*;

public class Bj2588 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
		int first = b%10;
		int second = (b%100 - first)/10;
		int third = b/100;
		
		System.out.println(a*first);
		System.out.println(a*second);
		System.out.println(a*third);
		System.out.println(a*third*100 + a*second*10 + a*first);
	}

}
