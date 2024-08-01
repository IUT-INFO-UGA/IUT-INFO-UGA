* TP02
* comprehension de la mise a jour des indicateurs dans SR

	ORG $0
* adresse du debut de pile :
	DC.L $8000
* point d'entree du programme :
	DC.L	CAS1

* declaration des variables du programme
   	ORG $500
NBA   DC.B  -46
NBB   DC.B  9
NBC   DC.B  -126
NBD   DC.B  56
NBE   DC.B  127
NBF   DC.B  46
NBG   DC.B  23

*---------------------------------------------------
* instructions (succession des cas a etudier)
   ORG $550

* valeur immediate
CAS1
     MOVE.B #%01111111,D0

* valeur immediate
CAS2
     MOVE.B #%11111111,D1

* addition
CAS3
     MOVE.B #%11111100,D1
     ADD.B  #7,D1

* addition
CAS4
     MOVE.B  NBF,D0
     ADD.B   NBG,D0

* soustraction
CAS5
     MOVE.B  NBF,D0
     SUB.B   NBG,D0

* addition
CAS6
     MOVE.W #$00FC,D2
     ADD.W #4,D2

* soustraction
CAS7
     MOVE.B #%11001111,D3
     SUB.B  #%10111000,D3

* soustraction
CAS8
     MOVE.B #%10001111,D4
     SUB.B #$12,D4

* addition
CAS9
     MOVE.B #%01100011,D5
     ADD.B  #%00110000,D5

*-----------------------------------------
* calculs du TD 02

* a+b -> D0.B
CAS10
     MOVE.B NBA,D0
     ADD.B  NBB,D0	

* a+c -> D1.B
CAS11
     MOVE.B NBA,D1
     ADD.B  NBC,D1

* b+d -> D2.B
CAS12
     MOVE.B NBB,D3
     ADD.B  NBD,D3

* a-d -> D1.B
CAS13
     MOVE.B NBA,D1
     SUB.B  NBD,D1

* a-b -> D2.B
CAS14
     MOVE.B NBA,D2
     SUB.B  NBB,D2

* d-c -> D3.B
CAS15
     MOVE.B NBD,D3
     SUB.B  NBC,D3

* fin du programme principal
        BREAK

* fin de la partie du fichier a assembler
        END

