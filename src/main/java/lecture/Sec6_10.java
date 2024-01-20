package lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 마구간 정하기
public class Sec6_10 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int rt = arr[N - 1];
		int lt = 1;
		int target;
		int result = 0;

		while (lt <= rt) {
			int cnt = 1;

			target = (lt + rt) / 2;
			int currentValue = arr[0];

			for (int j = 1; j < N; j++) {
				if (cnt == C) {
					break;
				}

				if (currentValue + target <= arr[j]) {
					cnt++;
					currentValue = arr[j];
				}
			}

			// target 을 줄여야함
			if (cnt < C) {
				rt = target - 1;
			} else {
				result = target;
				lt = target + 1;
			}
		}

		System.out.print(result);
	}
}

