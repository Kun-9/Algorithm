import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 장난꾸러기
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int  N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] temp;

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		temp = arr.clone();
		Arrays.sort(temp);

		int[] result = new int[2];

		int k = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] != temp[i]) {
				result[k] = i + 1;
				k++;
			}

			if (k == 2) {
				break;
			}
		}
		System.out.println(result[0] + " " + result[1]);
	}
}

