import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class MarblesOnaTree {
    public static void main(String[] args) throws IOException {

        Main.FastReader in = new Main.FastReader();

        while (true) {
             int N = in.nextInt();
             if (N == 0)
                 break;
            int[] marbles = new int[N + 1];
            int[] parent = new int[N + 1];
            int[] degree = new int[N + 1];
            Queue<Integer> leaves = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                int u = in.nextInt();
                int m = in.nextInt();
                int d = in.nextInt();
                marbles[u] = m;
                degree[u] = d;
                if (d == 0)
                    leaves.add(u);
                for (int k=0; k<d; k++) {
                    int v = in.nextInt();
                    parent[v] = u;
                }
            }
            int steps = 0;
            while (!leaves.isEmpty()) {
                int leaf = leaves.remove();
                int p = parent[leaf];
                degree[p]--;
                if (degree[p] == 0)
                    leaves.add(p);
                int m = marbles[leaf];
                marbles[p] += (m-1);
                steps += Math.abs(m - 1);
            }
            System.out.println(steps);
        }
    }
}
