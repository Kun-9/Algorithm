package BOJ;

import java.io.*;
import java.util.*;

public class Boj_15651 {

	static int M;
	static int N;

	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];

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
			arr[index] = i;
			fun(index + 1);
		}
	}
}
