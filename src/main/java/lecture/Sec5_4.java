package lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 후위식 연산
public class Sec5_4 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();

		Stack<Integer> stack = new Stack<>();

		for (char c : str.toCharArray()) {
			if (Character.isDigit(c)) {
				stack.push(Character.getNumericValue(c));
			} else {
				int a = stack.pop();
				int b = stack.pop();
				int result = 0;

				switch (c) {
					case '-':
						result = b - a;
						break;
					case '+':
						result = b + a;
						break;
					case '*':
						result = b * a;
						break;
					case '/':
						result = b / a;
						break;
				}
				stack.push(result);
			}
		}

		System.out.print(stack.pop());
	}
}

