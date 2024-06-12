package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BoJ_1015 {

	static int N;
	static int[] B, A, P, check;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		B = new int[N];
		A = new int[N];
		P = new int[N];
		check = new int[1001];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());

			A[i] = B[i] = n;
		}

		Arrays.sort(B);

		solution();

		for (int i : P) {
			System.out.print(i + " ");
		}

	}

	public static void solution() {

		for (int i = 0; i < N; i++) {
			int cur = A[i];

			int foundIndex = find(cur);
			P[i] = foundIndex + check[cur];
			check[cur]++;
		}
	}


	public static int find(int target) {
		int lt = 0;
		int rt = N;
		int current = N / 2;
		boolean flag = false;

		while (!flag) {

			if (B[current] > target) {
				rt = current;
				current = (current + lt) / 2;
			} else if (B[current] < target) {
				lt = current;
				current = (current + rt) / 2;
			} else {
				flag = true;
			}
		}

		while (current - 1 >= 0) {
			if (B[current - 1] == target) {
				current--;
			} else {
				break;
			}
		}

		return current;
	}
}