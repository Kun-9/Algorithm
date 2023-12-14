package lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sec8_7 {
	// 8_7

	static int[][] dy = new int[35][35];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st1.nextToken());
		int r = Integer.parseInt(st1.nextToken());

		System.out.println(solution(n, r));
	}

	private static int solution(int n, int r) {
		return DFS(n, r);
	}

	private static int DFS(int n, int r) {

		if (dy[n][r] != 0) {
			return dy[n][r];
		}

		if (r == n) return 1;
		if (r == 1) return n;

		return dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
	}
}
