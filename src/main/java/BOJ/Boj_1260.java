package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class dfs_bfs {
	static int n;
	static int m;
	static Map<Integer, List<Integer>> map;
	static int[] check = new int[1001];
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st1.nextToken());
		m = Integer.parseInt(st1.nextToken());
		int r = Integer.parseInt(st1.nextToken());
		result = new int[n];

		map = new HashMap<>();

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			List<Integer> list1 = map.getOrDefault(a, new ArrayList<>());
			list1.add(b);
			map.put(a, list1);

			List<Integer> list2 = map.getOrDefault(b, new ArrayList<>());
			list2.add(a);
			map.put(b, list2);
		}

		for (Integer i : map.keySet()) {
			List<Integer> list = map.get(i);
			if (list == null) continue;
			Collections.sort(list);
		}

		solution(r);
	}

	private static void solution(int r) {
		DFS(r);
		printResult();

		// check 배열 초기화
		check = new int[1001];
		BFS(r);
		printResult();
	}

	private static void printResult() {
		for (int i : result) {
			if (i == 0) break;
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private static void DFS(int r) {
		check[r] = 1;
		System.out.print(r + " ");

		List<Integer> integers = map.getOrDefault(r, new ArrayList<>());

		for (Integer integer : integers) {
			if (check[integer] == 1) continue;
			DFS(integer);
		}
	}

	private static void BFS(int r) {
		Queue<Integer> queue = new LinkedList<>();
		check[r] = 1;
		queue.offer(r);

		while (!queue.isEmpty()) {
			Integer poll = queue.poll();

			System.out.print(poll + " ");

			List<Integer> integers = map.getOrDefault(poll, new ArrayList<>());

			for (Integer integer : integers) {
				if (check[integer] == 0) {
					check[integer] = 1;
					queue.offer(integer);
				}
			}
		}
	}
}
