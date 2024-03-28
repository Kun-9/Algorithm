package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16928 {

	public static int[] map = new int[101];

	public static boolean[] visited = new boolean[101];

	public static int ladderNum, snakeNum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		ladderNum = Integer.parseInt(st.nextToken());
		snakeNum = Integer.parseInt(st.nextToken());

		for (int x = 0; x < ladderNum + snakeNum; x++) {
			st = new StringTokenizer(br.readLine());

			map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());

		}

		Queue<Integer> queue = new LinkedList<>();

		queue.add(1);
		visited[1]=true;

		int answer = 0;
		boolean find=false;

		while (!queue.isEmpty()) {
			int size = queue.size();


			for (int x = 0; x < size; x++) {
				int now = queue.poll();

				if (now == 100) {
					find=true;
					break;
				}

				for (int y = 1; y <= 6; y++) {
					if (now + y <= 100) {
						int next = now + y;

						if (map[next] > 0) {
							next = map[next];
						}

						if (!visited[next]) {
							visited[next] = true;
							queue.add(next);
						}
					}
				}
			}
			if(find) break;

			answer++;
		}

		System.out.println(answer);
	}
}