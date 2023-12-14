package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_2644 {
	static int N, t1, t2;
	static int[][] graph;
	static List<Integer> tempList = new ArrayList<>();
	static List<Integer> t1Arr;

	static int temp = -1;

	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		int result = -1;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		graph = new int[N + 1][N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		t1 = Integer.parseInt(st.nextToken());
		t2 = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(temp.nextToken());
			int b = Integer.parseInt(temp.nextToken());

			// 방향 그래프
			graph[a][b] = 1;
		}

		getParents(t1);
		t1Arr = new ArrayList<>(tempList);
		flag = true;
		tempList.clear();

		getParents(t2);
		List<Integer> t2Arr = new ArrayList<>(tempList);

		if (!(temp == -1)) {
			result = t1Arr.indexOf(temp) + t2Arr.size();
		}

		System.out.print(result);
	}


	private static void getParents(int current) {
		if (flag) {
			if (t1Arr.contains(current)) {
				temp = current;
				return;
			}
		}

		tempList.add(current);

		for (int i = 1; i <= N; i++) {
			if (graph[i][current] == 1) {
				getParents(i);
				break;
			}
		}
	}
}

