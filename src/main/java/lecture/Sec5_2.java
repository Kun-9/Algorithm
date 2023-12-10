import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 괄호 문자 제거
public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();

		Stack<Character> stack = new Stack<>();

		// 괄호 사이의 문자를 제거.
		for (Character c : str.toCharArray()) {
			if (c == '(') {
				stack.push('(');
			} else if (c == ')') {
				stack.pop();
			} else {
				// 문자가 나온 상황
				// 괄호 안에 있다면 출력하지 않는다.
				if (stack.isEmpty()) {
					sb.append(c);
				}
			}
		}

		System.out.print(sb);
	}
}

