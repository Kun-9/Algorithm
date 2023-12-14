package lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 좌표 정렬
public class Sec6_8 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int lt = 0;
		int rt = N - 1;
		int mt;

		while (lt <= rt) {
			mt = (lt + rt) / 2;

			if (arr[mt] < M) {
				lt = mt + 1;
			} else if (arr[mt] > M) {
				rt = mt - 1;
			} else {
				System.out.println(mt + 1);
				return;
			}
		}
	}
}

