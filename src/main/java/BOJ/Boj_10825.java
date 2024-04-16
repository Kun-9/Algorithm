package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_10825 {

	static int N;
	static List<St> arr;


	private static void input() throws IOException {
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		String name;
		int ko, en, ma;

		arr = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			name = st.nextToken();
			ko = Integer.parseInt(st.nextToken());
			en = Integer.parseInt(st.nextToken());
			ma = Integer.parseInt(st.nextToken());

			arr.add(new St(name, en, ko, ma));
		}
	}


	public static void main(String[] args) throws IOException {
		// 국어 점수 내림차순
		// 국어 점수 같으면 영어 점수 오름차순
		// 국어 점수, 영어 점수 같으면 수학 점수 내림차순
		// 모든 점수가 같으면 이름이 사전순으로 증가 = 오름차순

		input();

		arr.sort((o1, o2) -> {
			// 국어점수가 같지 않으면 내림차순
			if (o1.getKorean() != o2.getKorean()) return o2.getKorean() - o1.getKorean();

			// 영어점수가 같지 않으면 오름차순
			if (o1.getEnglish() != o2.getEnglish()) return o1.getEnglish() - o2.getEnglish();

			// 수학점수가 같지 않으면 내림차순
			if (o1.getMath() != o2.getMath()) return o2.getMath() - o1.getMath();

			// 모두 같으면 오름차순
			return o1.getName().compareTo(o2.getName());
		});

		for (St st : arr) {
			System.out.println(st.getName());
		}


	}
}

class St {
	private String name;
	private int english;
	private int korean;
	private int math;

	public St(String name, int english, int korean, int math) {
		this.name = name;
		this.english = english;
		this.korean = korean;
		this.math = math;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() {
		return "St{" +
				"name='" + name + '\'' +
				", english=" + english +
				", korean=" + korean +
				", math=" + math +
				'}';
	}
}