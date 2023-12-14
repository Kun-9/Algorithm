package lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sec5_1 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		// 올바른 괄호
		// ( 가 먼저 나오고 )의 수가 앞서 나온 (의 갯수를 초과하면 안된다.
		int currentBasketCount = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				// '(' 일 때
				currentBasketCount++;
			} else {
				// ')' 일 때
				if (currentBasketCount == 0) {
					System.out.println("NO");
					return;
				}
				currentBasketCount--;
			}
		}

		System.out.print(currentBasketCount == 0 ? "YES" : "NO");
	}
}

