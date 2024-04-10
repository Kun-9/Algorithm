package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15652 {

	static int M;
	static int N;

	static int[] arr;
	static int[] used;

	static StringBuilder sb = new StringBuilder();

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		used = new int[N + 1];
	}

	public static void main(String[] args) throws IOException {

		input();

		fun(1, 0);

		System.out.println(sb.toString());


	}



	private static void fun(int pre, int index) {
		if (index == M) {
			for (int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = pre; i <= N; i++) {
			arr[index] = i;
			fun(i, index + 1);
		}
	}
}