package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2573 {
	static int N, M;
	static boolean[][] check;
	static int[][] graph;
	static int[] moveX = {-1, 1, 0, 0};
	static int[] moveY = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new int[N][M];

		for (int i = 0; i < N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(temp.nextToken());
			}
		}
		int result = 0;

		loop:
		while (true) {
			int cnt = 0;
			check = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (cnt >= 2) break loop;
					// i j 를 순환하며 BFS
					if (graph[i][j] != 0 && !check[i][j]) {
						BFS(new Info(i, j));
						cnt++;
					}
				}
			}

			// 분리되지 않는 경우
			if (cnt == 0) {
				result = 0;
				break;
			}

			result++;
		}

		System.out.print(result);
	}

	private static void BFS(Info info) {
		Queue<Info> queue = new LinkedList<>();

		queue.offer(info);
		check[info.getX()][info.getY()] = true;

		while (!queue.isEmpty()) {
			int len = queue.size();

			for (int i = 0; i < len; i++) {

				Info poll = queue.poll();

				int x = poll.getX();
				int y = poll.getY();

				for (int j = 0; j < 4; j++) {
					int tempX = x + moveX[j];
					int tempY = y + moveY[j];

					if (tempX >= 0 && tempX < N && tempY >= 0 && tempY < M ) {
						if (!check[tempX][tempY]) { // 방문한적 없는 노드일 때 (탐색하는 경우)
							if (graph[tempX][tempY] == 0) { // 해당 노드가 0일때 (녹는 경우)
								int value = graph[x][y];
								if (value != 0) graph[x][y] = --value;
								continue;
							}

							check[tempX][tempY] = true;
							queue.offer(new Info(tempX, tempY));
						}
					}
				}
			}
		}
	}

	private static class Info {
		int x;
		int y;
		public Info(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}
}

