import java.io.*;
import java.util.*;

// 통과
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 회의실 수
        int m = Integer.parseInt(st.nextToken()); // 예약된 회의 수

        // 회의실 정보 입력
        HashMap<String, Integer> list = new HashMap<String, Integer>();
        for(int i = 0; i < n; i++) {
            list.put(br.readLine(), i); // key: 이름, value: 지정 인덱스
        }
        List<String> keySet = new ArrayList<>(list.keySet());
        Collections.sort(keySet);

        // 각 회의실 예약 입력
        boolean[][] time = new boolean[n][19]; // [회의실 인덱스][시간]
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String roomName = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int roomIdx = list.get(roomName);
            for(int t = start; t < end; t++) {
                time[roomIdx][t] = true;
            }
        }

        // 빈 회의실 조회  
        for(int i = 0; i < n; i++) {
            String roomName = keySet.get(i);
            StringBuilder sb = new StringBuilder();
            int roomIdx = list.get(roomName);
            System.out.printf("Room %s:\n", roomName);
            int start = 9;
            int end = 0;
            int cnt = 0;
            boolean isChain = false; // 빈 시간대의 연속 여부
            for(int t = 9; t < 18; t++) {
                if(!time[roomIdx][t]) { // 예약이 없으면서
                    if(!isChain) { // 연속 빈회의실이 아니었던
                        isChain = true;
                        start = t;
                        end = start + 1;
                        cnt++;
                    } else { // 연속되는 중
                        end++;
                    }
                    if(end == 18) { // 마지막 시간일 때
                        String startStr = start < 10 ? "0".concat(Integer.toString(start)) : Integer.toString(start);
                        String endStr = end < 10 ? "0".concat(Integer.toString(end)) : Integer.toString(end);
                        sb.append(startStr).append("-").append(endStr).append("\n");
                    }
                } else if(time[roomIdx][t]) { // 예약이 있는데
                    if(isChain) { // 연속 빈회의실이었던
                        isChain = false;
                        String startStr = start < 10 ? "0".concat(Integer.toString(start)) : Integer.toString(start);
                        String endStr = end < 10 ? "0".concat(Integer.toString(end)) : Integer.toString(end);
                        sb.append(startStr).append("-").append(endStr).append("\n");
                    }
                    
                } 
                
            }
            if(cnt > 0) {
                System.out.printf("%d available:\n", cnt);
                System.out.print(sb.toString());
            } else {
                System.out.println("Not available");
            }
            if(i != n-1) {
                System.out.println("-----");
            }
        }
    }
}
