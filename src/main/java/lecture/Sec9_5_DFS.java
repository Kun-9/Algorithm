package lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//
public class Sec9_5_DFS {

	static class Node {
		int value;
		int cost;

		public Node(int value, int cost) {
			this.value = value;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Node{" +
					"value=" + value +
					", cost=" + cost +
					'}';
		}
	}

	static Map<Integer, List<Node>> nodeMap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] check = new int[M + 1];
		nodeMap = new HashMap<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			List<Node> list = nodeMap.getOrDefault(start, new ArrayList<>());
			list.add(new Node(end, value));

			nodeMap.put(start, list);
		}


//		for (Integer i : nodeMap.keySet()) {
//			System.out.println(i + " : " + nodeMap.get(i));
//		}

//		DFS(4, 1, 0, check);
//		System.out.println(min);

		for (int i = 2; i <= M; i++) {
			DFS(i, 1, 0, check);

			System.out.println(i + " : " + (min == Integer.MAX_VALUE ? "impossible" : min));
			min = Integer.MAX_VALUE;
			check = new int[M + 1];
		}


	}


	int result = 0;
	static int min = Integer.MAX_VALUE;
	static void DFS(int target, int current, int cost, int[] check) {

		if (current == target) {
			min = Math.min(min, cost);
			return;
		}
		check[current] = 1;

		List<Node> nodes = nodeMap.get(current);

		if (nodes == null) return;

		for (Node node : nodes) {
			int value = node.value;
			if (check[value] != 1) {
				DFS(target, value, cost + node.cost, check);
				check[value] = 0;
			}

		}
	}
}

