import java.io.*;

public class GettingGold{
    static int goldCount = 0;
    static char[][] puzzle;
    static boolean[][] visited;
    static int row;
    static int col;
    static int startRow;
    static int startCol;
    public static char[][] read() throws IOException {
        Main.FastReader in = new Main.FastReader();
        col = in.nextInt();
        row = in.nextInt();
        puzzle = new char[row][col];
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            String line = in.nextLine();
            for (int j = 0; j < col; j++) {
                char c = line.charAt(j);
                if (c == 'P') {
                    startCol = j;
                    startRow = i;
                }
                puzzle[i][j] = line.charAt(j);
                visited[i][j] = false;
            }
        }
        return puzzle;
    }
    public static int dfs(int i, int j) {
        if (puzzle[i][j] == '#' || puzzle[i][j] == '!' || visited[i][j])
            return 0;
        if (puzzle[i][j] == 'G') {
            goldCount++;
            puzzle[i][j] = '.';
        }
        visited[i][j] = true;
        if (puzzle[i + 1][j] == 'T' || puzzle[i - 1][j] == 'T' || puzzle[i][j + 1] == 'T' || puzzle[i][j - 1] == 'T') {
            puzzle[i][j] = '!';
            return 0;
        }
        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
        return 0;
    }
    public static int gettingGold() throws IOException {
        puzzle = read();
        dfs(startRow, startCol);
        return goldCount;
    }
    public static void main(String[] args) throws IOException {
        System.out.print(gettingGold());
    }
}
