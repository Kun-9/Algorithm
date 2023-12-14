package lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// K번째 큰 수
public class Sec4_5 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Integer[] arr = new Integer[N];

		st = new StringTokenizer(br.readLine());

		// 배열 입력 받기
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Set<Integer> set = new HashSet<>();

		Arrays.sort(arr, Collections.reverseOrder());

		int currentSum = 0;
		int prevNumber = 0;

		// 2장 미리 뽑아 놓음
		for (int i = 0; i < 2; i++) {
			currentSum += arr[i];
		}

		int lt = 0;
		int mt = 1;
		int rt = 2;
		int type = 0;

		while (lt < N - 2) {

			// 한장을 선택
			for (int i = rt; i < N; i++) {
				if (arr[i] == prevNumber) continue;

				currentSum += arr[i];

				set.add(currentSum);

				prevNumber = arr[i];
				currentSum -= arr[i];
			}

			if (type++ % 2 == 0) {
				currentSum = currentSum - arr[mt++] + arr[rt++];
			} else {
				currentSum = currentSum - arr[lt] + arr[lt + 1];
				lt++;
			}
		}

		List<Integer> result = new ArrayList<>(set);

		result.sort(Comparator.reverseOrder());

		System.out.println(K > result.size() ? -1 : result.get(K - 1));
	}
}

