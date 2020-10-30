import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teque {
    static int N;
    static List<Integer> front = new ArrayList<>();
    static List<Integer> back = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        for (int i = 0; i < N; i++) {
            String command = in.next();
            int id = command.length();
            int number = in.nextInt();
            switch (id) {
                case 9:
                    back.add(number);
                    if ((back.size() - front.size()) > 0 || (front.size() - back.size()) > 0) {
                        front.add(back.remove(0));
                    }
                    break;

                case 10:
                    front.add(0,number);
                    if (back.size() - front.size() == 2 || front.size() - back.size() == 2)
                        back.add(0,front.remove(front.size()-1));
                    break;
                case 11:
                    if (front.size() > back.size())
                        back.add(0,number);
                    else
                        front.add(number);

                    break;
                case 3:
                    if (number < front.size()) {
                        System.out.println(front.get(number));
                    } else {
                        System.out.println(back.get(number - front.size()));
                    }
                    break;
                }
            }
        }
    }


