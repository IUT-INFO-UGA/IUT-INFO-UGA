import java.util.ArrayList;

// IMPORTANT: Il ne faut pas changer la signature des méthodes
// de cette classe, ni le nom de la classe.
// Vous pouvez par contre ajouter d'autres méthodes (ça devrait 
// être le cas)
class CPUPlayer
{

    // Contient le nombre de noeuds visités (le nombre
    // d'appel à la fonction MinMax ou Alpha Beta)
    // Normalement, la variable devrait être incrémentée
    // au début de votre MinMax ou Alpha Beta.
    private int numExploredNodes;

    // Le constructeur reçoit en paramètre le
    // joueur MAX (X ou O)
    public CPUPlayer(Mark cpu){

    }

    // Ne pas changer cette méthode
    public int  getNumOfExploredNodes(){
        return numExploredNodes;
    }

    // Retourne la liste des coups possibles.  Cette liste contient
    // plusieurs coups possibles si et seuleument si plusieurs coups
    // ont le même score.
    public ArrayList<Move> getNextMoveMinMax(Board board) {
        numExploredNodes = 0;
        ArrayList<Move> move = board.generateMoves();
        ArrayList<Move> possibleMove = new ArrayList<Move>();

        for (int i = 0; i < move.size(); i++) {
            Board m_board = board; // Utilisation d'une copie du plateau
            m_board.play(move.get(i), Mark.O);

            int eval = m_board.evaluate(Mark.O);

            if (eval == 100) {
                possibleMove.clear(); // Ce coup est gagnant, on ne garde que lui
                possibleMove.add(move.get(i));
                return possibleMove;
            } else if (eval == 0) {
                // Recherche récursive des meilleurs coups
                ArrayList<Move> nextMoves = getNextMoveMinMax(m_board);
                if (!nextMoves.isEmpty()) {
                    possibleMove.addAll(nextMoves);
                } else {
                    possibleMove.add(move.get(i)); // Ajout du coup si aucun autre n'est trouvé
                }
            }
        }
        return possibleMove;
    }


    // Retourne la liste des coups possibles.  Cette liste contient
    // plusieurs coups possibles si et seuleument si plusieurs coups
    // ont le même score.
    public ArrayList<Move> getNextMoveAB(Board board){
        numExploredNodes = 0;
        return new ArrayList<>();
    }

}
