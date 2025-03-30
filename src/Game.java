import java.util.Scanner;

public class Game {
    public void startGame(Player player1, Player player2, Board board) throws Exception {
        Player curPlayer = player1;
        Scanner scanner = new Scanner(System.in);

        board.printBoard();

        while(true) {
            int i, j;
            do {
                System.out.println(curPlayer.username + " (" + curPlayer.marker + ") choose square (row then col)");
                i = scanner.nextInt();
                j = scanner.nextInt();
            } while (!board.markOnBoard(curPlayer.marker, i, j));

            board.printBoard();

            if(board.checkWinFor(i, j)){
                System.out.println(curPlayer.username + " won!");
                break;
            } else {
                curPlayer = curPlayer == player1 ? player2 : player1;
            }
        }
    }
}
