package lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Sec8_5 {
	// 8_5

	static Integer[] arr;
	static int N;
	static int target;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new Integer[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, Collections.reverseOrder());

		target = Integer.parseInt(br.readLine());

		solution();

		System.out.println(min);

	}

	private static void solution() {
		DFS(0, 0, 0);
	}
	static int min = Integer.MAX_VALUE;

	private static void DFS(int index, int sum, int t) {
		if (index >= min) return;
		if (sum > target) return;

		if (sum == target) {
			min = index;
			return;
		}

		for (int i = t; i < N; i++) {
			DFS(index + 1, sum + arr[i], i);
		}
	}
}
