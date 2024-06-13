package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_15970 {

	static int N;
	static int result = 0;
	static List<Node> list;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		list = new ArrayList<>();

		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int pos = Integer.parseInt(st.nextToken());
			int color = Integer.parseInt(st.nextToken());
			list.add(new Node(color, pos));
		}

		solution();

	}

	public static void solution() {
		Collections.sort(list);

		Node tempNode = null;

		for (int i = 0; i < N; i++) {
			Node currentNode = list.get(i);

			int curColor = currentNode.getColor();
			int curPos = currentNode.getPos();

			int temp = -1;

			if (i - 1 >= 0) {
				tempNode = list.get(i - 1);
				if (tempNode.getColor() == curColor) {
					temp = curPos - tempNode.getPos();
				}
			}

			if (i + 1 < N) {
				tempNode = list.get(i + 1);
				if (tempNode.getColor() == curColor) {
					int val = tempNode.getPos() - curPos;

					if (temp != -1) {
						temp = Math.min(temp, val);
					} else {
						temp = val;
					}
				}
			}

			result += temp;
		}

		System.out.println(result);
	}

	static class Node implements Comparable<Node> {
		private int color;
		private int pos;


		public Node(int color, int pos) {
			this.color = color;
			this.pos = pos;
		}

		public int getColor() {
			return color;
		}

		public void setColor(int color) {
			this.color = color;
		}

		public int getPos() {
			return pos;
		}

		public void setPos(int pos) {
			this.pos = pos;
		}


		@Override
		public int compareTo(Node node) {
			if (node.color != color) {
				return color - node.color;
			}

			return pos - node.pos;
		}

		@Override
		public String toString() {
			return "Node{" +
					"color=" + color +
					", pos=" + pos +
					'}';
		}
	}
}