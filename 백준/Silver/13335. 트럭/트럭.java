import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken()); // 트럭 수
		int w = Integer.parseInt(st.nextToken()); // 다리 길이
		int L = Integer.parseInt(st.nextToken()); // 최대 하중
		
		Queue<Integer> truck = new LinkedList<>(); // 트럭 무게
		Queue<Integer> bridge = new LinkedList<>(); // 다리 위 
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			truck.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < w; i++) {
			bridge.add(0);
		}
		
		int time = 0;
		int weight = 0; // 다리 위 누적 무게
		while(!bridge.isEmpty()) {
			weight -= bridge.poll();
			if(!truck.isEmpty()) {
				int next = truck.peek();
				if(weight + next <= L) { // 건널 수 있음
					weight += next;
					truck.poll();
					bridge.add(next);
				} else {
					bridge.add(0);
				}
			}
			time++;
		}
		
		System.out.println(time);
	}

}