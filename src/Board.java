public class Board {
    int size;
    char[][] board;

    public void reset(int size) {
        this.size = size;
        board = new char[size][size];
    }

}
