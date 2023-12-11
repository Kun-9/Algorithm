import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 공주 구하기
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		int cnt = 0;
		while (queue.size() != 1) {
			if (++cnt == K) {
				// 탈락
				queue.poll();
				cnt = 0;
			} else {
				queue.add(queue.poll());
			}
		}

		System.out.print(queue.poll());
	}
}

