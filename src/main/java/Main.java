import java.io.*;
import java.util.*;

public class Main {

	static int N;

//	static List<Integer> list;
	static int resultValue = Integer.MAX_VALUE;
	static int[] result = new int[2];
	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

//		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
//			int n = Integer.parseInt(st.nextToken());
//			list.add(n);
		}

		Arrays.sort(arr);
//		Collections.sort(list);

		solution();

		System.out.println(Math.min(result[0], result[1]) + " " + Math.max(result[0], result[1]));
	}

	public static void solution() {
		for (int i = 0; i < N; i++) {

//			int n = list.size();

			// 해당 인덱스 값 가져오기 및 제거
//			int target = list.get(0);
			int target = arr[i];
//			list.remove(0);

			// 결괏값을 담는 배열
			int[] tempArr = new int[2];
			search(i + 1, target, tempArr);

			if (Math.abs(tempArr[1]) < Math.abs(resultValue)) {
				resultValue = tempArr[1];
				result[0] = target;
//				result[1] = list.get(tempArr[0]);
				result[1] = arr[tempArr[0]];
			}

//			System.out.println(tempArr[0] + " " + tempArr[1]);
//			System.out.println(result[0] + " " + result[1]);
		}
	}

	public static void search(int left, int target, int[] tempArr) {
//		int left = 0;
		int right = N - 1;
		int result = Integer.MAX_VALUE;
		int key;
		int index = -1;

		while (left <= right) {
			key = (left + right) / 2;

//			int currentValue = list.get(key);
			int currentValue = arr[key];

			if (currentValue < -target) {
				int difVal = target + currentValue;

				if (Math.abs(difVal) < Math.abs(result)) {
					result = difVal;
					index = key;
				}
				left = key + 1;
			} else if (currentValue > -target) {
				int difVal = currentValue + target;

				if (Math.abs(difVal) < Math.abs(result)) {
					result = difVal;
					index = key;
				}
				right = key - 1;
			} else {
				index = key;
				break;
			}
		}

		tempArr[0] = index;
		tempArr[1] = result;
	}
}