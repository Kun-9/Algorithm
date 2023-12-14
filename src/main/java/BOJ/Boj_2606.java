package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2606 {
	static int N, M;
	static int[][] graph;
	static int[] check;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 컴퓨터의 수 (노드의 수)
		N = Integer.parseInt(br.readLine());

		// 쌍의 수 (간선의 수)
		M = Integer.parseInt(br.readLine());

		graph = new int[N + 1][N + 1];
		check = new int[N + 1];

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a][b] = graph[b][a] = 1;
		}
		DFS(0,1);

		System.out.print(cnt);
	}

	private static void DFS(int index, int current) {
		check[current] = 1;

		for (int i = 1; i <= N; i++) {
			if (graph[current][i] == 1 && check[i] == 0) {
				cnt++;
				DFS(index + 1, i);
			}
		}
	}
}

