  		ORG	$0
		DC.L	$8000	; adresse de la pile
		DC.L	Inst1	; pour initialisation PC (Compteur Ordinal)

* declaration des "variables" du programme
* on reserve et on initialise avec la directive DC 
* on reserve sans initialiser avec la directive DS
		ORG	$A00
a		DS.W 4
b		DS.W 4

* debut des instructions du programme

		ORG	$AC0
Inst1
		MOVE.W a,D1
		MOVE.W b,D2

tq		CMP D1,D2
		BEQ finfaire

si		BGE sinon
		SUB.W D1,D2
		BRA tq

sinon	SUB.W D2,D1
		BRA tq

finfaire
		MOVE.W D1,D0

* fin du programme principal
		BREAK

* fin du contenu a assembler
		END