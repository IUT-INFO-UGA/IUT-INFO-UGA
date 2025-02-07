import java.util.Scanner;
import java.util.ArrayList;

class RunTictactoe
{
    public static void main(String[] args){
	PlayGame();
        //TestMinimax();
	//TestAlphaBeta();
    }

    public static void PlayGame()
    {
    	Board board = new Board();

        Scanner console = new Scanner(System.in);
        board.print();

        Mark turn = Mark.X;
        Mark cpuPlayer = Mark.O;

        CPUPlayer cpu = new CPUPlayer(cpuPlayer);

        while(!board.isGameFinished()){
            if(turn == cpuPlayer){
		//TP 1
		// Choisi le premier coup de la liste des coups possibles
		// Vous pouvez modifiez pour avoir un coup au hasard ou
		// remplacer pour choisir les coups manuellement
		ArrayList<Move> moves = board.generateMoves();

		//TP 2
		//Faire choisir le coup par l'ordinateur grâce à l'algorithme Minimax
		//ArrayList<Move> moves = cpu.getNextMoveMinMax(board);

		// Si vous avez le temps
		// Faire choisir le coup par l'ordinateur grâce à l'algorithme Alpha-Beta 
        // ArrayList<Move> moves = cpu.getNextMoveAB(board);
                
		board.play(moves.get(0),turn); // Parmis tous les coups ayant le même coup, ont choisi le premier
		int c = moves.get(0).getCol()+1;
		int r = moves.get(0).getRow()+1;
		System.out.println("Ordinateur joue le coup ("+r+","+c+")");
            }
            else{
                System.out.print("Entrer votre coup : ");
                String move = console.nextLine();
                int row = (int)move.charAt(0) - '0'-1;
                int col = (int)move.charAt(2) - '0'-1;
                board.play(new Move(row,col),turn);
            }

            turn = (turn == Mark.X)?Mark.O:Mark.X;
            board.print();
	}
	board.print();

    }

    
    public static void TestMinimax(){
        System.out.println("MINIMAX : test premier coup des O");

        Board board = new Board();
        board.play(new Move(0,0),Mark.X);
        CPUPlayer cpu = new CPUPlayer( Mark.O);

        ArrayList<Move> movesMinMax  = cpu.getNextMoveMinMax(board);
        int nMinMaxNodes = cpu.getNumOfExploredNodes();

	if(movesMinMax.size() == 1){
            if(movesMinMax.get(0).getRow() == 1 && movesMinMax.get(0).getCol() == 1)
                System.out.println("\tCoup joué par MinMax    : Réussi");
            else
                System.out.println("\tCoup joué par MinMax    : Échec (obtenu : ("+movesMinMax.get(0).getRow()+","+movesMinMax.get(0).getCol()+"), attendu : (1,1))");

	
            if(nMinMaxNodes == 59704){
                System.out.println("\tNombre de noeuds explorés (MinMax) : Réussi");
            }
            else{
                System.out.println("\tNombre de noeuds explorés (MinMax) : Échec (nombtre obtenu : "+nMinMaxNodes + ", attendu : 59704");
            }
	}
	else
            System.out.println("\tIl y a un seul coup possible pour les O (reçu "+movesMinMax.size()+")");


	// Test un plateau vide et premier coup du joueur X
	System.out.println("MINIMAX : test premier coup des X");

        board = new Board();

        cpu = new CPUPlayer( Mark.X);

        movesMinMax  = cpu.getNextMoveMinMax(board);
        nMinMaxNodes = cpu.getNumOfExploredNodes();

        if(movesMinMax.size() == 9){
            System.out.println("\tNombres de coups possibles: Réussi");
            if(nMinMaxNodes == 549945){
                System.out.println("\tNombre de noeuds explorés (MinMax) : Réussi");
            }
            else{
                System.out.println("\tNombre de noeuds explorés (MinMax) : Échec (nombtre obtenu : "+nMinMaxNodes + ", attendu : 549945");
            }
        }
        else{
            System.out.println("\tNombres de coups possibles: Échec (obtenu "+movesMinMax.size()+", attendu : 9");
        }

    }

public static void TestAlphaBeta(){
	System.out.println("ALPHA-BETA : test premier coup des O");


        Board board = new Board();

        board.play(new Move(0,0),Mark.X);

        CPUPlayer cpu = new CPUPlayer( Mark.O);

        ArrayList<Move> movesAB      = cpu.getNextMoveAB(board);
        int nABNodes     = cpu.getNumOfExploredNodes();


        if(movesAB.size() == 1){
            if(movesAB.get(0).getRow() == 1 && movesAB.get(0).getCol() == 1)
                System.out.println("\tCoup joué par Alpha Beta    : Réussi");
            else
                System.out.println("\tCoup joué par Alpha Beta    : Échec (obtenu : ("+movesAB.get(0).getRow()+","+movesAB.get(0).getCol()+"), attendu : (1,1))");

            if(nABNodes == 4089){
                System.out.println("\tNombre de noeuds explorés (Alpha Beta) : Réussi");
            }
            else{
                System.out.println("\tNombre de noeuds explorés (Alpha Beta) : Échec (nombtre obtenu : "+nABNodes + ", attendu : 27712");
           }
        }
        else
            System.out.println("\tIl y a un seul coup possible pour les O (reçu "+movesAB.size()+")");

	
	System.out.println("ALPHA-BETA : test premier coup des X");

        board = new Board();

	movesAB      = cpu.getNextMoveAB(board);
        nABNodes     = cpu.getNumOfExploredNodes();

	if(movesAB.size() == 9){
            System.out.println("\tNombres de coups possibles: Réussi");
            if(nABNodes == 30709){
                System.out.println("\tNombre de noeuds explorés (Alpha Beta) : Réussi");
            }
            else{
                System.out.println("\tNombre de noeuds explorés (Alpha Beta) : Échec (nombtre obtenu : "+nABNodes + ", attendu : 30709");
           }
        }
        else{
            System.out.println("\tNombres de coups possibles: Échec (obtenu "+movesAB.size()+", attendu : 9");
        }

    }


}
