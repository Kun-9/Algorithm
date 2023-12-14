package lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 좌표 정렬
public class Sec6_7_Binary {
	static int[] arr;
	static int[] result;
	static int M, N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		result = new int[M - 1];

		int rt = 0, lt = 0, mt = 0;

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());
			lt = Math.max(lt, value);
			rt += value;
			arr[i] = value;
		}

		int result = 0;

		while (rt >= lt) {

			mt = (rt + lt) / 2;
			int sum = 0;
			int cnt = 0;

			for (int i = 0; i < N; i++) {
				sum += arr[i];

				if (sum > mt) {
					cnt++;
					sum = 0;
					i--;
				}
			}
			if (sum > 0) cnt++;

			if (cnt <= M) {
				result = mt;
				rt = mt - 1;
			} else {
				lt = mt + 1;
			}
		}

		System.out.println(result);

	}
}

