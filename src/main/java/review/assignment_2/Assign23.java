package review.assignment_2;

import java.util.Scanner;

public class Assign23 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ConnectFour game = new ConnectFour();

        game.initBoard();

        int player = 1;

        boolean playing = true;
        while (playing) {

            System.out.println();
            game.showBoard();

            String column;
            if (player == 3) {
                column = "";
            } else {
                System.out.print("Player #" + player + " Enter a choice: ");
                column = input.nextLine();
                column = column.toUpperCase();
            }

            if (game.play(player, column) == 1) {
                System.out.println("Column " + column + " is full.");
            } else {
                if (player == 1) player = 2;
                else if (player == 2) player = 3;
                else player = 1;
            }

            if (game.checkWin() != 0) {
                playing = false;
            }
        }

        int winner = game.checkWin();
        if (winner == 1) {
            game.showBoard();
            System.out.println("Player #1 Wins");
        }
        else if (winner == 2) {
            game.showBoard();
            System.out.println("Player #2 Wins");
        }
        else if (winner == 3) {
            game.showBoard();
            System.out.println("The Computer Wins");
        }
        else {
            game.showBoard();
            System.out.println("Its a Draw");
        }
    }
}
