import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static boolean[][] check;
	static int[][] map;
	static int[] moveX = {-1, 1, 0, 0};
	static int[] moveY = {0, 0, -1, 1};
	static boolean flag;


	public static void main(String[] args) throws IOException {
		int cnt;
		int result = Integer.MIN_VALUE;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		for (int rainFall = 0; rainFall <= 100; rainFall++) {
			check = new boolean[N][N];
			cnt = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!check[i][j] && map[i][j] > rainFall) {
						flag = false;
						DFS(rainFall, i, j);
						if (flag) cnt++;
					}
				}
			}
			if (cnt == 0) break;
			result = Math.max(result, cnt);
		}

		System.out.print(result);
	}

	private static void DFS(int rainFall, int x, int y) {
		if (map[x][y] - rainFall <= 0 || check[x][y]) return;

		check[x][y] = true;
		flag = true;

		for (int i = 0; i < 4; i++) {
			int a = x + moveX[i];
			int b = y + moveY[i];

			if (a >= 0 && a < N && b >= 0 && b < N) {
				DFS(rainFall, a, b);
			}
		}
	}
}

