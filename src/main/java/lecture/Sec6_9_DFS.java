import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 좌표 정렬
public class Main {
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

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());
			arr[i] = value;
		}


		for (int i = 0; i < N - M + 2; i++) {
			DFS(0, i);
		}

		System.out.println(max);
	}

	static int max = Integer.MAX_VALUE;

	private static void DFS(int index, int num) {
		if (index <= M - 2) {
			result[index] = num;

			if (index == M - 2) {
				int tempMax = 0;

				int[] sums = new int[result.length + 1];

				int sum = 0;
				int resultIndex = 0;

				for (int i = 0; i < arr.length; i++) {
					sum += arr[i];

					if (resultIndex < result.length && i == result[resultIndex]) {
						sums[resultIndex] = sum;
						resultIndex++;
						sum = 0;
					}
				}

				sum = 0;
				for (int i = result[result.length - 1] + 1; i < N; i++) {
					sum += arr[i];
				}
				sums[resultIndex] = sum;

				for (int i : sums) {
					tempMax = Math.max(tempMax, i);
				}
				max = Math.min(tempMax, max);

				return;
			}
		} else return;

		for (int i = num; i < N - 2; i++) {
			DFS(index + 1, i + 1);
		}
	}
}

