import java.io.IOException;
import java.util.HashMap;

public class MemoryMatch {
    static int N;
    static int K;
    static int[] cardStatus;
    static int halfOpen = 0;
    static int closed = 0;
    static int opened = 0;
    static int openPairs = 0;
    static int possiblePairs = 0;
    static int maxPairs = 0;
    static HashMap <String, Integer> memory = new HashMap<>();
    public static void main(String[] args) throws IOException {
        Main.FastReader in = new Main.FastReader();
        N = in.nextInt();
        K = in.nextInt();
        cardStatus = new int[N + 1];
        for (int i = 0; i < K; i++) {
            int c1 = in.nextInt();
            int c2 = in.nextInt();
            String p1 = in.next();
            String p2 = in.next();
            if (memory.get(p1) == null) {
                memory.put(p1, 1);
                cardStatus[c1] = 1;
                opened++;
            }
            else if (memory.get(p1) == 1 && cardStatus[c1] == 0) {
                memory.put(p1, 2);
                possiblePairs++;
                opened++;
            }
            if (memory.get(p2) == null) {
                memory.put(p2, 1);
                cardStatus[c2] = 1;
                opened++;
            }
            else if (memory.get(p2) == 1 && cardStatus[c2] == 0) {
                memory.put(p2, 2);
                possiblePairs++;
                opened++;
            }
            if (p1.compareTo(p2) == 0) {
                openPairs++;
            }

        }
        maxPairs = possiblePairs - openPairs;
        halfOpen = opened - 2*possiblePairs;
        closed = N - opened;
        if (closed == 2) {
            if (halfOpen == 0)
                maxPairs += 1;
            if (halfOpen == closed)
                maxPairs += 2;
        }
        if (halfOpen == closed && closed != 2) {
            maxPairs += halfOpen;
        }
        System.out.println(maxPairs);
    }
}
