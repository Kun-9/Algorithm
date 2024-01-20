package lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//
public class Sec9_6_Dijstra {

	static class Node implements Comparable<Node> {
		int value;
		int cost;

		public Node(int value, int cost) {
			this.value = value;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node node) {
			return cost - node.cost;
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

		nodeMap = new HashMap<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			List<Node> list = nodeMap.getOrDefault(start - 1, new ArrayList<>());
			list.add(new Node(end - 1, cost));

			nodeMap.put(start - 1, list);
		}

		int[] dis = new int[M];

		PriorityQueue<Node> queue = new PriorityQueue<>();

		int v = 0;
		queue.offer(new Node(v, 0));
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[v] = 0;

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int value = node.value;
			int cost = node.cost;

			if (cost > dis[value]) continue;

			for (Node nd : nodeMap.getOrDefault(value, new ArrayList<>())) {
				int newCost = cost + nd.cost;
				if (dis[nd.value] > newCost) {
					dis[nd.value] = newCost;
					queue.offer(new Node(nd.value, newCost));
				}
			}
		}

		for (int i = 1; i < M; i++) {
			System.out.println(i + 1 + " : " + (dis[i] == Integer.MAX_VALUE ? "impossible" : dis[i]));
		}


	}
}

