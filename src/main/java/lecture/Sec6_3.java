import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 버블 정렬
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 삽입 정렬
		// 2번 index부터 들어갈 자리를 확인하고 교체
		for (int i = 1; i < N; i++) {
			int temp = arr[i];
			int count = i - 1;
			while (count >= 0 && arr[count] > temp) {
				arr[count + 1] = arr[count];
				count--;
			}
			arr[count + 1] = temp;
		}

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}

