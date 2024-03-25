package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1461 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> pQueue = new PriorityQueue<>((p1, p2) -> p2 - p1);
		PriorityQueue<Integer> nQueue = new PriorityQueue<>((p1, p2) -> p2 - p1);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (temp > 0) {
				pQueue.offer(temp);
			} else {
				nQueue.offer(Math.abs(temp));
			}
		}

		int max = 0;
		if (pQueue.isEmpty()) {
			max = nQueue.peek();
		} else if (nQueue.isEmpty()) {
			max = pQueue.peek();
		} else {
			max = Math.max(pQueue.peek(), nQueue.peek());
		}
		int result = 0;
		while (!pQueue.isEmpty()) {
			int temp = pQueue.poll();
			for (int i = 0; i < M - 1; i++) {
				pQueue.poll();
				if (pQueue.isEmpty()) {
					break;
				}
			}
			result += temp * 2;
		}
		while (!nQueue.isEmpty()) {
			int temp = nQueue.poll();
			for (int i = 0; i < M - 1; i++) {
				nQueue.poll();
				if (nQueue.isEmpty()) {
					break;
				}
			}
			result += temp * 2;
		}
		result -= max;

		System.out.println(result);
	}
}