package lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Sec8_6 {
	// 8_6

	static Integer[] arr;
	static int target;

	static int[] result;
	static List<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st1.nextToken());
		target = Integer.parseInt(st1.nextToken());

		arr = new Integer[N];
		result = new int[target];
		list = new ArrayList<>();


		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.valueOf(st2.nextToken());
		}

		solution();

	}

	private static void solution() {
		DFS(0);
	}

	private static void DFS(int index) {
		if (index == target) {
			for (int i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		for (Integer integer : arr) {

			if (list.contains(integer)) continue;

			if (list.size() == index + 1) {
				list.set(index, integer);
			} else {
				list.add(integer);
			}

			DFS(index + 1);
		}
		list.remove(index);
	}
}
