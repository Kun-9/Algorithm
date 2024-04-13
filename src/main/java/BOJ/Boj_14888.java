package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14888 {

	static int N;
	static int[] arr;
	static int[] sign;
	static int[] result = {Integer.MAX_VALUE, Integer.MIN_VALUE};

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sign = new int[4];
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < 4; i++) {
			sign[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static void main(String[] args) throws IOException {
		input();

		fun(arr[0], 1);

		System.out.println(result[1]);
		System.out.println(result[0]);
	}

	private static void fun(int current, int index) {
		if (index == N) {
			result[0] = Math.min(result[0], current);
			result[1] = Math.max(result[1], current);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (sign[i] > 0) {
				int temp;

				if (i == 0) {
					temp = current + arr[index];
				} else if (i == 1) {
					temp = current - arr[index];
				} else if (i == 2) {
					temp = current * arr[index];
				} else {
					temp = current / arr[index];
				}

				sign[i]--;
				fun(temp, index + 1);
				sign[i]++;
			}
		}



	}
}