public class MazeSolver {

    private Pile path;
    private Maze maze;

    public MazeSolver(Maze maze) {
        path = new Pile();
        this.maze = maze;
    }

    /**
     * 0 = wall
     * 1 = path
     * 2 = destination
     */

    public boolean isIndexValid(int row, int column) {
        if (row < 0 ||
                row >= maze.rowsNumber() ||
                column < 0 ||
                column >= maze.columnsNumber()
        ) {
            return false;
        } else {
            return true;
        }
    }

    public void solve(Position start) {
        Position firstPosition;
        firstPosition = start;
        path.push(firstPosition);

        while (true) {
            Position actual;
            int row, column;

            actual = (Position) path.peek();
            row = actual.getRow();
            column = actual.getColumn();

            this.maze.setValue(row, column, 0);

            //Up
            int temp;
            temp = row + 1;
            if (isIndexValid(temp, column)) {
                int value = this.maze.getValue(temp, column);

                if (value == 2) {
                    System.out.println("Moved Up, You Win");
                    return;
                } else if (value == 1) {
                    System.out.println("Moved Up");
                    path.push(new Position(temp, column));
                    continue;
                }
            }

            //Down
            temp = row - 1;
            if (isIndexValid(temp, column)) {
                int value = this.maze.getValue(temp, column);

                if (value == 2) {
                    System.out.println("Moved Down, You Win");
                    return;
                } else if (value == 1) {
                    System.out.println("Moved Down");
                    path.push(new Position(temp, column));
                    continue;
                }
            }

            // Left
            temp = column - 1;
            if (isIndexValid(row, temp)) {
                int value = (maze.getValue(row, temp));

                if (value == 2) {
                    System.out.println("Moved Left, You Win");
                    return;
                } else if (value == 1) {
                    System.out.println("Moved Left");
                    path.push(new Position(row, temp));
                    continue;
                }
            }


            // Right
            temp = column + 1;
            if (isIndexValid(row, temp)) {
                int value = maze.getValue(row, temp);

                if (value == 2) {
                    System.out.println("Moved Right, You Win");
                    return;
                } else if (value == 1) {
                    System.out.println("Moved Right");
                    path.push(new Position(row, temp));
                    continue;
                }
            }

            path.pop();
            System.out.println("Moved Back");
            if (path.size <= 0) {
                System.out.println("No hay salida");
                return;
            }
        }
    }
}
