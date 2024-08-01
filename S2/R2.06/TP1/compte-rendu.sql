/*================================================================*/
/* NOM Prénom - TP01 : Révisions - BD relationnelle et SQL simple */
/*================================================================*/

/*********************/
/* 1. Afficher le nom des personnages des films de l'univers Marvel-Avengers dans l'ordre alphabétique. */
/*********************/

select nom
from personnage
order by nom;

/*********************/
/* 2. compte le nombe de film dans lequel aparait Iron Man */
/*********************/

/*********************/
/* 3. Afficher le nombre de films sortis chaque année. */
/*********************/
select annee, count(*) as nf
from film
group by annee
order by annee;

/*********************/
/* 4. Donner le nom des personnages jouant dans un film dont le titre contient son nom. */
/*********************/
select distinct nom
from film, personnage
where titre like nom||'%'
order by nom;

/*********************/
/* 5. Donner le nom des personnages dont l'état civil indique qu'ils sont nés dans l'état de New York. */
/*********************/
select personnage.nom
from etat_civil join personnage on etat_civil.nom = personnage.alias
where etat='New York';

/*********************/
/* 6. affiche le titre de chaque film avec plus de 1 realisateur */
/*********************/

/*********************/
/* 7. Donner le titre des films n'ayant qu'un seul réalisateur, dans l'ordre alphabétique de leur titre. */
/*********************/
SELECT titre
FROM film NATURAL JOIN realise 
GROUP BY titre
HAVING COUNT(*) = 1
ORDER BY titre;

/*********************/
/* 8. Donner la liste des informations des personnages, complétées par leur état civil, s'ils en ont un. */
/*********************/

select p.*, annee, etat
from personnage p join etat_civil on p.alias = etat_civil.nom
order by nom;

/*********************/
/* 9. Pour chaque film dont le titre commence par Avengers, donner le nombre de personnage qui y meurent. */
/*********************/

select titre, count(nom) as nomb
from film NATURAL full join meurt_dans
where titre like 'Avengers%'
group by titre;

/*********************/
/* 10. Donner le titre des films où apparaît un personnage né dans l'état de Pennsylvanie. */
/*********************/

select titre, alias
from film natural join apparait_dans natural join personnage join etat_civil on personnage.alias=etat_civil.nom
where etat = 'Pennsylvanie'
order by titre, alias;

/*********************/
/* 11. Pour chaque film où au moins un personnage apparaît en post-générique, donner son titre suivi du nombre de personnages avec alias qui apparaissent en post-générique. */
/*********************/

select distinct titre, count(alias) as nap
from apparait_dans natural JOIN film natural join personnage
where post_generique
group by titre;

/*********************/
/* 12. Pour chaque paire de personnages, afficher leurs noms suivis du nombre de films dans lesquels ils apparaissent ensemble, si ce nombre est au moins égal à 5. */
/*********************/
select a1.nom, a2.nom count(titre)
from personnage a1, personnage a2, film natural join apparait_dans
where a1.nom != a2.nom and a1.alias!=a2.alias and
