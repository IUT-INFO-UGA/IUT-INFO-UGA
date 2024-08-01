/*===================================================*/
/* NOM Prénom - TP03 : Triggers et fonctions simples */
/*===================================================*/
/*             List of relations
 Schema |     Name      | Type  |  Owner   
--------+---------------+-------+----------
 public | apparait_dans | table | xxxxxxx
 public | etat_civil    | table | xxxxxxx
 public | fan           | table | xxxxxxx
 public | favoris       | table | xxxxxxx
 public | film          | table | xxxxxxx
 public | mes_favoris   | view  | xxxxxxx
 public | meurt_dans    | view  | xxxxxxx
 public | personnage    | table | xxxxxxx
 public | realise       | table | xxxxxxx
*/
/*============================================================*/
/* Ex 1 : Trigger pour respecter une contrainte référentielle */
/*============================================================*/
/***********************************************************/
/* 1 - Supression d'un personnage                          */
/***********************************************************/
/*-----*/
/* 1.1  Lorsque l'on supprime un personnage, une contrainte de clé étrangère lève une erreur. Ecrire un trigger et la fonction associée qui, lors de la suppression d'un personnage, suppriment tous les enregistrements dépendant du personnage à supprimer, afin qu'aucune exception ne soit levée (attention à l'ordre des suppressions). Afin de rendre visibles ces effets de bords, faire en sorte que la fonction affiche une notice déclarant qu'un trigger est déclenché. */
/*-----*/
CREATE OR REPLACE FUNCTION f_supprimer_personnage() RETURNS TRIGGER
AS $$
	BEGIN
	RAISE NOTICE '% ON % FIRES %',TG_OP,TG_TABLE_NAME,TG_NAME;
	DELETE FROM apparait_dans WHERE nom = OLD.nom;
	DELETE FROM meurt_dans WHERE nom = OLD.nom;
	DELETE FROM etat_civil WHERE nom = OLD.nom;
	DELETE from favoris where login = OLD.nom;
	RETURN OLD;
	END;
$$ LANGUAGE 'plpgsql';

drop TRIGGER IF EXISTS T_supprimer_personnage ON personnage;
CREATE TRIGGER T_supprimer_personnage
BEFORE DELETE ON personnage
FOR EACH ROW
EXECUTE FUNCTION f_supprimer_personnage();

/*-----*/
/* 1.2 Expériences : Afficher le nom de vos personnages favoris accompagnés du nombre de fans (login) partageant ce lien (utiliser la vue mes_favoris pour écrire cette requête). Supprimer ensuite l'un de ces personnages de la table personnage, et constater la suppression des occurrences de ce personnage dans toutes les tables de la base. */
/*-----*/
SELECT nom, COUNT(nom) AS nb_fans
FROM mes_favoris
GROUP BY nom;

DELETE FROM personnage WHERE nom = 'Rocket';

/*-----*/
/* 1.3 En faire de même pour la suppression d'un fan. */
/*-----*/

--pas besoin ? pas d'erreur
CREATE OR REPLACE FUNCTION f_supprimer_fan() RETURNS TRIGGER
AS $$
	BEGIN
	RAISE NOTICE '% ON % FIRES %',TG_OP,TG_TABLE_NAME,TG_NAME;
	delete from 

insert into fan
values('arthur','thor', 2024);


/***********************************************************/
/*      Trigger pour réaliser un historique                */
/***********************************************************/

/*-----*/
/* 1.5 En préambule, insérer à nouveau le fan de login arthur. Puis créer la table historique_fan_base(heure,nb_fans,nb_likes), où heure est de type timestamp, qui va contenir chaque nouvelle valeur de nb_fans ou nb_likes au fil des opérations réalisées sur les tables de la base. Ne pas définir de clé primaire. */
/*-----*/
insert into fan
values('arthur','thor', 2024);

create or replace table historique_fan_base(
	heure timestamp default CURRENT_TIMESTAMP()
	
)
