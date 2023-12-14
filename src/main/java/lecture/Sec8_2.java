package lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 바둑이 구하기 문제
public class Sec8_2 {

	static int target;
	static int[] arr;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int max = Integer.parseInt(st.nextToken());

		int N = Integer.parseInt(st.nextToken());

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(solution(max));
	}

	private static int solution(int m) {
		target = m;

		DFS(0, 0);

		return max;
	}

	private static void DFS(int index, int sum) {

		// 더한 값이 최댓값을 넘으면 리턴
		if (sum > target) return;
		else {
			max = Math.max(max, sum);
			if (index == arr.length) return;
		}

		// 더하는 경우와 안 더하는 경우 두가지.
		DFS(index + 1, sum + arr[index]);
		DFS(index + 1, sum);
	}
}
