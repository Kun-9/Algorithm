package lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 씨름 선수 Greedy
public class Sec9_1 {

	static class Body implements Comparable<Body> {

		int height;
		int weight;

		public Body(int height, int weight) {
			this.height = height;
			this.weight = weight;
		}

		@Override
		public int compareTo(Body b) {
			return b.height - height;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int cnt = 0;
		List<Body> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int height = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list.add(new Body(height, weight));
		}

		Collections.sort(list);

		int max = 0;

		for (Body body : list) {
			max = Math.max(body.weight, max);
			if (body.weight == max) {
				cnt++;
			}
		}

		System.out.print(cnt);
	}
}

