import java.io.IOException;
import java.util.ArrayList;

public class Molekule {

    static int N;
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] visited;
    static int[][] edges;
    public static void dfs(int node, int direction) {
        visited[node] = true;
        for (int e : adj.get(node)) {
            if (edges[e][2] != 0)
                continue;
            int source = edges[e][0];
            int dest = edges[e][1];
            int next;
            boolean b = (source == node);
            if (b)
                next = dest;
            else
                next = source;
            if (!visited[next]) {
                if (direction == 2) {
                    edges[e][2] = 1;
                    if (!b)
                        edges[e][3] = 1;
                    dfs(next,1);
                }
                else {
                    edges[e][2] = 2;
                    if (b)
                        edges[e][3] = 1;
                    dfs(next,2);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Main.FastReader in = new Main.FastReader();
        N = in.nextInt();
        adj = new ArrayList<ArrayList<Integer>>(N);
        for (int i=0; i<N; i++) adj.add(new ArrayList<Integer>());
        edges = new int[N-1][4]; // array of edges (u,v,direction)
        for (int i=0; i<N-1; i++) {  // reading i-th edge
            edges[i][0] = in.nextInt()-1;
            edges[i][1] = in.nextInt()-1;
            adj.get(edges[i][0]).add(i);
            adj.get(edges[i][1]).add(i);
        }
        visited = new boolean[N];
        dfs(0, 2);
        for (int i = 0; i < N - 1; i++) {
            System.out.println(edges[i][3]);
        }
    }
}
