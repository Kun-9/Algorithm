package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2011 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] charArr = br.readLine().toCharArray();

		if (charArr[0]=='0') {
			System.out.println(0);
			return;
		}

		long[] dp = new long[charArr.length+1];
		dp[0] = dp[1] = 1;

		char prev = charArr[0];
		int lastTwo;

		for (int i = 1; i < charArr.length; i++) {
			long cnt = 0L;

			if (charArr[i]=='0' && !(prev == '1'||prev == '2')) {
				System.out.println(0);
				return;
			}

			if (charArr[i]!='0') {
				cnt += dp[i];
			}

			lastTwo = (charArr[i-1]-'0')*10 + (charArr[i]-'0');
			if (lastTwo>=10 && lastTwo<=26) {
				cnt += dp[i-1];
			}

			dp[i+1] = cnt%1000000;
			prev = charArr[i];

		}

		System.out.println(dp[charArr.length]);
	}
}