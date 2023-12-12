import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int  N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] arr = new int[N];

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			if (list.contains(arr[i])) {
				System.out.println("D");
				return;
			}
			list.add(arr[i]);
		}

		System.out.print("U");

	}
}

