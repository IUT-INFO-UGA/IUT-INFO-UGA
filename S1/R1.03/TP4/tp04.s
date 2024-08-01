  		ORG	$0
		DC.L	$8000	; adresse de la pile
		DC.L	Inst1	; pour initialisation PC (Compteur Ordinal)

* declaration des "variables" du programme
* on reserve et on initialise avec la directive DC 
* on reserve sans initialiser avec la directive DS
		ORG	$A00
Solde		DS.W 1
Depenses	DS.W 1


* debut des instructions du programme

		ORG	$AC0
Inst1	MOVE.W #20,Solde     ;  Solde := 20
		MOVE.W #40,Depenses   ;  Depenses :=40

*  a vous d'ecrire la suite en assembleur...
tq	CMPI.W #20,Solde	;	sole ? 27
	BGT fintq			; allez a fintq si Solde > 20

et	CMPI.W #50,Depenses ; Depenses ? 50
	BGE fintq			; allez a fintq si Depenses >= 50

faire	MOVE.W Solde,D1
		SUB.W #-5,D1
		MOVE.W D1,Solde
		MOVE.W Depenses,D1
		ADD.W #5,D1
		MOVE.W D1,Depenses
		BRA tq

fintq



* fin du programme principal
		BREAK	

* fin du contenu a assembler
		END



