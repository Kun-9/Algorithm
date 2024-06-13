package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Boj_11652 {

	static int N;
	static int max = -1;

	static TreeMap<Long, Integer> map;

	static long result;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new TreeMap<>();

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			long n = Long.parseLong(br.readLine());
			Integer temp = map.getOrDefault(n, 0);
			map.put(n, ++temp);
		}

		solution();

		System.out.print(result);
	}

	public static void solution() {


		// 최댓값 찾기
		for (long t : map.keySet()) {
			Integer val = map.get(t);
			if (max < val) {
				max = val;
				result = t;
			}
		}
	}
}