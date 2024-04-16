package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1182 {

	static int N, S;
	static int[] arr, temp;
	static int result = 0;
	static int cnt = 0;


	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		temp = new int[N];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}


	public static void main(String[] args) throws IOException {
		input();

		fun(0, 0);

		System.out.println(result);
	}

	private static void fun(int sum, int index) {
		if (index == N) {
			if (sum == S && cnt != N) {
				result++;
			}

			return;
		}

		// 더하는 경우
		temp[index] = 1;
		fun(sum + arr[index], index + 1);

		// 더하지 않는 경우
		temp[index] = 0;
		cnt++;
		fun(sum, index + 1);
		cnt--;
	}

}