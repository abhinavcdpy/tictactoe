import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter Player 1 name (X): ");
        String player1Name = scanner.next();
        System.out.println("Please enter Player 2 name (O): ");
        String player2Name = scanner.next();

        Player player1 = new Player(player1Name, 'X');
        Player player2 = new Player(player2Name, 'O');

        while(true) {
            Game game = new Game();
            try {
                System.out.println("Enter board size");
                int boardSize = scanner.nextInt();

                Board board = new Board(boardSize);

                game.startGame(player1, player2, board);

                System.out.println("Do you want to play again? (y/n)");
                char input = scanner.next().charAt(0);
                if(input == 'n') break;

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}