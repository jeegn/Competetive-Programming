import java.io.IOException;

public class Pivot {
    static int n;
    static int[][] a;
    static int pivotCount;
    public static void read() throws IOException {
        Main.FastReader in = new Main.FastReader();
        n = in.nextInt();
        a = new int[3][n];
        int max = -1;
        for (int i = 0; i < n; i++) {
            int j = in.nextInt();
            a[0][i] = j;
            if (j > max) {
                max = j;
            }
                a[1][i] = max;
        }
        int min = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            int j = a[0][i];
            if (j < min) {
                min = j;
            }
            a[2][i] = min;
        }
    }
    public static void pivotCheck() {
        for (int i = 0; i < n; i++) {
            if ((a[0][i] >= a[1][i]) && (a[0][i] <= a[2][i]))
                pivotCount++;
        }
    }
    public static void main(String[] args) throws IOException {
        read();
        pivotCheck();
        System.out.println(pivotCount);
    }
}
