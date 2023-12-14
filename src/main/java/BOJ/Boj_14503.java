package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14503 {
	static int N, M, r, c, d;
	static int[][] map;
	static int[] moveX = {-1, 0, 1, 0};
	static int[] moveY = {0, 1, 0, -1};
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		st = new StringTokenizer(br.readLine(), " ");

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		DFS(new Info(r, c));
		System.out.println(result);
	}

	static private void DFS(Info currentInfo) {
		// x, y좌표의 값을 1로 변경. 청소가 되지 않은 상태였다면 청소를 한 칸이므로 result++
		if (setCheck(currentInfo)) {
			result++;
		}

		boolean flag = false;
		for (int i = 0; i < 4; i++) {
			Info nextValue = new Info(currentInfo.getX() + moveX[i], currentInfo.getY() + moveY[i]);

			// 청소되지 않은 구역이 하나라도 있는 경우 flag = true
			if (validateValue(nextValue) == 0) {
				flag = true;
				break;
			}
		}

		// 주변에 빈 청소 구역이 있는 경우. 반시계 방향으로 회전 후 빈칸인 경우 한칸 전진 후 DFS.
		if (flag) {
			turn();
			Info nextValue = new Info(currentInfo.getX() + moveX[d], currentInfo.getY() + moveY[d]);

			if (validateValue(nextValue) == 0) {
				DFS(nextValue);
			} else {
				// 빈칸이 아니라면 다시 재귀
				DFS(currentInfo);
			}
		} else {
			// 빈 청소 구역이 없는 경우, 후진하고 DFS.
			int backDirection = back();
			Info nextValue = new Info(currentInfo.getX() + moveX[backDirection], currentInfo.getY() + moveY[backDirection]);

			if (validateValue(nextValue) != -1) {
				DFS(nextValue);
			}
		}
	}

	private static class Info {
		private final int x;
		private final int y;

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

	private static int validateValue(Info info) {
		int x = info.getX();
		int y = info.getY();

		if (y > 0 && y < M - 1 && x > 0 && x < N - 1) {
			if (map[x][y] != 1) {
				return map[x][y];
			}
		}
		return -1;
	}

	private static boolean setCheck(Info info) {
		int x = info.getX();
		int y = info.getY();

		if (map[x][y] == 0) {
			map[x][y] = 2;
			return true;
		}
		return false;
	}

	private static void turn() {
		if (--d == -1) d = 3;
	}

	private static int back() {
		if (d <= 1) return d + 2;
		return d - 2;
	}
}

