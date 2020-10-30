import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class FinancialPlanning {
    static int n;
    static long M;
    static long[][] investments;
    static double [][] returnRatio;
    static boolean minCheck (int days) {
        if (returnRatio[0][1] >= days)
            return false;
        long profitCombined = 0;
        for (int i = 0; i < n; i++) {
            int index = (int) returnRatio[i][0];
            long profit = ((days * investments[(int)index][0]) - investments[(int)index][1]);
            if (profit >= M)
                return true;
            profitCombined += profit;
            if (profitCombined >= M)
                return true;
        }
        return false;
    }
    static int bisection(int low, int high) {
        if (low == high)
            return low;
        if (low + 1 == high) {
            if(minCheck(low))
                return low;
            else
                return high;
        }
        int mid = low/2 + high/2;
        if (minCheck(mid))
            return bisection(low, mid);
        else
            return bisection(mid + 1, high);
    }
    public static void main(String[] args) throws IOException {
        Main.FastReader in = new Main.FastReader();
        n = in.nextInt();
        M = in.nextLong();
        investments = new long[n][2];
        returnRatio = new double[n][2];
        for (int i = 0; i < n; i++) {
            long profit = in.nextInt();
            long cost = in.nextInt();
            investments[i][0] = profit;
            returnRatio[i][0] = i;
            investments[i][1] = cost;
            returnRatio[i][1] = (double) cost/profit;
        }
        Arrays.sort(returnRatio, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                Double rr1 = o1[1];
                Double rr2 = o2[1];
                return rr1.compareTo(rr2);
            }
        });
        int rr = (int)returnRatio[0][1];
        int ans = bisection(rr, Integer.MAX_VALUE);
        System.out.println(ans);
    }
}
