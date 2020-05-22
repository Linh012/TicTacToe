import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Board b = new Board();
        int row, col;
        char player = 'X';
        while (b.checkWinner() == false || b.isFull() == false) {
            System.out.println("Player " + player + "'s turn");
            b.display();

            System.out.println("Enter 0,1 or 2 for row");
            row = input.nextInt();
            System.out.println("Enter 0,1 or 2 for column");
            col = input.nextInt();
            b.makeMove(row, col, player);

            if (player == 'X') { //change player turn
                player = 'O';
            } else {
                player = 'X';
            }


        }
    }

    public static class Board { //Board object
        private char[][] board = new char[3][3];
        private int moves = 0;

        public void makeMove(int row, int col, char player) { //make move
            if (board[row][col] == 'X' || board[row][col] == 'O') {
                System.out.println("Spot already occupied!");
            } else {
                board[row][col] = player;
                moves++;
            }
        }

        public boolean isFull() { //no move left/available
            return moves == 9;
        }

        public boolean checkWinner() { //check board state for winner
            return (board[0][0] == board[0][1] && board[0][0] == board[0][2]) ||
                (board[0][0] == board[1][1] && board[0][0] == board[2][2]) ||
                (board[0][0] == board[1][0] && board[0][0] == board[2][0]) ||
                (board[2][0] == board[2][1] && board[2][0] == board[2][2]) ||
                (board[2][0] == board[1][1] && board[0][0] == board[0][2]) ||
                (board[0][2] == board[1][2] && board[0][2] == board[2][2]) ||
                (board[0][1] == board[1][1] && board[0][1] == board[2][1]) ||
                (board[1][0] == board[1][1] && board[1][0] == board[1][2]);
        }

        public void display() { //print board
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    System.out.print(board[i][j] + " ");
                }

            }
            System.out.println();

        }
    }
}
