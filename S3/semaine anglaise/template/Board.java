import java.util.ArrayList;

// IMPORTANT: Il ne faut pas changer la signature des méthodes
// de cette classe, ni le nom de la classe.
// Vous pouvez par contre ajouter d'autres méthodes (ça devrait 
// être le cas)
class Board
{
    private Mark[][] board;

    // Ne pas changer la signature de cette méthode
    public Board() {
        board = new Mark[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Mark.EMPTY;
            }
        }
    }

    // Place la pièce 'mark' sur le plateau, à la
    // position spécifiée dans Move
    //
    // Ne pas changer la signature de cette méthode
    public void play(Move m, Mark mark){
        board[m.getCol()][m.getRow()] = mark;
    }


    // Retourne  100 pour une victoire
    //          -100 pour une défaite
    //           0   pour un match nul
    // Ne pas changer la signature de cette méthode
    public int evaluate(Mark mark) {
        // check horizontal ligne
        for (int row = 0; row < 3; row++) {
            if (board[row][0] != Mark.EMPTY &&
                    board[row][0] == board[row][1] &&
                    board[row][1] == board[row][2]) {
                return board[row][0] == mark ? 100 : -100;
                
            }
        }

        // check vertical ligne
        for (int col = 0; col < 3; col++) {
            if (board[0][col] != Mark.EMPTY &&
                    board[0][col] == board[1][col] &&
                    board[1][col] == board[2][col]) {
                return board[0][col] == mark ? 100 : -100;
            }
        }

        // diag top left right
        if (board[0][0] != Mark.EMPTY &&
                board[0][0] == board[1][1] &&
                board[1][1] == board[2][2]) {
            return board[0][0] == mark ? 100 : -100;
        }

        // diag top right left
        if (board[0][2] != Mark.EMPTY &&
                board[0][2] == board[1][1] &&
                board[1][1] == board[2][0]) {
            return board[0][2] == mark ? 100 : -100;
        }

        // equity
        return 0;
    }


    // Retourne  true si la partie est terminée (victoire, défaite, match nul
    //           false sinon
    //           
    // Ne pas changer la signature de cette méthode
    public boolean isGameFinished(){
        int nbNotEmpty = 0;
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                if(this.board[i][j] != Mark.EMPTY) nbNotEmpty++;
            }
        }
        //if not 3th game part
        if(nbNotEmpty<5) return false;
        if(nbNotEmpty>=9) return true;
        return evaluate(Mark.O)==0;
    }


    // Retourne une liste des coups qu'il est possible
    // de jouer en fonction de l'état du plateau
    //
    // Ne pas changer la signature de cette méthode
    public ArrayList<Move> generateMoves(){
        ArrayList<Move> moves = new ArrayList<Move>();
        for (int i = 0; i <this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                if(this.board[i][j] == Mark.EMPTY)
                    moves.add(new Move(i, j));
            }
        }
        return moves;
    }

    // Affiche le plateau de jeu
    //
    // Ne pas changer la signature de cette méthode
    public void print(){
        for(int i=0; i<3;i++){
            for(int j=0; j<3;j++){
                if(board[i][j] == Mark.EMPTY)
                    System.out.print(" ");
                else
                    System.out.print(board[i][j]);
                if(j<2)
                    System.out.print(" | ");
            }
            System.out.println("");
            if (i < 2)
                System.out.println("----------");
        }
        System.out.println("\n");
    }
}
