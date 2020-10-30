import java.io.IOException;

public class NumberOnaTree {
    static int H;
    static String path;
    public static void main(String[] args) throws IOException {
        Main.FastReader in = new Main.FastReader();
        path = in.nextLine();
        int space = path.indexOf(" ");
        //System.out.println(space);
        int node = 1;
        int length = path.length();
        if (space == 1) {
            H = path.charAt(0) - 47;
            if (length <= 2) {
                System.out.println((1 << H) - 1);
                return;
            }
            for (int i = 2; i < length; i++) {
                node *= 2;
                if (path.charAt(i) == 'R')
                    node++;
            }
        }
        else {
            H = path.charAt(0) - 48;
            H *= 10;
            H += path.charAt(1) -47;
            if (length <= 3) {
                System.out.println((1 << H) - 1);
                return;
            }

            for(int i = 3; i < length; i++) {
                if (path.charAt(i) == ' ')
                    continue;
                node *= 2;
                if (path.charAt(i) == 'R')
                    node++;
            }
        }


        System.out.println((1 << H) - node);
    }
}
