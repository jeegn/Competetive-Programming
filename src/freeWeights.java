import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class freeWeights {
    static int n;
    static int setPairs = 0;
    static int[] rack1;
    static int[] rack2;
    static int[] weights;
    static HashMap<Integer,Boolean> adjacent = new HashMap<>();
    static boolean maxCheck(int maxWeight) {
        int[] row1 = rack1.clone();
        int[] row2 = rack2.clone();

        if (maxWeight == weights[n - 1])
            return true;
        for (int i = n; i < 2*n; i++) {
            int w1 = row1[i];
            if (w1 <= maxWeight)
                continue;
            if (i == (2*n - 1))
                return false;
            for (int j = i + 1; j < 2*n; j++) {
                int w2 = row1[j];
                if (w2 == w1) {
                    row1[j] = 0;
                    break;
                }
                if (j == (2*n - 1))
                    return false;
                if (w2 > maxWeight)
                    return false;
            }
        }
        for (int i = n; i < 2*n; i++) {
            int w1 = row2[i];
            if (w1 <= maxWeight)
                continue;
            if (i == (2*n -1))
                return false;
            for (int j = i + 1; j < 2*n; j++) {
                int w2 = row2[j];
                if (w2 == w1) {
                    row2[j] = 0;
                    break;
                }
                if (j == (2*n - 1))
                    return false;
                if (w2 > maxWeight)
                    return false;
            }
        }
        return true;
    }
    static int bisection(int low, int high) {
        if (low == high)
            return weights[low];
        if (low + 1 == high) {
            if(maxCheck(weights[low]))
                return weights[low];
            else
                return weights[high];
        }
        int mid = low/2 + high/2;
        if (maxCheck(weights[mid]))
            return bisection(low, mid);
        else
            return bisection(mid + 1, high);
    }
    public static void main(String[] args) throws IOException {
        Main.FastReader in = new Main.FastReader();
        n = in.nextInt();
        rack1 = new int[3*n];
        rack2 = new int[3*n];
        weights = new int[n];
        int weightsCounter = 0;
        for (int i = 0; i < n; i++) {
            int weight = in.nextInt();
            rack1[n + i] = weight;
            if (!adjacent.containsKey(weight)) {
                weights[weightsCounter] = weight;
                weightsCounter++;
                adjacent.put(weight, false);
            }
            if (i > 0) {
                if (rack1[n + i - 1] == weight) {
                    adjacent.put(weight, true);
                    setPairs++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int weight = in.nextInt();
            rack2[n + i] = weight;
            if (!adjacent.containsKey(weight)) {
                weights[weightsCounter] = weight;
                weightsCounter++;
                adjacent.put(weight, false);
            }
            if (i > 0) {
                if (rack2[n + i - 1] == weight) {
                    adjacent.put(weight, true);
                    setPairs++;
                }
            }
        }
        Arrays.sort(weights);
        if (setPairs == n)
            System.out.println(0);
        else {
            int ans = bisection(0, n - 1);
            System.out.println(ans);
        }
    }
}
