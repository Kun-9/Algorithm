package lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//
public class Sec9_7 {
	static int find(int target) {
		if (arr[target] == target) return target;
		else return arr[target] = find(arr[target]);
	}

	static void union(int from, int to) {
		int result1 = find(from);
		int result2 = find(to);
		if (result1 != result2) arr[result1] = result2;
	}

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			union(from, to);
		}

		st = new StringTokenizer(br.readLine(), " ");
		int targetFrom = Integer.parseInt(st.nextToken());
		int targetTo = Integer.parseInt(st.nextToken());

		String result = "NO";
		if (find(targetFrom) == find(targetTo)) {
			result = "YES";
		}

		System.out.println(result);
	}
}

