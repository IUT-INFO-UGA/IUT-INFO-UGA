--------------------------------------------------------------------------------
          -- NOUVEAUX BESOINS EN TERMES DE DONNÉES --
--------------------------------------------------------------------------------

/*______________________________________________________________________________
  BESOIN N°1
  Le camion immatriculé DH-124-UV est en panne...
  Les accessoires qui y sont habituellement rangés doivent être rangés
  provisoirement dans un camion de location immatriculé GA-421-UT
______________________________________________________________________________*/

UPDATE ACCESSOIRE
SET ImmatCamion = 'GA-421-UT'
WHERE ImmatCamion = 'DH-124-UV';



/*______________________________________________________________________________
  BESOIN N°2
  Le numéro skyisblue n'a pas le succès attendu...
	Sa responsable l'a remanié, tout en conservant ses interprètes et
  les accessoires qu'ils y utilisaient.
	Elle a profité de ce remaniement pour le renommer Des étoiles plein les yeux
______________________________________________________________________________*/

INSERT INTO NUMERO 
SELECT 'Des étoiles plein les yeux',
responsable FROM NUMERO 
WHERE Titre = 'skyisblue';

insert INTO INTERPRETE SELECT Surnom, 'Des étoiles plein les yeux'  From Interprete WHERE Titre = 'skyisblue';

UPDATE UTILISATION SET Titre = 'Des étoiles plein les yeux' WHERE Titre  = 'skyisblue';

DELETE FROM INTERPRETE WHERE titre = 'skyisblue';

DELETE FROM NUMERO WHERE titre = 'skyisblue';

/*______________________________________________________________________________

  BESOIN N°3
  Pierre s'est blessé et doit être momentanément remplacé...
	La direction fait appel à Paul, artiste de même spécialité que Pierre,
  pour le remplacer momentanément.
	Paul utilisera pour chaque numéro qui lui est affecté suite à ce remplacement,
  les mêmes accessoires que ceux 	utilisés par Pierre dans ces numéros.
  NOTE : Pierre garde bien sûr sa place au sein du cirque...
______________________________________________________________________________*/

INSERT INTO ARTISTE SELECT 'Paul', Specialite FROM ARTISTE WHERE Surnom = 'Pierre';

INSERT INTO INTERPRETE SELECT 'Paul', Titre FROM INTERPRETE WHERE Surnom = 'Pierre';




/*______________________________________________________________________________

  BESOIN N°4
  Le numéro Les Zappatas a fait son temps…
  Il est décidé de le supprimer en attendant qu'un nouveau numéro soit monté
  avec les mêmes artistes.
  Pour cela, le nom de ces artistes sera conservé dans une relation résultat
  ZAP_ARTISTES non temporaire, avant la suppression du numéro Les Zappatas.
  NOTE : Pensez à ajouter la suppression de la relation ZAP_ARTISTES
         à votre fichier drop.sql
______________________________________________________________________________*/
CREATE TABLE ZAP_ARTISTES AS SELECT Surnom FROM INTERPRETE WHERE Titre = 'Les Zappatas';

DELETE FROM UTILISATION WHERE titre = 'Les Zappatas';

DELETE FROM INTERPRETE WHERE titre = 'Les Zappatas';

DELETE FROM NUMERO WHERE titre = 'Les Zappatas';

--------------------------------------------------------------------------------
-- FIN !!!
--------------------------------------------------------------------------------
