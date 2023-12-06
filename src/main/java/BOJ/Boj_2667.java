import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int[][] graph;
	static int[][] check;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		int totalCount = 0;
		List<Integer> result = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		graph = new int[N][N];
		check = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				int value = Character.getNumericValue(str.charAt(j));
				graph[i][j] = value;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (graph[i][j] == 1 && check[i][j] == 0) {
					totalCount++;
					DFS(i, j);
					result.add(cnt);
					cnt = 0;
				}
			}
		}

		System.out.println(totalCount);
		Collections.sort(result);
		for (Integer i : result) {
			System.out.println(i);
		}
	}

	private static void DFS(int i, int j) {
		if (i < 0 || i >= N || j < 0 || j >= N || check[i][j] == 1 || graph[i][j] == 0) return;

		check[i][j] = 1;
		cnt++;

		DFS(i + 1, j);
		DFS(i, j + 1);
		DFS(i - 1, j);
		DFS(i, j - 1);
	}
}

