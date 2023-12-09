import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		int[] result = new int[N];

		Map<Integer, Integer> map = new HashMap<>();

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 첫번째 배열 입력
		for (int i = 0; i < M; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		int currentSize = map.size();
		result[0] = currentSize;

		// 다음 배열
		for (int lp = 0, rp = M; rp < N; rp++, lp++) {
			// 같은 수 라면 스킵
			if (arr[lp] == arr[rp]) {
				result[lp + 1] = currentSize;
				continue;
			}

			// 좌측 인덱스 제외
			// 좌측 인덱스를 제외하면 0이 될 때, 해당 키를 삭제
			int lpValue = map.get(arr[lp]);
			int rpValue = map.getOrDefault(arr[rp], 0);

			if (lpValue == 1) {
				map.remove(arr[lp]);
				currentSize--;
			} else {
				map.put(arr[lp], --lpValue);
			}

			if (rpValue == 0) currentSize++;

			map.put(arr[rp], ++rpValue);

			result[lp + 1] = currentSize;
		}

		Arrays.stream(result).filter(a -> a > 0)
				.mapToObj(a -> a + " ")
				.forEach(System.out::print);
	}
}

