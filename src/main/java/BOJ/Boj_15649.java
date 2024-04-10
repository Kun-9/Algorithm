package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15649 {

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


		// 1 ~ N까지의 자연수 중 M개를 고른 수열
		// 같은 수를 여러번 골라도 됨

		fun(0);

		System.out.println(sb.toString());


	}



	private static void fun(int index) {
		if (index == M) {
			for (int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {

			if (used[i] == 0) {
				arr[index] = i;
				used[i] = 1;

				fun(index + 1);

				arr[index] = 0;
				used[i] = 0;
			}
		}
	}
}