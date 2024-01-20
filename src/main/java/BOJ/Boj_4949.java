package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//
public class Boj_4949 {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();

		String result = "yes";



		StringBuilder str = new StringBuilder();


		loop:
		while (true) {
			char a;
			while ((a = (char) br.read()) != '\n') {
				str.append(a);
				if (str.toString().equals(".")) {
					break loop;
				}
			}

			char[] charArray = str.toString().toCharArray();
			for (char c : charArray) {
				if (c == '[' || c == '(') {
					stack.push(c);
				} else if (c == ']' || c == ')') {
					if (stack.isEmpty()) {
						result = "no";
						break;
					}

					if (c == ']') {
						if (stack.pop() != '[') {
							result = "no";
							break;
						}
					} else {
						if (stack.pop() != '(') {
							result = "no";
							break;
						}
					}
				}
			}

			if (!stack.isEmpty()) result = "no";
			System.out.println(result);

			str.setLength(0);
			result = "yes";
			stack.clear();

		}
	}
}

