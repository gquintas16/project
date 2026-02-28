import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static String[][] board = new String[3][3];
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = " ";
            }
        }
        playGame();
    }

    public static void opponentPieces (String OorX) {
        Random random = new Random();
        int position;

        do {
            position = random.nextInt(9) + 1;
        } while (isTaken(position));

        if (OorX.equals("X")) {
            newBoard(board, position, "O");
        } else {
            newBoard(board, position, "X");
        }
    }

    public static boolean isTaken(int position) {
        switch (position) {
            case 1: return !board[0][0].equals(" ");
            case 2: return !board[0][1].equals(" ");
            case 3: return !board[0][2].equals(" ");
            case 4: return !board[1][0].equals(" ");
            case 5: return !board[1][1].equals(" ");
            case 6: return !board[1][2].equals(" ");
            case 7: return !board[2][0].equals(" ");
            case 8: return !board[2][1].equals(" ");
            case 9: return !board[2][2].equals(" ");
            default: return true;
        }
    }

    public static void playGame () {
        System.out.println();
        int numberOfPlays = 0;

        System.out.print("Do you want to be the 'O' or the 'X'? ");
        String OorX = sc.next();
        System.out.print("\n(1 2 3)\n(4 5 6)\n(7 8 9)\n\n");
        while (true) {
            displayBoard();
            int position;
            do {
                System.out.print("Choose a number: ");
                position = sc.nextInt();
            } while (isTaken(position));

            newBoard(board, position, OorX);
            String result = rules();
            if (result != null) {
                System.out.println();
                displayBoard();
                if (result.equals("Draw")) {
                    System.out.println("It's a draw!");
                } else {
                    System.out.println(result + " wins!");
                }
                break;
            }

            System.out.println();

            opponentPieces(OorX);

            result = rules();
            if (result != null) {
                displayBoard();
                System.out.println();
                if (result.equals("Draw")) {
                    System.out.println("\nIt's a draw!");
                } else {
                    System.out.println(result + " wins!");
                }
                break;
            }
        }
    }

    public static String[][] newBoard(String[][] board, int position, String OorOx) {
        switch (position) {
            case 1:
                board[0][0] = OorOx;
                break;
            case 2:
                board[0][1] = OorOx;
                break;
            case 3:
                board[0][2] = OorOx;
                break;
            case 4:
                board[1][0] = OorOx;
                break;
            case 5:
                board[1][1] = OorOx;
                break;
            case 6:
                board[1][2] = OorOx;
                break;
            case 7:
                board[2][0] = OorOx;
                break;
            case 8:
                board[2][1] = OorOx;
                break;
            case 9:
                board[2][2] = OorOx;
                break;
            default:
                System.out.println("\nERROR ON THE POSITION!!!");
                break;
        }
        return board;
    }

    public static String rules() {
        for (int i = 0; i < 3; i++) {
            if (!board[i][0].equals(" ") &&
                    board[i][0].equals(board[i][1]) &&
                    board[i][1].equals(board[i][2])) {

                return board[i][0];
            }
        }
        for (int i = 0; i < 3; i++) {
            if (!board[0][i].equals(" ") &&
                    board[0][i].equals(board[1][i]) &&
                    board[1][i].equals(board[2][i])) {

                return board[0][i];
            }
        }
        if (!board[0][0].equals(" ") &&
                board[0][0].equals(board[1][1]) &&
                board[1][1].equals(board[2][2])) {

            return board[0][0];
        }
        if (!board[0][2].equals(" ") &&
                board[0][2].equals(board[1][1]) &&
                board[1][1].equals(board[2][0])) {

            return board[0][2];
        }
        boolean full = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(" ")) {
                    full = false;
                }
            }
        }

        if (full) {
            return "Draw";
        }

        return null;
    }

    public static void displayBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);

            if (i < board.length - 1) {
                System.out.println("-----------");
            }
        }
        System.out.println();
    }
}
