
import java.util.*;

public class Main {

static ArrayList<ArrayList<Integer>> graph = new ArrayList();

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] time = new int[N + 1];

    int[] edgeCount = new int[N + 1];

    for (int i = 0; i < N + 1; i++) {
        graph.add(new ArrayList<Integer>());
    }
    for (int i = 1; i <= N; i++) {
        int t = sc.nextInt();
        int k = sc.nextInt();
        time[i] = t; // 해당 노드가 걸리는 시간

        for (int j = 0; j < k; j++) {
            int from = sc.nextInt(); // 선행되어야하는 작업
            graph.get(from).add(i);
            edgeCount[i] += 1;
        }
    }

    int[] ans = new int[N + 1];
    Queue<Integer> q = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
        if (edgeCount[i] == 0) {
            q.offer(i);
            ans[i] = time[i];
        }
    } // 선행되어야할게 없는 노드 부터 넣기

    while (!q.isEmpty()) {
        int current = q.poll();
        ArrayList<Integer> list = graph.get(current);

        for (int i = 0; i < list.size(); i++) {
            int next = list.get(i);
            edgeCount[next]--;
            if (edgeCount[next] == 0) {
                q.offer(next);
                ans[next] = Math.max(time[next] + ans[current], ans[next]);
            }
        }
        System.out.println(Arrays.toString(edgeCount));
//        System.out.println(current);
//        System.out.println(Arrays.toString(ans));
    }
    int ansMax = Integer.MIN_VALUE;
    for (int i = 1; i <= N; i++) {
        if (ansMax < ans[i])
            ansMax = ans[i];
    }
    System.out.println(ansMax);
}
}