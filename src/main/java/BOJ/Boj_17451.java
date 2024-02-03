package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17451 {
	static int n;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long speedMin = 0;

		for(int i = n-1; i >=0; i--) {
			if(speedMin <= arr[i]) {
				speedMin = arr[i];
			} else if(speedMin > arr[i]) {
				long div = (speedMin / arr[i]);
				if(speedMin%arr[i]!=0) {
					div++;
				}
				speedMin = arr[i] * div;
			}
		}

		System.out.print(speedMin+"");
	}
}