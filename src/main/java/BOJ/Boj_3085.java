package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_3085 {

	static Character currentChar = null;
	static int cnt = 0;
	static int max = 0;
	static boolean flag = false;
	static int N;
	static char[][] board;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		board = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				char c = str.charAt(j);
				board[i][j] = c;
			}
		}

		// 최초 상태 최댓값
		for (int i = 0; i < N; i++) {
			scan(0, i);
			scan(1, i);
		}

		loop:
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 수평 교환
				if (j + 1 < N && board[i][j] != board[i][j + 1]) {
					swap(i, j, i, j + 1);
					scan(0, i);
					scan(1, j);
					scan(1, j + 1);
					swap(i, j, i, j + 1);
				}

				// 수직 교환
				if (i + 1 < N && board[i][j] != board[i + 1][j]) {
					swap(i, j, i + 1, j);
					scan(1, j);
					scan(0, i);
					scan(0, i + 1);
					swap(i, j, i + 1, j);
				}

				if (flag) break loop;
			}
		}


		System.out.println(max);
	}

	private static void swap(int x, int y, int tx, int ty) {
		char temp = board[x][y];
		board[x][y] = board[tx][ty];
		board[tx][ty] = temp;
	}

	static private boolean isCorrect(char target) {
		return currentChar == null || currentChar == target;
	}

	static private void reset() {
		cnt = 0;
		currentChar = null;
	}

	static private void scan(int type, int num) {
		for (int i = 0; i < N; i++) {
			if (flag) return;

			char target;
			if (type == 0) {
				target = board[num][i];
			} else {
				target = board[i][num];
			}

			boolean result = isCorrect(target);
			if (!result) {
				updateMax();
			}

			currentChar = target;
			cnt++;
		}

		updateMax();
	}

	private static void updateMax() {
		if (cnt == N) {
			flag = true;
		}
		max = Math.max(cnt, max);
		reset();
	}
}