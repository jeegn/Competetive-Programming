import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class BirdRescue {
    static int n;
    static int q;
    static int xa;
    static int ya;
    static int[] totalDistances = new int[2000001];
    static Main.FastReader in = new Main.FastReader();
    public static void processDistances() throws IOException {
        n = in.nextInt();
        q = in.nextInt();
        xa = in.nextInt();
        ya = in.nextInt();
        for (int i = 0; i < n; i++) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            ArrayList<Integer> friendDistances = new ArrayList<>();
            if (x1 > x2) {
                int c = x2;
                x2 = x1;
                x1 = c;
            }
            if (y1 > y2) {
                int c = y2;
                y2 = y1;
                y1 = c;
            }
            friendDistances.add(Math.abs(x1 - xa) + Math.abs(y1 - ya));
            friendDistances.add(Math.abs(x2 - xa) + Math.abs(y2 - ya));
            friendDistances.add(Math.abs(x1 - xa) + Math.abs(y2 - ya));
            friendDistances.add(Math.abs(x2 - xa) + Math.abs(y1 - ya));
            if ((x1 <= xa ) && (xa <= x2) && (y1 <= ya ) && (ya <= y2)) {
                friendDistances.add(0);
            }
            if ((x1 <= xa ) && (xa <= x2)) {
                friendDistances.add(Math.abs(y1 - ya));
                friendDistances.add(Math.abs(y2 - ya));
            }
            if ((y1 <= ya ) && (ya <= y2)) {
                friendDistances.add(Math.abs(x1 - xa));
                friendDistances.add(Math.abs(x2 - xa));
            }
            Collections.sort(friendDistances);
            int min = friendDistances.get(0);
            int max = friendDistances.get(friendDistances.size() - 1);
            if (min <= 2000001) {
                totalDistances[min]++;
            }
            if (max < 2000001) {
                totalDistances[max + 1]--;
            }
        }
    }
    public static void processQueries() throws IOException {
        for (int i = 0; i < q; i++) {
            int queries = in.nextInt();
            System.out.println(totalDistances[queries]);
        }
    }

    public static void main(String[] args) throws IOException {
        processDistances();
        int sum = 0;
        for (int i = 0; i < totalDistances.length; i++) {
            sum += totalDistances[i];
            totalDistances[i] = sum;
        }
        processQueries();
    }
}
