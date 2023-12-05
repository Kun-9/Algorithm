import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 미로 탐색 2178
public class Main {
	static int N, M;
	static int[][] miro, check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		miro = new int[N][M];
		check = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			for (int j = 0; j < M; j++) {
				int digit = Character.getNumericValue(str.charAt(j));
				miro[i][j] = digit;
			}
		}

		System.out.println(BFS());
	}

	private static int BFS() {
		int i, j;
		Queue<int[]> queue = new LinkedList<>();
		int index = 0;
		queue.offer(new int[]{0, 0});

		while (!queue.isEmpty()) {
			int len = queue.size();

			for (int k = 0; k < len; k++) {
				int[] poll = queue.poll();

				i = poll[0]; j = poll[1];

				if (i == N - 1 && j == M - 1) return ++index;

				validOffer(i + 1, j, queue);
				validOffer(i, j + 1, queue);
				validOffer(i - 1, j, queue);
				validOffer(i, j - 1, queue);
			}
			index++;
		}
		return 0;
	}

	private static void validOffer(int i, int j, Queue<int[]> queue) {
		// 좌표가 허용 범위에 포함 되는지 검증
		if (i >= 0 && j >= 0 && i < N && j < M) {
			// 해당 좌표의 값이 1인지, 방문 한적 없는지 확인
			if (miro[i][j] == 1 && check[i][j] == 0) {
				queue.offer(new int[]{i, j});
				check[i][j] = 1;
			}
		}
	}
}
