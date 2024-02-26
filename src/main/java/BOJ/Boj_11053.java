package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_11053 {

	static int [] arr;
	static int n;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		String[] s = br.readLine().split(" ");

		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(s[i]);
		}

		int [] dp = new int[n];
		dp[0]=1;
		for(int i=1; i<n; i++){
			dp[i]=1;
			for(int j=0; j<i; j++){
				if(arr[i]>arr[j] && dp[j]>=dp[i]){
					dp[i]=dp[j]+1;
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[n-1]);
	}
}