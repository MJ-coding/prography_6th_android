package first;
import java.io.*;
import java.util.*;

public class Bj1000 {

	public static void main(String[] args) throws IOException  {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		if(0< a && a <10 && 0< b && b< 10) {
			System.out.print(a + b);
		}
	}

}
