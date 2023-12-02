import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	// 8_4

	static int[] arr;
	static List<List<Integer>> result;
	static int N;
	static int M;

	static int[] temp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		result = new ArrayList<>();
		temp = new int[M];

		solution();

		for (List<Integer> integers : result) {
			for (Integer integer : integers) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}

	}

	private static void solution() {
		DFS(0);
	}

	private static void DFS(int index) {
		if (index == M) {
			List<Integer> t = new ArrayList<>();
			for (int i : temp) {
				t.add(i);
			}

			result.add(t);
			return;
		}

		for (int i = 0; i < N; i++) {
			temp[index] = arr[i];
			DFS(index + 1);
		}
	}
}
