--------------------------------------------------------------------------------
          -- BESOINS EN TERMES DE NOUVELLES DONNÉES --
--------------------------------------------------------------------------------

/*______________________________________________________________________________
  BESOIN N°1
  Embauche d'un jongleur, d'un clown, d'un acrobate et d'un équilibriste
______________________________________________________________________________*/

INSERT INTO artiste values('jongleur1', 'jongleur');
INSERT INTO artiste values('clown1', 'clown');
INSERT INTO artiste values('acrobate1', 'acrobate');
INSERT INTO artiste values('équilibriste1', 'équilibriste');



/*______________________________________________________________________________

  BESOIN N°2
	Création d'un nouveau numéro sous la responsabilité de Etoile
______________________________________________________________________________*/

insert INTO NUMERO values('numéro1', 'Etoile');

/*______________________________________________________________________________

  BESOIN N°3
  Participation de Marie et de Volante à ce nouveau numéro
______________________________________________________________________________*/

insert INTO INTERPRETE values('Marie', 'numéro1');
insert INTO INTERPRETE values('Volante', 'numéro1');


/*______________________________________________________________________________

  BESOIN N°4
  Acquisition d'un trapèze de code 21, de couleur non renseignée et qui sera
  rangé dans le camion où est rangé l'accessoire de code 18
______________________________________________________________________________*/

--  ne fonctionne pas
INSERT INTO ACCESSOIRE VALUES(21,'trapèze','',
SELECT ImmatCamion
FROM accessoire
WHERE code=18
);


/*______________________________________________________________________________

  BESOIN N°5
  Bozzo aimerait utiliser des cerceaux dans le numéro les Zappatas :
  faire en sorte qu'il puisse utiliser tous les cerceaux, sachant
  qu'il n'en utilisait aucun dans ce numéro
______________________________________________________________________________*/





/*______________________________________________________________________________

  BESOIN N°6
  Participation de tous les artistes qui n'y participaient pas déjà, au numéro
  Les Zappatas
______________________________________________________________________________*/




/*______________________________________________________________________________

  BESOIN N°7
  Création d'un numéro pour fêter la nouvelle année, avec Bozzo comme responsable
______________________________________________________________________________*/




/*______________________________________________________________________________

  BESOIN N°8
  Participation de tous les artistes à ce nouveau numéro
______________________________________________________________________________*/





/*______________________________________________________________________________

  BESOIN N°9
  Pour ce nouveau numéro, les artistes utiseront les accessoires qu'ils
  utilisent dans les autres numéros qu'ils interprètent.
  Faire le nécessaire pour que cela soit pris en compte...

  AIDES POUR RÉPONDRE À CE DERNIER BESOIN...

    1-  La requête suivante affiche (sans répétition) le code des accessoires
        que Bozzo utilise dans les numéros qu'il interprète :
        SELECT DISTINCT CodeAcc FROM UTILISATION WHERE SurNom = 'Bozzo';

    2-  Pour faire en sorte que Bozzo utilise les mêmes accessoires dans le
        nouveau numéro, il faudrait écrire l'instruction suivante :
        INSERT INTO UTILISATION
        SELECT DISTINCT CodeAcc, 'Bozzo', titre_du_nouveau_numéro
        FROM UTILISATION WHERE SurNom = 'Bozzo';

    3-  Essayez de généraliser l'instruction précédente de façon à ce que chaque
        artiste utilise les mêmes accessoires dans le nouveau numéro, que ceux
        qu'il utilise dans les autres numéros qu'il interprète ...
______________________________________________________________________________*/






--------------------------------------------------------------------------------
-- FIN !!!
--------------------------------------------------------------------------------
