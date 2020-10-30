import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class HorrorList {
    static ArrayList<Integer>[] adjList;
    static int[] movieScores;
    static int[] horrorMovies;
    static int N;
    static int H;
    static int L;

    public static void read() throws IOException {
        Main.FastReader in = new Main.FastReader();
        N = in.nextInt();
        adjList = new ArrayList[N];
        movieScores = new int[N];
        for (int i = 0; i < N; i++) {
            movieScores[i] = Integer.MAX_VALUE;
            adjList[i] = new ArrayList<Integer>();
        }
        H = in.nextInt();
        horrorMovies = new int[H];
        L = in.nextInt();
        for (int i = 0; i < H; i++) {
            int j = in.nextInt();
            horrorMovies[i] = j;
            movieScores[j] = 0;
        }
        for (int i = 0; i < L; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            adjList[u].add(v);
            adjList[v].add(u);
        }
    }
    public static void bfs(int i) {
        Queue<ArrayList<Integer>> q = new ArrayDeque<>();
        Queue<Integer> indexQ = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        indexQ.add(i);
        q.add(adjList[i]);
        visited[i] = true;
        while (!q.isEmpty()) {
            ArrayList<Integer> list = q.remove();
            int score = movieScores[indexQ.remove()];
            for (int movieIndex : list) {
                if (!visited[movieIndex]) {
                    if (movieScores[movieIndex] > score + 1) {
                        movieScores[movieIndex] = score + 1;
                    }
                    visited[movieIndex] = true;
                    q.add(adjList[movieIndex]);
                    indexQ.add(movieIndex);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        read();
        for (int horrorMovie : horrorMovies) {
            bfs(horrorMovie);
        }
        int maxIndex = 0;
        for (int i = 1; i < N; i++) {
            if (movieScores[i] > movieScores[maxIndex])
                maxIndex = i;
        }
        System.out.println(maxIndex);
    }
}

