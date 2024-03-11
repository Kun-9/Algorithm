import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{

		String[] str = {
				"team_name : MyTeam" +
				" application_name : YourApp" +
				" error_level : info" +
				" message  : Index"
		};
		String[] arr = {"team_name", "application_name", "error_level", "message"};
		int len = str.length;

		String target;
		int cnt = 0;

		for (int i = 0; i < len; i++) {

			boolean flag = false;
			target = str[i];

			int logLen = 0;
			int beforeLen = target.length();

			StringTokenizer st = new StringTokenizer(target, " ");

			if (st.countTokens() != 12 || target.length() > 100) {
				cnt++;
				continue;
			}

			loop:
			for (int j = 0; j < 4; j++) {
				String head = st.nextToken();
				String mid = st.nextToken();
				String content = st.nextToken();

				logLen += head.length();
				logLen += content.length();

				if (!mid.equals(":")) {
					flag = true;
					break;
				}

				if (!arr[j].equals(head)) {
					flag = true;
					break;
				} else {
					for (char c : content.toCharArray()) {
						if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
							flag = true;
							break loop;
						}
					}
				}
			}

			if (beforeLen - logLen != 15) flag = true;

			if (flag) cnt++;



			System.out.println("beforeLen = " + beforeLen);
			System.out.println("logLen = " + logLen);
		}

		System.out.println(cnt);
	}

}

//import java.io.*;
//import java.util.*;
//
//public class Main {
//
//	static int maxValue;
//	static List<Event> eventList;
//	static int remainMoney;
//	static int[] check;
//
//	public static void main(String[] args) throws IOException{
//
//		String[] events = {"10 x2", "5 +100", "20 +200", "100 x3", "80 x2"};
//		check = new int[events.length];
//		remainMoney = 100;
//
//		eventList = new ArrayList<>();
//
//		for (int i = 0; i < events.length; i++) {
//			String target = events[i];
//			StringTokenizer st = new StringTokenizer(target, " ");
//			int cost = Integer.parseInt(st.nextToken());
//			String howAndValue = st.nextToken();
//			String how = howAndValue.substring(0, 1);
//			int value = Integer.parseInt(howAndValue.substring(1));
//
//			eventList.add(new Event(i, cost, how, value));
//		}
//
//		DFS(500);
//
//
//		System.out.println(maxValue);
//	}
//
//	private static void DFS(int eventMoney) {
//
//		System.out.println("remainMoney : " + remainMoney);
//		System.out.print(eventMoney + " ");
//
////		List<Integer> integers = map.getOrDefault(r, new ArrayList<>());
//		maxValue = Math.max(maxValue, eventMoney);
//
//
//		for (Event event : eventList) {
//
//			int cost = event.cost;
//			if (remainMoney < cost || check[event.number] == 1) continue;
//
//			remainMoney -= cost;
//			check[event.number] = 1;
//
//			DFS(event.calculate(eventMoney));
//
//			remainMoney += cost;
//			check[event.number] = 0;
//		}
//	}
//
//	private static class Event {
//		private int number;
//		private int cost;
//		private String how;
//		private int value;
//
//		public Event(int number, int cost, String how, int value) {
//			this.number = number;
//			this.cost = cost;
//			this.how = how;
//			this.value = value;
//		}
//
//		public int calculate(int money) {
//
//			if (how.equals("+")) {
//				return money + value;
//			} else {
//				return money * value;
//			}
//		}
//	}
//}