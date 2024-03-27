package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15486 {
	private static StringTokenizer st;

	private static int N;
	private static int[] T, P, arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		T = new int[N];
		P = new int[N];
		arr = new int[N + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = N - 1; i >= 0; i--) {
			if ((N - i) < T[i]) {
				arr[i] = arr[i + 1];
				continue;
			}

			if (i + T[i] == N) {
				arr[i] = Math.max(arr[i + 1], P[i]);
			} else {
				arr[i] = Math.max(arr[i + 1], P[i] + arr[i + T[i]]);
			}
		}
		System.out.println(arr[0]);
	}
}