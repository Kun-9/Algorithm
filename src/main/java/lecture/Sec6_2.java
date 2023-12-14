package lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 삽입 정령
public class Sec6_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 버블 정렬
		// 맨 처음부터 반복하면서 바로 앞의 숫자를 확인
		for (int i = N; i >= 0; i--) {
			boolean flag = false;
			for (int j = 0; j < i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
					flag = true;
				}
			}

			if (!flag) break;
		}

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}

