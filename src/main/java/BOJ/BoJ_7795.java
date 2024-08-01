package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BoJ_7795 {

	static int N;

	static List<Integer> arr1;
	static List<Integer> arr2;
	static StringBuilder result;

	public static void main(String[] args) throws IOException {
		result = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			arr1 = new ArrayList<>();
			arr2 = new ArrayList<>();

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// 첫번째 배열 개수
			int n = Integer.parseInt(st.nextToken());

			// 두번째 배열 개수
			int m = Integer.parseInt(st.nextToken());

			StringTokenizer arrStr1 = new StringTokenizer(br.readLine(), " ");
			StringTokenizer arrStr2 = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < n; j++) {
				arr1.add(Integer.parseInt(arrStr1.nextToken()));
			}

			for (int j = 0; j < m; j++) {
				arr2.add(Integer.parseInt(arrStr2.nextToken()));
			}

			solution();


			arr1.clear();
			arr2.clear();
		}

		System.out.print(result);
	}

	public static void solution() {
		Collections.sort(arr2);

		int cnt = 0;
		for (int x : arr1) {
			cnt += search(x);
//			System.out.println();
		}

		result.append(cnt).append("\n");

	}

	public static int search(int target) {
		int result = -1;
		int p1 = 0;
		int p2 = arr2.size() - 1;
		int key = -1;
		while (p1 <= p2) {
			key = (p1 + p2) / 2;
			int keyValue = arr2.get(key);

			if (keyValue >= target) {
				p2 = key - 1;
			} else if (keyValue < target) {
				result = key;
				p1 = key + 1;
			}
		}

		if (result == -1) return 0;

		return result + 1;
	}
}