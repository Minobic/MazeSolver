import java.util.Arrays;

public class MazeSolver {
    public static void main(String[] args) {
        int[][] board = {
            {1, 1, 1, 1},
            {1, 0, 0, 1},
            {1, 0, 1, 1},
            {1, 1, 1, 1}
        };
        int[][] path = new int[board.length][board[0].length];
        maze("", board, 0, 0, path, 1);
    }

    public static void maze(String p, int[][] maze, int row, int col, int[][] path, int step) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            path[row][col] = step;
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        
        if (maze[row][col] == 0) {
            return;
        }

        maze[row][col] = 0;
        path[row][col] = step;
        
        if (row < maze.length - 1) {
            maze(p + 'D', maze, row + 1, col, path, step + 1);
        }
        if (col < maze[0].length - 1) {
            maze(p + 'R', maze, row, col + 1, path, step + 1);
        }
        if (row > 0) {
            maze(p + 'U', maze, row - 1, col, path, step + 1);
        }
        if (col > 0) {
            maze(p + 'L', maze, row, col - 1, path, step + 1);
        }

        maze[row][col] = 1;
        path[row][col] = 0;
    }
}