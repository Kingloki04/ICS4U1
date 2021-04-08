package review.assignment_2;

import utils.MathUtil;

public class ConnectFour {

    // [y][x] top left to bottom right

    private int[][] board;
    public ConnectFour() {

    }

    public void initBoard() {
        board = new int[8][8];

        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {
                board[i][j] = 0;
            }
        }
    }

    public void showBoard() {

        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {

                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("A B C D E F G H ");
    }

    public int play(int player, String column) {

        int col = -1;
        if (player == 3) {
            col = MathUtil.random(0, 7);
        } else {
            switch (column) {
                case "A" -> col = 0;
                case "B" -> col = 1;
                case "C" -> col = 2;
                case "D" -> col = 3;
                case "E" -> col = 4;
                case "F" -> col = 5;
                case "G" -> col = 6;
                case "H" -> col = 7;
            }
        }

        boolean empty = true;
        while (empty) {

            for (int i = 0; i < 9; i++) {

                if (i == 8) return 1;
                else if (board[7 - i][col] == 0) {

                    board[7 - i][col] = player;
                    empty = false;
                    break;
                }
            }
        }
        return 0;
    }

    public int checkWin() {

        int ones = 0, twos = 0, threes = 0;

        // Vertical check
        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 5; j++) {

                for (int k = j; k < (j + 4); k++) {

                    int check = board[k][i];
                    switch (check) {
                        case 1 -> ones++;
                        case 2 -> twos++;
                        case 3 -> threes++;
                    }
                }
                if (ones == 4) return 1;
                if (twos == 4) return 2;
                if (threes == 4) return 3;
                ones = 0;
                twos = 0;
                threes = 0;
            }
        }

        // Horizontal check
        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 5; j++) {

                for (int k = j; k < (j + 4); k++) {

                    int check = board[i][k];
                    switch (check) {
                        case 1 -> ones++;
                        case 2 -> twos++;
                        case 3 -> threes++;
                    }
                }
                if (ones == 4) return 1;
                if (twos == 4) return 2;
                if (threes == 4) return 3;
                ones = 0;
                twos = 0;
                threes = 0;
            }
        }

        // Diagonal check 1
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {

                int dif = 0;
                for (int k = j; k < (j + 4); k++) {

                    int check = board[k][i + dif];
                    switch (check) {
                        case 1 -> ones++;
                        case 2 -> twos++;
                        case 3 -> threes++;
                    }
                    dif++;
                }
                if (ones == 4) return 1;
                if (twos == 4) return 2;
                if (threes == 4) return 3;
                ones = 0;
                twos = 0;
                threes = 0;
            }
        }

        // Diagonal check 2
        for (int i = 0; i < 5; i++) {

            for (int j = 7; j > 2; j--) {

                int dif = 0;
                for (int k = j; k > (j - 4); k--) {

                    int check = board[k][i + dif];
                    switch (check) {
                        case 1 -> ones++;
                        case 2 -> twos++;
                        case 3 -> threes++;
                    }
                    dif++;
                }
                if (ones == 4) return 1;
                if (twos == 4) return 2;
                if (threes == 4) return 3;
                ones = 0;
                twos = 0;
                threes = 0;
            }
        }

        return 0;
    }

    public boolean checkFull() {

        int full = 0;
        for (int i = 0; i < 8; i++) {

            if (board[7][i] != 1) full++;
        }

        return full == 8;
    }
}
