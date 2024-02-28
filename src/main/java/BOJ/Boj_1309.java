package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_1309 {

	static int N;
	static int[][] dp;
	static final int num=9901;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1][3];

		Arrays.fill(dp[1], 1);


		for(int i=2;i<=N;i++) {
			dp[i][0]=(dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%num;
			dp[i][1]=(dp[i-1][2]+dp[i-1][0])%num;
			dp[i][2]=(dp[i-1][1]+dp[i-1][0])%num;
		}

		System.out.println(Arrays.stream(dp[N]).sum()%num);
	}
}