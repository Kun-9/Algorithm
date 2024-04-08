package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_15591 {

	static int[] answer;
	static int N, Q;

	static List<int[]>[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");


		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		answer = new int[Q];
		arr = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			arr[a - 1].add(new int[]{b - 1, r});
			arr[b - 1].add(new int[]{a - 1, r});
		}

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int k = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			answer[i] = BFS(t - 1, k);
		}

		for (int x : answer) {
			System.out.println(x);
		}
	}

	static private int BFS(int n, int k) {
		Queue<Integer> queue = new LinkedList<>();
		int[] visited = new int[N];
		int cnt = 0;

		queue.add(n);

		while (!queue.isEmpty()) {
			int target = queue.poll();
			visited[target] = 1;

			for (int[] x : arr[target]) {

				// 연결되어있고 방문하지 않았을 경우에 큐에 삽입
				if (x[1] >= k && visited[x[0]] == 0) {
					cnt++;
					queue.add(x[0]);
				}
			}
		}

		return cnt;
	}
}