package lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 모든 아나그램 찾기
public class Sec4_4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();
		String T = br.readLine();

		Map<Character, Integer> map = new HashMap<>();
		Map<Character, Integer> target = new HashMap<>();

		for (int i = 0; i < T.length(); i++) {
			char value = T.charAt(i);
			target.put(value, target.getOrDefault(value, 0) + 1);
		}

		for (int i = 0; i < T.length() - 1; i++) {
			char value = S.charAt(i);
			map.put(value, map.getOrDefault(value, 0) + 1);
		}

		int cnt = 0;


		for (int lt = 0, rt = T.length() - 1; rt < S.length(); lt++, rt++) {
			// rt 값 삽입
			char inputValue = S.charAt(rt);
			map.put(inputValue, map.getOrDefault(inputValue, 0) + 1);

			// 값 비교 후 카운트
			if (map.equals(target)) cnt++;

			// lt 값 제거
			char outputValue = S.charAt(lt);
			if (map.get(outputValue) == 1) map.remove(outputValue);
			else map.put(outputValue, map.getOrDefault(outputValue, 0) - 1);
		}

		System.out.print(cnt);
	}
}

