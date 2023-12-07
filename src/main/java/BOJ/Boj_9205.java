import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static Info goal;
	static ArrayList<Info> nodes;
	static HashSet<Info> check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Boolean> result = new ArrayList<>();

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			nodes = new ArrayList<>();
			check = new HashSet<>();
			flag = false;

			int n = Integer.parseInt(br.readLine());

			for (int j = 0; j < n + 2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int tempX = Integer.parseInt(st.nextToken());
				int tempY = Integer.parseInt(st.nextToken());

				nodes.add(new Info(tempX, tempY));
			}
			goal = nodes.get(nodes.size() - 1);

			DFS(nodes.get(0));
			result.add(flag);

			nodes.clear();
		}

		for (Boolean r : result) {
			System.out.println(r ? "happy" : "sad");
		}
	}

	static boolean flag;

	private static void DFS(Info currentNode) {
		if (flag) return;
		if (check.contains(currentNode)) return;
		if (currentNode.equals(goal)) {
			flag = true;
			return;
		}
		check.add(currentNode);

		int x = currentNode.getX();
		int y = currentNode.getY();

		for (Info toGo : nodes) {
			// 현재 거리보다 목표에서 더 멀어지는 경우는 가지 말아야 할까?
			// 돌아서 가는 경우도 있지 않을까?

			if (toGo.equals(currentNode)) continue;

			int toX = toGo.getX();
			int toY = toGo.getY();

			int length = Math.abs(toX - x) + Math.abs(toY - y);

			if (length <= 1000) {
				DFS(toGo);
			}
		}
	}

	private static class Info {
		int x;
		int y;
		public Info(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}
}

