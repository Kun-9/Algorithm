package lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 교육과정 설계
public class Sec5_7 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String target = br.readLine();
		String str = br.readLine();

		Queue<Character> queue = new LinkedList<>();

		for (char c : target.toCharArray()) {
			queue.offer(c);
		}

		for (char c : str.toCharArray()) {
			if (queue.contains(c)) {
				if (queue.poll() != c) {
					break;
				}
			}
		}

		if (queue.isEmpty()) {
			System.out.print("YES");
		} else {
			System.out.print("NO");
		}
	}
}

