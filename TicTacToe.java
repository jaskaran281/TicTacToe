import java.util.Arrays;

public class TicTacToe {
    String[] board = new String[9];
    Player player1; 
    Player player2;
    Player currentPlayer;

    TicTacToe(){

        for (int i = 0; i < 9; i++){
            this.board[i] = "\s";
        }

        this.player1 = new HumanPlayer("X");
        this.player2 = new RandomPlayer("O");
        this.currentPlayer  = this.player1;
    }

    void displayBoard(){
        for (int i = 0; i < this.board.length; i += 3) {
            String row = String.join(" | ", Arrays.copyOfRange(this.board, i, i + 3));
            System.out.println(row);
    
            if (i < this.board.length - 3) {
                System.out.println("---------");
            }
        }
     }

     void updateBoard(int position){
        this.board[position - 1] = this.currentPlayer.symbol;
    }

    void playGame(){
        
        while (true){
            this.displayBoard();

            int position = this.currentPlayer.getMove();
            this.updateBoard(position);

            if ( this.checkWinner()){
                this.displayBoard();
                System.out.println();
                System.out.println("Player "+ this.currentPlayer + " wins");
                break;
            }
            if ( ! isElementPresent(this.board, "\s", 0)){
                this.displayBoard();
                System.out.println("Its a Tie!");
                break;
            }
            this.currentPlayer = (this.currentPlayer == this.player1) ? this.player2 : this.player1;
        }
    }

    public boolean checkWinner() {
        int[][] winningCombinations = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},  // rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},  // columns
            {0, 4, 8}, {2, 4, 6}  // diagonals
        };
    
        for (int[] combination : winningCombinations) {
            if (board[combination[0]].equals(board[combination[1]]) && board[combination[1]].equals(board[combination[2]]) && !board[combination[0]].equals("\s")) {
                return true;
            }
        }
        return false;
    }

    // private boolean isElementPresent(String[] array, String targetElement) {
    //     for (String element : array) {
    //         if (element.equals(targetElement)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    private boolean isElementPresent(String[] array, String targetElement, int i) {
        if (i >= array.length) {
            return false;
        }
        else  if (array[i] == targetElement){
            return true;
        }
        else {
            return isElementPresent(array, targetElement, i+1);
        }
    } // Gives an Exception on last move
}

