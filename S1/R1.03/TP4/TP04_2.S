  		ORG	$0
		DC.L	$8000	; adresse de la pile
		DC.L	Inst1	; pour initialisation PC (Compteur Ordinal)

* declaration des "variables" du programme
* on reserve et on initialise avec la directive DC 
* on reserve sans initialiser avec la directive DS
		ORG	$A00
a		DS.W 5
b		DS.W 4
c		DC.B 's'

* debut des instructions du programme

		ORG	$AC0
Inst1

tq		CMPI.W #2,a
		BGE fintq
		CMPI.W #3,b
		BGE faire
		CMPI.B #'S',c
		BNE fintq

faire	MOVE c,D1
		MOVE #'N',D1
		MOVE D1,c

		MOVE b,D1
		SUB #-1,D1
		MOVE D1,b

		MOVE a,D1
		SUB #-1,D1

		BRA tq

fintq

* fin du programme principal
		BREAK

* fin du contenu a assembler
		END
