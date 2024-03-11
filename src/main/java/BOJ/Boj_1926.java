package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1926 {
	static int[][] check;
	static int[][] board;

	static int maxX;
	static int maxY;

	static int maxValue;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		maxY = Integer.parseInt(st.nextToken());
		maxX = Integer.parseInt(st.nextToken());

		board = new int[maxY][maxX];
		check = new int[maxY][maxX];
		maxValue = 0;

		for (int i = 0; i < maxY; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < maxX; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		for (int i = 0; i < maxY; i++) {
			for (int j = 0; j < maxX; j++) {
				if (check[i][j] != 1 && board[i][j] == 1) {
					BFS(new Pos(j, i));
					cnt++;
				}
			}
		}

		System.out.println(cnt);
		System.out.println(maxValue);
	}

	private static void printBoard() {
		for (int[] ints : board) {
			for (int anInt : ints) {
				System.out.print(anInt + " ");
			}
			System.out.println();
		}
	}

	private static void BFS(Pos pos) {

		int cnt = 0;
		int x = pos.getX();
		int y = pos.getY();

		check[y][x] = 1;
		Queue<Pos> queue = new LinkedList<>();
		queue.add(pos);

		while (!queue.isEmpty()) {
			Pos poll = queue.poll();
			x = poll.getX();
			y = poll.getY();

			// 왼쪽
			if (x > 0) {
				if (check[y][x - 1] != 1 ) {
					checkBoard(y, x - 1, queue);
				}
			}

			// 오른쪽
			if (x < maxX - 1) {
				if (check[y][x + 1] != 1) {
					checkBoard(y, x + 1, queue);;
				}
			}

			// 위
			if (y > 0) {
				if (check[y - 1][x] != 1) {
					checkBoard(y - 1, x, queue);
				}
			}

			// 아래
			if (y < maxY - 1) {
				if (check[y + 1][x] != 1) {
					checkBoard(y + 1, x, queue);
				}
			}

			cnt++;
		}

		maxValue = Math.max(maxValue, cnt);
	}

	private static void checkBoard(int y, int x, Queue<Pos> queue) {
		if (board[y][x] == 1) {
			check[y][x] = 1;
			queue.add(new Pos(x, y));
		}
	}

	public static class Pos {
		private int x;
		private int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
	}
}