package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11048 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());

		int[][] dp = new int[row + 1][col + 1];

		for (int i = 1; i <= row; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= col; j++) {
				if (i == 1 && j == 1)
					dp[i][j] = Integer.parseInt(st.nextToken());
				else
					dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i][j - 1])) + Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(dp[row][col]);
	}
}