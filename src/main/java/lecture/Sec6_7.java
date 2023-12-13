import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 좌표 정렬
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int  N = Integer.parseInt(br.readLine());


		int[][] arr = new int[N][2];


		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			arr[i][0] = x;
			arr[i][1] = y;
		}

		Arrays.sort(arr, (o1, o2) -> {
			int result = o1[0] - o2[0];
			if (result == 0) {
				return o1[1] - o2[1];
			}
			return result;
		});

		for (int[] ints : arr) {
			System.out.println(ints[0] + " " + ints[1]);
		}
	}
}

