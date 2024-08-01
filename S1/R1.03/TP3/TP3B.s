  		ORG	$0
		DC.L	$8000	; adresse de la pile
		DC.L	calcul	; pour initialisation PC (Compteur Ordinal)

* declaration des "variables" du programme
* on les initialise avec la directive DC 
Solde		DC.B	0
		ORG	$AC0


si1		MOVE.B Solde,D1
		BLT alors1

alors1	BLE Solde,#$0
		BLS alors2

sinon1	MOVE #$FFFF, D0
		BLS fin

sinon2	MOVE.W $CCCC,D0
		BLS fin

alors2 MOVE.W #$AAAA,D0

* fin du programme principal
fin		BREAK	

* fin du contenu a assembler
		END