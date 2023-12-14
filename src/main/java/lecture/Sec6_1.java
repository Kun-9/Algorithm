package lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 선택 정렬
public class Sec6_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		int[] result = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 선택 정렬
		// 위치를 정해두고 적절한 수를 배치 하며 정렬!
		// j번째 수 탐색
		for (int j = 0; j < N - 1; j++) {
			for (int i = j; i < N; i++) {
				if (arr[i] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}

