package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9663 {

	static int N;
	static int[] board;
	static int result = 0;


	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N];
	}

	/*

		N x N 체스판에 퀸 N개를 서로 공격할 수 없게 놓는 문제

	 */

	public static void main(String[] args) throws IOException {
		input();

		fun(0);

		System.out.println(result);
	}

	private static void fun(int row) {
		// row

		if (row == N) {
			if (check()) {
				result++;
			}
			return;
		}

		for (int i = 0; i < N; i++) {

			boolean flag = true;

			for (int j = 0; j < row; j++) {
				if (attackable(board[j], j, i, row)) {
					flag = false;
					break;
				}
			}

			if (flag) {
				board[row] = i;
				fun(row + 1);
				board[row] = 0;
			}
		}

//		for (int i = 0; i < N; i++) {
//			if (row != 0) {
//				if (!attackable(board[row - 1], row - 1, i, row)) {
//					board[row] = i;
//					fun(row + 1);
//					board[row] = 0;
//				}
//			} else {
//				board[row] = i;
//				fun(row + 1);
//				board[row] = 0;
//			}
//		}
	}

	public static boolean attackable(int x, int y, int tx, int ty) {
		if (x + y == tx + ty) return true;
		if (x - y == tx - ty) return true;
		if (x == tx) return true;
		return false;
	}



	// 이전까지 하나씩 체크
	public static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (attackable(board[i], i, board[j], j)) {
					return false;
				}
			}
		}
		return true;
	}



}