/*===========================================================================*/
/* NOM Prénom - S2.04 - Contrôle du 17 Avril 2024 (Exercice 1)               */
/*===========================================================================*/

/*****************************************************************************/
/** 1 : **/
/*  Spécification :                                                          */
/*  Il peut arriver que plusieurs valeurs d'un champ soient acceptables      */
/*  pour définir les lignes utiles à sélectionner pour votre sujet           */
/*  (pays et groupe de produits).                                            */
/*  On peut alors vérifier que la valeur appartient à une liste définie,     */
/*  ou alors utiliser un opérateur de correspondance de motif.               */
/*****************************************************************************/

-- Code :
--------
SELECT ...
WHERE 
	(countries LIKE '%united-states%' OR countries LIKE '%United States%' OR countries LIKE '%us%')
	AND food_groups = 'en:one-dish-meals'
	...
-- Explications :
----------------
les produit pouvait etre present dans les etats unis, nous avont donc crée la contrainte WHERE (countries LIKE '%united-states%' OR countries LIKE '%United States%' OR countries LIKE '%us%')
nous avont pue explorer un peut la base de données et pour evité un maximum les fait positif nous avont donc utiliser trois expression, cette requette ne devant etre utilisé une seul fois les performence etait pas essentielle.
nous avons egalement ajouté les '%' devant et deriere les expression pour emglobé les ',', et les erreur de formatage.

pour selectionné uniquement les en:one-dish-meals nous avons juste rechercher uniquement les food_groups = 'en:one-dish-meals', apres verification dans la base cella n entraine pas de faux positif.

-- Références :
--------------
like (%): https://www.postgresql.org/docs/15/functions-matching.html


/*****************************************************************************/
/** 2 : **/
/*  Spécification :                                                          */
/*  Concernant le code, nous ne souhaitons considérer que des codes-barres   */
/*  respectant la norme internationale, c'est-à-dire contenant exactement    */
/*  13 chiffres.                                                             */
/*****************************************************************************/

-- Code :
--------
non traité

-- Explications :
----------------

-- Références :
--------------

/*****************************************************************************/
/** 3 : **/
/*  Spécification :                                                          */
/*  Les champs dont le nom se termine par _100g correspondent                */
/*  à des grandeurs définies pour 100g de produit.                           */
/*  Lorsqu'il s'agit de substances entrant dans la composition du produit,   */
/*  la valeur doit être positive et ne peut pas dépasser 100g.               */
/*  Si ce n'est pas le cas, c'est une erreur de saisie                       */
/*  et il convient de ne pas conserver la ligne.                             */
/*****************************************************************************/

-- Code :
--------
SELECT ...
WHERE
	...
	AND fat_100g < 100
	AND sugars_100g < 100
	AND proteins_100g < 100
	AND carbohydrates_100g < 100
	AND salt_100g < 100
	AND sodium_100g < 100
	AND fat_100g > 0
	AND saturated_fat_100g > 0
	AND sugars_100g > 0
	AND proteins_100g > 0
	AND carbohydrates_100g > 0
	AND salt_100g > 0
	AND sodium_100g > 0
	...

-- Explications :
----------------
nous verifion que les valleur ne deppasse pas 100g puis nous suprimont celle qui font moin de 100g, cella enlever la plus-part des valleur aberante/extreme.
-- Références :
--------------
vue en cours

/*****************************************************************************/
/** 4 : **/
/*  Spécification :                                                          */
/*  À partir du champ <code>ingredients_analysis_tags</code>, ajouter        */
/*  les trois champs suivants :                                              */
/*    - vegan indique si le produit est compatible avec un régime végan.     */
/*    - vegetarian indique si le produit est compatible avec un régime       */
/*      végétarien.                                                          */
/*    - palm_oil indique si le produit contient de l'huile de palme.         */
/*  Chaque champ vaut 't' (pour vrai), 'f' (pour faux),                      */
/*  ou NULL (pour indéterminé ou non renseigné).                             */
/*****************************************************************************/

-- Code :
--------
SELECT ...
	case 
		when labels_tags like '%en:organic,%' then TRUE
		when labels_tags like null then null
		else false
	end as bio,
	/* On creer un champ vegan pour savoir si le produit est vegan ou non */
	case 
		when ingredients_analysis_tags like '%en:vegan,%' then TRUE
		when ingredients_analysis_tags like '%en:non-vegan,%' then FALSE
		else null
	end as vegan,
	 /* On creer un champ vegetarian pour savoir si le produit est vegetarien ou non */
	case 
		when ingredients_analysis_tags like '%en:vegetarian%' then TRUE
		when ingredients_analysis_tags like '%en:non-vegetarian%' then FALSE
		else null
	end as vegetarian,
	 /* On creer un champ palm_oil pour savoir si le produit contient de l'huile de palme ou non */
	case 
		when ingredients_analysis_tags like '%en:palm-oil,%' then TRUE
		when ingredients_analysis_tags like '%en:palm-oil-free,%' then FALSE
		else null
	end as palm_oil
	...
-- Explications :
----------------
ici nous avont fait une liste de case, cella nous a permis de crée des table a la suite, nous mettion donc pour chaque element demander trois condition: true, false et null.
puis grace au end as ... nous envoyon le resiltat dans une table. une fois cella compris il ne reste plus qu a trouver les bonne condition.
et je me rend compte a l instant que la table pour palm_oil ne contien pas assez de données a cause d une virgule oublié.

-- Références :
--------------
case: https://www.postgresql.org/docs/16/functions-conditional.html#FUNCTIONS-CASE
je n ai rien trouver dans la doc de postgresql sur comment l envoyez dans une table :(


/*****************************************************************************/
/** 5 : **/
/*  Spécification :                                                          */
/*  Pour l'exportation des données dans un fichier CSV, le délimiteur choisi */
/*  doit être la tabulation (qui peut être définie à la manière du C).       */
/*****************************************************************************/

-- Code :
--------
\copy table1 to './team_a04-marsandm-diiorioe.csv' with (DELIMITER E'\t', FORMAT CSV, NULL 'NA', ENCODING 'UTF-8');

-- Explications :
----------------
le delimiteur est choisie grace a "DELIMITER E'\t'".
-- Références :
--------------
copy et delimiteur: https://www.postgresql.org/docs/current/sql-copy.html -> parti file format

/*===========================================================================*/
/* NOM Prénom - R2.06 - Contrôle du 17 Avril 2024 (Exercice 2)               */
/*===========================================================================*/

/*****************************************************************************/
/** 1 **/
/*****************************************************************************/
-- cette table sea permante car elle doit etre utilisable a l'avenir
create table if not exists livret(
	acteur varchar,
	statut_act varchar,
	salle varchar,
	titre varchar,
	debut date,
	fin date,
	auteur varchar,
	metteur_en_scene varchar
);
/*****************************************************************************/
/** 2 **/
/*****************************************************************************/
\copy livret FROM 'livret.csv' WITH (DELIMITER ';', format CSV, HEADER, ENCODING 'UTF8');
/*****************************************************************************/
/** 3 **/
/*****************************************************************************/
create table if not exists troupe (
	nom varchar primary key,
	statut varchar not null
);

create table if not exists programmation (
	salle varchar,
	titre varchar primary key,
	debut date,
	fin date check (fin >= debut),
	auteur varchar,
	metteur_en_scene varchar
);

create table if not exists distribution (
	titre varchar references programmation(titre),
	acteur varchar references troupe(nom),
	primary key (titre,acteur)
);
/*****************************************************************************/
/** 4 **/
/*****************************************************************************/
create table anciens(
	nom varchar primary key,CREATE OR REPLACE FUNCTION F_remove_troupe() RETURNS trigger
AS $$
BEGIN
	if(new.statut not like '')
	THEN
		RETURN null;
	ELSE
		-- je veut fair un insert mais boucle infini :(
		RETURN new;
	END IF;
END;
$$ LANGUAGE 'plpgsql';
	stauts varchar not null
);
-- cette table doit contenir des donnée, mais si elle etait une vue les donnée serait toujour prensente dans la table principale.
-- si c'etait une table temporaire la table devrai etre relancé a chaque session.
/*****************************************************************************/
/** 5  **/
/*****************************************************************************/
/*
 _________________
< pas de question >
 -----------------
        \   ^__^
         \  (oo)\_______
            (__)\       )\/\
                ||----w |
                ||     ||
*/
/*****************************************************************************/
/** 6  **/
/*****************************************************************************/

create view presence_richelieu (acteur, debut, fin)
instead of(
	select acteur, count(debut) like debut, min(fin) like fin
	from distribution join programation
	having salle = "salle RICHELIEU"
	order by acteur
	group by debut, fin, acteur);
/*****************************************************************************/
/** 7  **/
/*****************************************************************************/
create view societaires(nom, stauts)
as
	select * from troupe where statut like '%0%'
	or statut like '%1%'
	or statut like '%2%'
	or statut like '%3%'
	or statut like '%4%'
	or statut like '%5%'
	or statut like '%6%'
	or statut like '%7%'
	or statut like '%8%'
	or statut like '%9%';
	-- oui c'est pas tres beaux mais on a jamais vue comment savoir si c'est un nombre
/*****************************************************************************/
/** 8 **/
/*****************************************************************************/
CREATE TRIGGER T_remove_troupe
after
delete
on troupe
for each row
execute function F_remove_troupe();


CREATE OR REPLACE FUNCTION F_remove_troupe() RETURNS trigger
AS $$
BEGIN
	insert INTO anciens VALUES(old.nom, old.statut);
	RAISE NOTICE '% a été enregistré(e) dans la table anciens', old.nom;
	RETURN old;
END;
$$ LANGUAGE 'plpgsql';
/*****************************************************************************/
/** 9 **/
/*****************************************************************************/
DELETE FROM troupe WHERE nom = 'François Portet';
DELETE FROM troupe WHERE nom = 'Gaëlle Lainé';
select * from anciens;
       nom       |    statut    
-----------------+--------------
 François Portet | pensionnaire
 Gaëlle Lainé    | 543
/*****************************************************************************/
/** 10 **/
/*****************************************************************************/
CREATE TRIGGER T_add_troupe
after
INSERT
on troupe
for each row
execute function F_add_troupe();

CREATE OR REPLACE FUNCTION F_remove_troupe() RETURNS trigger
AS $$
BEGIN
	if(new.statut not like '')
	THEN
		RETURN null;
	ELSE
		-- je veut fair un insert mais boucle infini :(
		RETURN new;
	END IF;
END;
$$ LANGUAGE 'plpgsql';
/*****************************************************************************/
/** 11 **/
/*****************************************************************************/

/*****************************************************************************/
/** 12 **/
/*****************************************************************************/

/*****************************************************************************/
/** 13 **/
/*****************************************************************************/

/*****************************************************************************/
/** 14 **/
/*****************************************************************************/
il doit coriger le scram-hsa-256 en scram-sha-256
						 ^^				   ^
/*****************************************************************************/
/** 15 **/
/*****************************************************************************/
acteur_exam_diiorioe
\du
/*****************************************************************************/
/** 16 **/
/*****************************************************************************/

/*****************************************************************************/
/** 17 **/
/*****************************************************************************/

/*****************************************************************************/
/** 18 **/
/*****************************************************************************/

/*****************************************************************************/
/** 19 **/
/*****************************************************************************/

/*****************************************************************************/
/** 20 **/
/*****************************************************************************/

/*****************************************************************************/
/** 21 **/
/*****************************************************************************/

