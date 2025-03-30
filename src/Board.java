public class Board {
    int size;
    char[][] board;

    int[] xRowCount;
    int[] oRowCount;

    int[] xColCount;
    int[] oColCount;

    int xFDiagonalCount;
    int oFDiagonalCount;

    int xBDiagonalCount;
    int oBDiagonalCount;

    public Board(int size) {
        this.reset(size);
    }

    public void reset(int size) {
        this.size = size;
        board = new char[size][size];
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                board[i][j] = '.';
//            }
//        }

        xRowCount = new int[size];
        oRowCount = new int[size];
        xColCount = new int[size];
        oColCount = new int[size];
        xFDiagonalCount = 0;
        oFDiagonalCount = 0;
    }

    public boolean markOnBoard(char marker, int i, int j) throws Exception {
        if(i<0 || i>= size || j<0 || j>= size || board[i][j]=='O' || board[i][j]=='X') {
            System.out.println("Invalid input, please choose square again");
            return false;
        }
        board[i][j] = marker;
        if(marker == 'X') {
            xRowCount[i]++;
            xColCount[j]++;

            if(i==j) xFDiagonalCount++;
            if(i+j==size-1) xBDiagonalCount++;
        }
        if(marker == 'O') {
            oRowCount[i]++;
            oColCount[j]++;

            if(i==j) oFDiagonalCount++;
            if(i+j==size-1) oBDiagonalCount++;
        }
        return true;
    }

    public boolean checkWinFor(int i, int j) {
        if(xRowCount[i] == size || oRowCount[i] == size) return true;
        if(xColCount[j] == size || oColCount[j] == size) return true;
        if(xFDiagonalCount == size || oFDiagonalCount == size) return true;
        if(xBDiagonalCount == size || oBDiagonalCount == size) return true;

        return false;
    }

    public void printBoard() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
