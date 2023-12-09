package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


// 합이 같은 부분 집합
public class Sec8_1 {

	static boolean ch = false;
	static int target;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		solution();

		if (ch) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

	static private void solution() {
		if (Arrays.stream(arr).sum() % 2 != 0) return;

		target = Arrays.stream(arr).sum() / 2;

		DFS(0, 0);
	}

	/**
	 * 1. 어떻게 마지막 요소 파악??
	 *      반절 보다 크거나 정답 이어도 한번에 빠져나 올 수 있나?
	 *
	 */
	private static void DFS(int index, int sum) {

		if (ch) return;
		if (index == arr.length) return;
		if (sum == target) {
			ch = true;
			return;
		}
		if (sum > target) return;

		// 더한 경우
		DFS(index + 1, sum + arr[index]);
		// 안 더한 경우
		DFS(index + 1, sum);
	}
}


