package BOJ;

import java.io.*;
import java.util.*;

public class Boj_16918 {

	static int R, C, N;

	static int[][] board;
	static boolean flag = true;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		board = new int[R][C];

//		List<int[]> bombArr = new ArrayList<>();

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				if (str.charAt(j) == 79) {
					board[i][j] = 3;
				}
			}
		}

		// 1
		next();

		if (N == 1) {
			printBoard();
			return;
		}

		for (int i = 0; i < N - 1; i++) {
			if (flag) fillBomb();

			next();
		}

		printBoard();
	}

	private static void printBoard() {
		for (int[] ints : board) {
			for (int anInt : ints) {
				if (anInt > 0) {
					System.out.print(0);
				} else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
	}

	private static void next() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == 1) {
					bomb(i, j);
					flag = true;
				}
			}
		}


		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == 0) continue;
//				if (board[i][j] == 1) {
//					bomb(i, j);
//					flag = true;
//				}
				board[i][j]--;
			}
		}
	}

	private static void fillBomb() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == 0) board[i][j] = 3;
			}
		}
		flag = false;
	}

	private static void bomb(int r, int c) {
		// -1 , 0
		if (r - 1 >= 0) {
//			System.out.println("r : " + r + " , c : " + c);
			if (board[r - 1][c] > 1) {
				board[r - 1][c] = 0;
			}
		}
		// 1 , 0
		if (r + 1 < R) {
			if (board[r + 1][c] > 1) {
				board[r + 1][c] = 0;
			}
		}
		// 0 , -1
		if (c - 1 >= 0) {
			if (board[r][c - 1] > 1) {
				board[r][c - 1] = 0;
			}
		}
		// 0 , +1
		if (c + 1 < C) {
			if (board[r][c + 1] > 1) {
				board[r][c + 1] = 0;
			}
		}
	}

}
