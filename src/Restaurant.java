import java.io.IOException;

public class Restaurant {
    static int N;
    static int pile1 = 0;
    static int pile2 = 0;

    public static void main(String[] args) throws IOException {
        Main.FastReader in = new Main.FastReader();
        N = in.nextInt();
        while (N != 0) {
            for (int i = 0; i < N; i++) {
                String command = in.next();
                int plates = in.nextInt();
                if (command.charAt(0) == 'D') {
                    pile2 += plates;
                    System.out.println("DROP 2 " + plates);
                }
                else {
                    if (plates <= pile1) {
                        pile1 -= plates;
                        System.out.println("TAKE 1 " +plates);
                    }
                    else {
                        int difference = plates - pile1;
                        if (pile1 != 0) {
                            System.out.println("TAKE 1 " + pile1);
                            pile1 = 0;
                        }
                        pile1 += pile2;
                        System.out.println("MOVE 2->1 " +pile2);
                        pile2 = 0;
                        pile1 -= difference;
                        System.out.println("TAKE 1 " + difference);
                    }
                }
            }
            N = in.nextInt();
            pile1 = 0;
            pile2 = 0;
            System.out.println();
        }
    }
}
