import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 8_3
	static int[][] arr;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st2.nextToken());
			arr[i][1] = Integer.parseInt(st2.nextToken());
		}

		solution();

		System.out.println(max);

	}

	private static void solution() {

		DFS(0, 0, 0);

	}
	static int max = Integer.MIN_VALUE;

	private static void DFS(int index, int sumTime, int sumScore) {
		if (sumTime > M) return;

		if (index == arr.length) {
			max = Math.max(max, sumScore);
			return;
		}

		// 선택 할 경우
		DFS(index + 1, sumTime + arr[index][1], sumScore + arr[index][0]);
		// 선택 하지 않을 경우
		DFS(index + 1, sumTime, sumScore);
	}
}
