import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arrSet = new int[M + 1];

		int result = 0;

		List<List<Integer>> switchList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			List<Integer> list = new ArrayList<>();

			for (int j = 0; j < num; j++) {
				Integer object = Integer.valueOf(st.nextToken());
				list.add(object);
				arrSet[object]++;
			}
			switchList.add(list);
		}

		// 초과된 번호
		List<Integer> arr = new ArrayList<>();

		for (int i = 1; i < arrSet.length; i++) {
			if (arrSet[i] > 1) {
				arr.add(i);
			}
		}

		for (List<Integer> integers : switchList) {
			boolean flag = true;

			for (Integer integer : integers) {
				if (!arr.contains(integer)) {
					flag = false;
					break;
				}
			}

			if (flag) {
				result = 1;
				break;
			}
		}

		System.out.print(result);
	}
}