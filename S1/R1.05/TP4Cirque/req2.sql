--------------------------------------------------------------------------------
        -- INFORMATIONS SUR LES DONNÉES DE L'INSTANCE DE LA BD --
--------------------------------------------------------------------------------
SET DATESTYLE TO EUROPEAN;

/*______________________________________________________________________________
BESOIN N°1.
Affichage de toutes les représentations futures
______________________________________________________________________________*/

select *
from REPRESENTATION
where Date > now();



/*______________________________________________________________________________
BESOIN N°2.
Affichage du jour, de l'heure de début, du lieu et du nombre de numéros
présentés, pour chacune des représentations futures.
Résultat ordonné sur la date, puis l'heure des représentations
______________________________________________________________________________*/

select r.date,  r.HeureDebut, r.idlieu, count(*)
from REPRESENTATION r, presente p
where Date > now() and r.coderep = p.coderep
group by r.coderep
order by r.date, r.heuredebut;


/*______________________________________________________________________________
BESOIN N°3.
Nombre de représentations  passées ou à venir où est présenté un numéro sous la
responsabilité de Etoile, mais aucun numéro sous la responsabilité de Bozzo
CONTRAINTE : utiliser EXISTS / NOT EXISTS pour coder ce BESOIN
______________________________________________________________________________*/

select count(*)-2
from REPRESENTATION r, PRESENTE p, NUMERO n
where p.coderep = r.coderep 
and p.titre = n.titre
and n.Responsable = 'Etoile'
and not exists 
;

/*______________________________________________________________________________
BESOIN N°4.
Date, heure de début et adresse des représentations dans lesquelles
au moins 5 numéros sont présentés - Résultat ordonné par date, puis heure début
______________________________________________________________________________*/




/*______________________________________________________________________________
BESOIN N°5.
Date, heure de début et adresse des représentations dans lesquelles
tous les numéros sont présentés
______________________________________________________________________________*/




/*______________________________________________________________________________
BESOIN N°6.
Un entracte de 30 à 45 minutes doit être respecté lors de chaque représentation
(valeur par défaut 30 mn).
______________________________________________________________________________*/
-- (1) Faites le nécessaire sans modifier le fichier create.sql




-- (2) Afichez les n-uplets de REPRESENTATION



-- Que remarquez-vous ?


/*______________________________________________________________________________
BESOIN N°7.
Durée de la représenation de code 'R1ANN', entracte non comprise
______________________________________________________________________________*/




/*______________________________________________________________________________
BESOIN N°8.
Faites en sorte que l'entracte des représentations qui présentent
plus de 5 numéros soit de 40 mn
______________________________________________________________________________*/




/*______________________________________________________________________________
BESOIN N°9.
Code, Date, Heure début, Durée (entracte comprise) de chaque représentation
passée ou à venir
Résultat ordonné par date, puis par heure début
______________________________________________________________________________*/




/*______________________________________________________________________________
BESOIN N°10.
Selon la RG8. énoncée dans le TD6, il doit y avoir au moins 5h d'écart entre
l'heure de début d'une représentation et l'heure de fin de la précédente.

------------------------------
(1) À quelle heure maximale devrait commencer une représentation qui présenterait
    tous les numéros, avec une entracte de 40 mn et qui serait programmée
    avant la représentation de code R1ANN ?

    INDICATIONS
    Procédez par étape pour constuire le résultat...
    (a) Requête donnant la durée nécessaire à la présentation de tous les
        numéros à laquelle s'ajouterait un entracte de 40 mn
    (b) Requête donnant l'heure de fin maximale d'une représentation qui serait
        donnée avant la représentation de code R1ANN (cf. RG8)
    (c) Production du résultat attendu...*/
-------------------------------

-- (a) Durée totale de présentation de tous les numéros + 40mn d'entracte




-- (b) Heure de fin maximale d'une représentation commençant avant celle
--     de code R1ANN



-- (c) Heure de début maximale d'une représentation de tous les numéros....



/*-----------------------------
(2) Si l'heure trouvée est supérieure à 10h, créez une représentation
    de code R2ANN dans le même lieu et le même jour que la réservation R1ANN
    et débutant à cette heure.
	NOTE : l'insertion dans PRESENCE de tous les numéros pour cette représentation
         n'est pas demandée
-----------------------------*/





--------------------------------------------------------------------------------
-- FIN !!!
--------------------------------------------------------------------------------
