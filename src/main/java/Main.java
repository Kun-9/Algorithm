import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 개행이 없는 문자열을 읽고 .으로 시작한다면 멈춰야한다.
public class Main {

	static int N, M;
	static int[] numSet;
	static ArrayList<Integer>[] list;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());

		numSet = new int[M + 1];
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = stoi(st.nextToken());
			for (int j = 0; j < num; j++) {
				int temp = stoi(st.nextToken());
				list[i].add(temp);
				numSet[temp]++;
			}
		}

		for (int i = 1; i <= N; i++) {
			if (isPossible(i)) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);

	}

	private static boolean isPossible(int index) {
		boolean flag = true;
		for (int num : list[index]) {
			numSet[num]--;
			if (numSet[num] <= 0) {
				flag = false;
			}
		}
		for (int num : list[index]) {
			numSet[num]++;
		}
		return flag;
	}

	private static int stoi(String input) {
		return Integer.parseInt(input);
	}
}

