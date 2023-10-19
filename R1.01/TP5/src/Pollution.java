import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Pollution {
	public static void main(String[] args) {
		final ArrayList<String> semestre1 = new ArrayList<String >(Arrays.asList("janvier", "fevrié"," mars"," avril"," mai"," juin"));
		final Float SEUIL_ALERTE = 40.0f;
		final ArrayList<ReleveMensuel> bilanSem1 = Utilitaire.bilanSem(semestre1);
		System.out.println("moy: "+Utilitaire.moyConc(bilanSem1));
		final int nbPol = Utilitaire.nbPoll(bilanSem1, SEUIL_ALERTE);
		System.out.println("nb polué: "+nbPol);
		if (nbPol>0){
			System.out.println("premier: "+Utilitaire.poll1(bilanSem1, SEUIL_ALERTE));
			System.out.println("max: "+Utilitaire.maxConc(bilanSem1));
			System.out.println("min: "+Utilitaire.minConc(bilanSem1));
		}
		for (int i = 0; i < bilanSem1.size(); i++) {
			System.out.println(bilanSem1.get(i)+"-->"+Utilitaire.niveauPol(bilanSem1.get(i)));
		}

		final ArrayList<String> semestre2 = new ArrayList<String >(Arrays.asList("juillet", "aout","septembre","octobre","novembre","decembre"));
		final ArrayList<ReleveMensuel> bilanSem2 = Utilitaire.bilanSem(semestre2);
		System.out.println("moy: "+Utilitaire.moyConc(bilanSem2));
		final int nbPol2 = Utilitaire.nbPoll(bilanSem2, SEUIL_ALERTE);
		System.out.println("nb polué: "+nbPol2);
		if (nbPol2>0){
			System.out.println("premier: "+Utilitaire.poll1(bilanSem2, SEUIL_ALERTE));
			System.out.println("max: "+Utilitaire.maxConc(bilanSem2));
			System.out.println("min: "+Utilitaire.minConc(bilanSem2));
		}
		for (int i = 0; i < bilanSem2.size(); i++) {
			System.out.println(bilanSem2.get(i)+"-->"+Utilitaire.niveauPol(bilanSem2.get(i)));
		}
		System.out.println("comparaison");
		if(Utilitaire.compareReleves(bilanSem1, bilanSem2, SEUIL_ALERTE)==-1){
			System.out.println("mal");
		}
		if(Utilitaire.compareReleves(bilanSem1, bilanSem2, SEUIL_ALERTE)==0){
			System.out.println("rien");
		}
		if(Utilitaire.compareReleves(bilanSem1, bilanSem2, SEUIL_ALERTE)==1){
			System.out.println("cool");
		}
	}
}