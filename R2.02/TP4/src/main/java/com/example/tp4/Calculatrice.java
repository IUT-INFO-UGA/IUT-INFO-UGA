public class Calculatrice {
    private int operande1 = -1;
    private int operande2 = -1;
    private String operation = null;

    // nature des etapes du calcul
    private static final int SAISIE_OPERANDE1 = 1;
    private static final int SAISIE_OPERANDE2 = 2;
    private static final int SAISIE_OPERATION = 3;

    int etape = SAISIE_OPERANDE1;                 // etape de la saisie


    // affectation d'une opérande 0 ou 1 en 1ère ou 2ème valeur de l'opération
    public boolean setOperande(int value) {
        if (etape == SAISIE_OPERANDE1) {
            operation=null;
			operande1=value;
            operande2=-1;
            etape = SAISIE_OPERATION;
            return true;
        } else {
            if ((etape == SAISIE_OPERANDE2) && (operande2 == -1))  {
                operande2 = value;
                return true;
            }
        }
        return false;
    }

    // affectation de l'opération
    public boolean setOperation(String op) {
       if ((etape == SAISIE_OPERATION) && ("ou".equals(op) || "et".equals(op))) {
          operation = op;
          etape = SAISIE_OPERANDE2;
          return true;
        }
        return false;
    }

    // calcul du résultat
    public int getResultat() {
       if ((etape == SAISIE_OPERANDE2) && (operande2 != -1)) {
            etape = SAISIE_OPERANDE1;

            if ("ou".equals(operation)) {
                return operande1 | operande2;
            } else {
                return operande1 & operande2;
            }
        }
        return -1;
    }


}
