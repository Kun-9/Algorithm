package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_7569 {

	static int N, M, H;
	static int[][][] box;
	static boolean flag = false;


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		box = new int[N][M][H];

		List<int[]> ripenList = new ArrayList<>();

		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				StringTokenizer temp = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					int value = Integer.parseInt(temp.nextToken());
					if (value == 1) ripenList.add(new int[]{i, j, h});
					box[i][j][h] = value;
				}
			}
		}
		System.out.println(BFS(ripenList));
	}

	private static int BFS(List<int[]> list) {
		if (isFinish()) return 0;

		Queue<int[]> queue = new LinkedList<>();
		int m; int n; int h;

		// 처음 익은 토마토들을 모두 큐에 넣는다.
		for (int[] ints : list) {
			queue.offer(new int[]{ints[0], ints[1], ints[2]});
		}

		int index = 0;

		while (!queue.isEmpty()) {
			int len = queue.size();
			flag = false;

			for (int i = 0; i < len; i++) {
				int[] poll = queue.poll();

				m = poll[0]; n = poll[1]; h = poll[2];

				validOffer(m + 1, n, h, queue);
				validOffer(m - 1, n, h, queue);
				validOffer(m, n + 1, h, queue);
				validOffer(m, n - 1, h, queue);
				validOffer(m, n, h + 1, queue);
				validOffer(m, n, h - 1, queue);
			}
			// 아무것도 변경시키지 못한다면
			if (!flag) {
				// 안익은 토마토가 있다면 -1 리턴
				if (!isFinish()) return -1;
				return index;
			}
			index++;
		}
		return -1;
	}

	private static void validOffer(int m, int n, int h, Queue<int[]> queue) {
		// 조건 통과하면 queue에 삽입
		if (!(m < 0 || m >= N || n < 0 || n >= M || h < 0 || h >= H)) {
			if (box[m][n][h] == 0) {
				flag = true;
				box[m][n][h] = 1;
				queue.offer(new int[]{m, n, h});
			}
		}
	}

	private static boolean isFinish() {
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (box[i][j][h] == 0) return false;
				}
			}
		}
		return true;
	}
}

