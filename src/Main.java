public class Main {
    public static void main(String[] args) {
        Maze maze = new Maze(new int[][]{
                {2, 0, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1},
                {0, 1, 0, 0, 0, 0, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1}
        });

        MazeSolver mazeSolver = new MazeSolver(maze);

        mazeSolver.solve(new Position(0,6));
    }
}
