package lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 쇠막대기
public class Sec5_5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		Stack<Integer> stack = new Stack<>();
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c == '(') {
				stack.push(i);
				count++;
			} else {
				Integer pop = stack.pop();
				if (pop + 1 == i) {
					// 레이저
					count--;
					count += stack.size();
				}
			}
		}

		System.out.print(count);
	}
}

