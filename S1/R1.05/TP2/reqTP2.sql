/*
_________________________________________________________
--
--          Requêtes TP2 (fichier à compléter)
--
_________________________________________________________
*/

/*------------------------------------------------------------------------------
(a) Nom et numéro des 3 premiers gardiens selon l'ordre alphabétique
------------------------------------------------------------------------------*/
SELECT NomGard, NumGard
FROM GARDIEN
ORDER BY NomGard ASC
LIMIT 3;
/*------------------------------------------------------------------------------
(b)	Nom, espèce et numéro de cage des animaux dont s'occupent Tintin ou Milou
    (résultat ordonné sur le nom d'animal)
------------------------------------------------------------------------------*/
SELECT NomAni, Espece, a.NumCage
FROM ANIMAL a, SOCCUPE s, GARDIEN g
WHERE s.NumCage=a.NumCage 
and g.NomGard='Tintin' or g.NomGard='Milou'
AND g.NumGard = s.NumGard
ORDER BY NomAni;
/*------------------------------------------------------------------------------
(c)	Nom, espèce et numéro de cage des animaux dont s'occupent Tintin et Milou
------------------------------------------------------------------------------*/
SELECT NomAni, Espece, a.NumCage
FROM ANIMAL a, SOCCUPE s, GARDIEN g
WHERE s.NumCage=a.NumCage AND g.NumGard = s.NumGard
and g.NomGard='Tintin'
Intersect
SELECT NomAni, Espece, a.NumCage
FROM ANIMAL a, SOCCUPE s, GARDIEN g
WHERE s.NumCage=a.NumCage AND g.NumGard = s.NumGard
and g.NomGard='Milou';

/*------------------------------------------------------------------------------
(d)	Nom des gardiens qui ne s'occupent d'aucune cage
Une version avec opérateur ensembliste + une version avec sous-requête(s)
------------------------------------------------------------------------------*/
SELECT DISTINCT NomGard
FROM GARDIEN g, SOCCUPE s
WHERE g.NumGard not in 
(SELECT DISTINCT g.NumGard
FROM GARDIEN g, SOCCUPE s
WHERE g.NumGard=s.NumGard
);

/*------------------------------------------------------------------------------
(e)	Nom des gardiens qui s'occupent d'éléphants
------------------------------------------------------------------------------*/
SELECT DISTINCT NomGard
FROM ANIMAL a, SOCCUPE s, GARDIEN g
WHERE s.NumCage=a.NumCage AND g.NumGard = s.NumGard
and a.Espece='éléphant';

/*------------------------------------------------------------------------------
(f)	Nom des gardiens qui ne s'occupent pas d'éléphants
		(mais qui s'occupent d'au moins une cage)
------------------------------------------------------------------------------*/
SELECT DISTINCT NomGard
FROM ANIMAL a, SOCCUPE s, GARDIEN g
WHERE s.NumCage=a.NumCage AND g.NumGard = s.NumGard
and not (a.Espece='éléphant')
/*------------------------------------------------------------------------------
(g)	Nombre d'animaux qui cohabitent avec l'éléphant dumbo
------------------------------------------------------------------------------*/
SELECT count(NomAni) -1
FROM ANIMAL
WHERE NumCage =
(SELECT NumCage
FROM animal
where NomAni='dumbo');


/*------------------------------------------------------------------------------
(h)	Nom et espèce des animaux qui cohabitent avec l'éléphant dumbo
------------------------------------------------------------------------------*/
SELECT NomAni, Espece
FROM ANIMAL
WHERE NomAni !='dumbo' AND NumCage =
(SELECT NumCage
FROM animal
where NomAni='dumbo') ;

/*------------------------------------------------------------------------------
(i) Nom et adresse des gardiens nés en 1980
------------------------------------------------------------------------------*/
SELECT NomGard, Adresse
FROM GARDIEN
WHERE extract (year from DateNaissGard) = 1980;

/*------------------------------------------------------------------------------
(j) Âge qu'a atteint aujourd'hui le gardien Gaston Lagaffe
------------------------------------------------------------------------------*/
SELECT current_date, age (DateNaissGard) as age_Lagaffe
FROM GARDIEN
WHERE NomGard='Gaston Lagaffe';

/*------------------------------------------------------------------------------
(k)	Par ordre chronologique, date du diagnostic, nom de la maladie
    et nom de l'animal malade, pour chaque cas de maladie enregistré en 2022
------------------------------------------------------------------------------*/
select DateDebutMal, maladie, nomani
from SUIVI_MAL
where extract (year from DateDebutMal) = 2022;


/*------------------------------------------------------------------------------
(l)	Nombre d'éléphants qui ont eu au moins une fois le typhus
------------------------------------------------------------------------------*/
 select count(DISTINCT nomani) as atteints_typhus
from animal
where espece = 'éléphant' 
AND nomani 
in(select nomani from SUIVI_MAL  where  maladie = 'typhus');

/*------------------------------------------------------------------------------
(m)	Nom et espèce des animaux qui sont encore malades aujourd'hui
------------------------------------------------------------------------------*/
select DISTINCT s.nomani, a.espece
from SUIVI_MAL s, animal a
WHERE s.datefinmal is NULL and s.nomani = a.nomani;


/*------------------------------------------------------------------------------
(n)	Nom des animaux qui ont contracté au moins deux maladies différentes
------------------------------------------------------------------------------*/
with countmal as(
    select nomani, count(DISTINCT Maladie)
    from SUIVI_MAL
    group by nomani
)
select nomani
from countmal
where count >= 2;

/*------------------------------------------------------------------------------
(o)	Numéro des cages où sont gardés des animaux qui ont déjà contracté
    le typhus et la gale
------------------------------------------------------------------------------*/
SELECT DISTINCT a.NumCage
FROM ANIMAL a, SUIVI_MAL sm1, SUIVI_MAL sm2
WHERE a.NomAni = sm1.NomAni
AND a.NomAni = sm2.NomAni
AND sm1.Maladie = 'typhus'
AND sm2.Maladie = 'gale';

/*------------------------------------------------------------------------------
(p)	Nom et numéro de cage des animaux qui ont été ou sont malades et dont
    le gardient Gaston Lagaffe a la charge
		(résultat ordonné sur le numéro de cage puis sur le nom d'animal)
------------------------------------------------------------------------------*/
SELECT DISTINCT ANIMAL.NomAni, ANIMAL.NumCage
FROM ANIMAL, SUIVI_MAL, SOCCUPE, GARDIEN
WHERE ANIMAL.NomAni = SUIVI_MAL.NomAni
AND ANIMAL.NumCage = SOCCUPE.NumCage
AND SOCCUPE.NumGard = GARDIEN.NumGard
AND GARDIEN.NomGard = 'Gaston Lagaffe'
ORDER BY ANIMAL.NumCage, ANIMAL.NomAni;

/*------------------------------------------------------------------------------
(q)	Nombre de jours minimum qu'un animal a mis pour guérir d'une maladie
		qu'il avait contractée
------------------------------------------------------------------------------*/
*

/*------------------------------------------------------------------------------
(r)	Nombre de jours minimum qu'un animal a mis pour guérir de la gale et
		Nombre de jours minimum qu'un animal a mis pour guérir du typhus
INDICATION : utliser des sous-requêtes pour déterminer chacun des nombres de
jours à afficher
------------------------------------------------------------------------------*/
*

/*------------------------------------------------------------------------------
(s)	Pour chaque animal du zoo, nombre de maladies différentes
    qu'il a contractées (résultat ordonné par nombre de maladies décroissant)
ATTENTION, certains animaux n'ont encore jamais été malades !
------------------------------------------------------------------------------*/
SELECT 
    ANIMAL.NomAni,
    (SELECT COUNT(DISTINCT Maladie) 
     FROM SUIVI_MAL 
     WHERE SUIVI_MAL.NomAni = ANIMAL.NomAni) AS NombreMaladies
FROM ANIMAL
ORDER BY NombreMaladies DESC;

/*------------------------------------------------------------------------------
(t)	Nombre d'animaux par cage du zoo – le numéro et le type de chaque cage
    sera affiché (résultat ordonné par nombre d'animaux décroissant)
ATTENTION - il peut y avoir des cages vides
------------------------------------------------------------------------------*/
SELECT 
    CAGE.NumCage, 
    CAGE.TypeCage, 
    (SELECT COUNT(*) 
     FROM ANIMAL 
     WHERE ANIMAL.NumCage = CAGE.NumCage) AS NombreAnimaux
FROM CAGE
ORDER BY NombreAnimaux DESC;

/*------------------------------------------------------------------------------
(u)	Nombre de cages affectées à chaque gardien – le nom du gardien doit être
    affiché (pas son numéro)
    (résultat ordonné par nombre de cages décroissant)
------------------------------------------------------------------------------*/
SELECT 
    GARDIEN.NomGard,
    (SELECT COUNT(*) 
     FROM SOCCUPE 
     WHERE SOCCUPE.NumGard = GARDIEN.NumGard) AS NombreCagesAffectees
FROM GARDIEN
ORDER BY NombreCagesAffectees DESC;

/*------------------------------------------------------------------------------
(v)	Nombre d'animaux dont s'occupe chaque gardien – le nom du gardien doit être
    affiché (pas son numéro)
    (résultat ordonné par nombre d'animaux décroissant)
------------------------------------------------------------------------------*/
SELECT 
    GARDIEN.NomGard, 
    (SELECT COUNT(*) 
     FROM SOCCUPE 
     WHERE SOCCUPE.NumGard = GARDIEN.NumGard) AS NombreAnimaux
FROM GARDIEN
ORDER BY NombreAnimaux DESC;
mais ne semble pas fonctioné

/*------------------------------------------------------------------------------
(w)	Nom, âge (en années) et adresse des gardiens qui s'occupent
    d'au moins 7 animaux
------------------------------------------------------------------------------*/
ne fonctionne pas nomplus
SELECT 
    NomGard, 
    EXTRACT(YEAR FROM AGE(NOW(), DateNaissGard)) AS Age,
    Adresse
FROM GARDIEN
WHERE NumGard IN (
    SELECT NumGard
    FROM SOCCUPE
    GROUP BY NumGard
    HAVING COUNT(*) >= 7
);


/*------------------------------------------------------------------------------
(x)	Titeuf s'occupe de beaucoup d'animaux ! On voudrait en savoir plus…
    1.	Combien de cages dont il s'occupe abritent es éléphants ?
    2.	Quel est l'âge en années du plus vieil animal (ou des plus vieux animaux)
        dont il s'occupe ?
    3.	Pour chaque espèce d'animal, combien a-t-il d'animaux en charge ?
------------------------------------------------------------------------------*/


--------------------------------------------------------------------------------
-- FIN !!!
--------------------------------------------------------------------------------
---------------------
