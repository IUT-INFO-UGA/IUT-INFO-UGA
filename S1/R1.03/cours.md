# architecture des ordinateurs

- tout est traduit en 0 ou 1
- données est instruction en mémoire central d'ors de l’exécution
- utilise des type de données très varier: température, couleur... -> nombre (base 2...), caractère (ASCII)

- quelle est la méthode de codage ?
  - base 2 ?
  - code ASCII ?
- sur quelle longueur est représentée la donnée ?

## notation et terminologie

% -> binaire (0101 = 4 valeur binaire -> bits, 2* 4bits = 1 octet)

4 bit = 2^4 = 16 configuration

plus on est a droit plus les bits sont "fort"



$ -> hexadécimal

< méthode et valeur>méthode exemple <203>dix

représentation pondérée: 2 * 10^2 + 0 * 10^2 + 3*10^0

chaque nombre a une représentation unique dans une base donnée



passage base 10 a base 2

par division par deux successive puis garder que les reste: exemple < 92 >dix = <0000 0101 1100>deux 



# calcul

sur les calcul les réglés normal s’applique notamment les retenu est les empreint, attention a la base deux.



# complément a deux

un codage complément a deux s'ecrit <%...>cpt2

il y a donc deux fois moins de valeur possible.

pour changer de signe on copie tout les bi a 0 depuis le pois fable et inversion du reste.

ou inversion de tout +1



# PC: program counter

L sur 32bits = adresse de la prochaine instruction

- initialisé par l'adresse de la 1er initialisation du programme
- évalué a chaque initialisation



# qu'est-ce qu'une instruction ?

1/ information a fournir au processeur

​	-> opération ex MOVE, ADD, BCS (branch copy set) ?

​	-> avec quelle opérande ?

​	-> sur quelle longueur ex B, W, L?

​	-> ou ranger le résultat ?

​	-> que faire après ?



# structure de contrôle

étape 1 ajouter les fin si et fin sinon

imaginé les branchement toujours valable (entre le alors et le sinon)



move.w a,D0;  mise a jour de n, z

BPL  destination;  <- va a destination si n = 0



## comparaison posible:

cmp(ou cmpi).B/W/L source, destination.

positionement de n z v c en fonction de destination **-** source le résultat n'est pas stocker

# TD4

MOVE.L # 260, D6 = 0010 110 000 111 100 |valeur|0000 0001 0000 0100

MOVE.L # 260, D6 =$<2C 3C 00 00 01 04>

111 100 = valeur imediate

260 = 1 0000 0100

MOVE.L =0010

 D6 =valeur (6)110 + registre d*** = 000 = 110 000



conversion <$D43C 00D6>68000 = <1101 0100 0011 1100 | 0000 0000 1101 0110>deux

add D2 .b imediat 

add.B #$D6, D2



codage MOVE.B NBA, D5 	nba est a l'adresse $0050A

DS.B = nc[$050A].B

0001 1010 00  111 000 050A

<$1A 38 050A>68000



décodez les instruction suivante

<$D644 123C 00FF 9404 9438>68000

1101 0110 0100 0100 add.W D4, D3

0001 001 000 111 011 move.b #$FF, d1 

1001 0100 0000 0100 SUB D4, D2

1001 010 000 111 000 SUB #W ,D2

## Exercice 5 

D3.B = C

E.B = E+D3.B

D5.W = T



S-> nc[$0A00] et nc[$0A01]

T -> nc [$0A02] et nc[$0A03]

C -> nc[$0A04]

E -> nc [$0A05]



move.B C,D3 = 0001 011 000 111 000 0A 04

<16380A04>

ADD.B D3,E = 1101 011 100 111 000 0A 05

Move.W T,D5 = 0011 101 000 111 000 0A02

# exercice

<$9B 38 05 02 1C 3C 3C 7B 6B 02 ...>

%1001 1011 0011 1000 mot d'instruction

1001 = sub

1011 = numero de registre

sub.b D56, alow w



1C3C = move B

3C 



a=<-2,875>(4,4) = 0010,1110 = 11010010 

b=<6,0625>(4,4) 0110,0001

c=<-7,1> 0111,0001 = 1000 1111





si ¹ ((c>a)

et ² (b>d))

ou ³ (b<c)

alors ⁴ 

...

sinon ⁵ 

...



si ¹ est vrai ² sera vérifier puis ³ sera vérifier

si ¹ est faux  ² ne sera pas vérifier ³ sera vérifier



si 1	move.w a, D0;

​		CMP C, DO;

​		BGE ou3;	allez a ou3 our a >= c

et2	move..w d,D0;

​		CMP.W b,D0;

​		BLT alors4; 	allez a alors4 pour d <b

ou3	move.W b,D0;

​		CMP.W c,D0;

​		BGE sinon5; 	allez a sinon5 pour c>=c 