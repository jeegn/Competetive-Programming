import java.io.IOException;
import java.util.Stack;

public class EvenUpSolitaire {
    static int N;
    static Stack<Integer> notPaired = new Stack<>();

    public static void main(String[] args) throws IOException {
        Main.FastReader in = new Main.FastReader();
        N = in.nextInt();
        notPaired.push(in.nextInt());
        for (int i = 1; i < N; i++) {
            int card = in.nextInt();

            if (notPaired.size() > 0 && (card + notPaired.peek()) % 2 == 0)
                notPaired.pop();
            else
                notPaired.push(card);
        }
        System.out.println(notPaired.size());
    }
}
