/*================================================================*/
/* NOM Prénom - TP01 : Révisions - BD relationnelle et SQL simple */
/*================================================================*/

/*********************/
/* 1.1 Nous souhaitons ajouter la possibilité à un personnage de pouvoir mourir dans plusieurs films. */
/*********************/

alter table meurt_dans drop CONSTRAINT meurt_dans_pkey;

/*********************/
/* 1.2 Nous souhaitons ajouter la possibilité à un personnage de pouvoir mourir dans plusieurs films. */
/*********************/

alter table apparait_dans ADD COLUMN y_meurt boolean default false;
update apparait_dans
set y_meurt = true
where (numero, nom) in (select * from meurt_dans);
drop table meurt_dans;

/*********************/
/* 1.3 Si une application tiers utilisait la table meurt_dans il convient de créer une vue qui la reproduise. Quel nom doit avoir cette vue? Pourquoi une vue et pas une table (temporaire)? Créer cette vue et en afficher le contenu. */
/*********************/

create view meurt_dans as
	select numero, nom
	from apparait_dans
	where y_meurt;

/*********************/
/* 1.4 Enregistrer, dans apparait_dans, la mort du Soldat de l'hiver dans le film 5, et celle de Nick Fury dans le film 9 */
/*********************/
insert into apparait_dans 
values (5, 'Soldat de l''hiver', false, true);
// ne fonctionne pas donc update
update apparait_dans
set y_meurt=true
where nom='Soldat de l''hiver' and numero=5;

insert into apparait_dans 
values (9, 'Nick Fury', false, true);
// ne fonctionne pas donc update
update apparait_dans
set y_meurt=true
where nom='Nick Fury' and numero=9;

/*********************/
/* 1.5 Afficher le nouveau contenu de cette nouvelle vue. Qu'observez-vous? Executer la commande postgresql \d et retrouver la vue créée. */
/*********************/
\d meurt_dans;

/*********************/
/* 2.6 La table fan_base doit elle être une table permanente ou temporaire? La créer de façon classique (sans requête) avec trois attributs: */
/*********************/

create TEMPORARY table fan_base(
	login varchar,
	nom varchar,
	annee int
);

/*********************/
/* 2.7 Alimenter cette table avec les données contenues dans le fichier /users/info/pub/1a/R2.06/bases/avengers/fan_base.csv grâce à la commande postgreSQL \copy. Indications: */
/*********************/

\copy fan_base from '/users/info/pub/1a/R2.06/bases/avengers/fan_base.csv' (DELIMITER ';', format CSV, HEADER, ENCODING 'UTF8');

/*********************/
/* 2.8 Créer les deux tables fan et favoris grâce à deux requêtes, puis en ajoutant les contraintes de clé primaire et étrangère. */
/*********************/

create table fan
	as select distinct login, annee from fan_base;

alter table fan add primary key(login);

create table favoris(login, perso) 
	as select distinct login, nom from fan_base where nom is not null;
	alter table favoris add primary key(login, perso);
	alter table favoris add foreign key (login) references fan(login);
	alter table favoris add foreign key (perso) references personnage(nom);
/*********************/
/* 2.9  On souhaite à présent donner un accès spécifique à chaque fan. Pour cela, créer une vue mes_favoris donnant le nom des personnages favoris de l'utilisateur postgreSQL connecté. */
/*********************/

create or replace view mes_favoris as
	select perso
	from favoris natural join fan
	where login = user;

/*********************/
/* 2.10 Afficher les éléments de votre base par la commande \d. Déconnectez-vous puis reconnectez-vous à postgres-info. Constatez le ou les éléments qui ont disparu. */
/*********************/

/*********************/
/*3.11 Construire une première table temporaire couples(nom1,nom2,ne) donnant, pour chaque paire de personnages, le nombre de films dans lesquels ils apparaissent ensemble. Attention, une paire de personnages ne doit être présente qu'une seule fois dans cette table, quel que soit l'ordre entre leurs noms. */
/*********************/

create TEMPORARY table couples
as select c1.nom as nom1, c2.nom as nom2, count(*) as ne
from apparait_dans c1, apparait_dans c2 
where c1.numero=c2.numero and c1.nom < c2.nom
group by c1.nom, c2.nom;

/*********************/
/*3.12 Construire une deuxième table temporaire filmo(nom,nf) donnant, pour chaque personnage, le nombre de films dans lesquels il apparaît.*/
/*********************/

create TEMPORARY table filmo
as select nom, count(*) as nf
from apparait_dans
group by nom;

/*********************/
/*3.13 Construire une dernière table temporaire proches(nom1,nom2,dist) donnant, pour chaque paire de personnages proches, leur distance. Les résultats seront ordonnés par distance, puis par ordre lexicographique de nom1. distance = nf1+nf2-2*ne*/
/*********************/

create TEMPORARY table proches
as select c.nom1, c.nom2, (f1.nf+f2.nf-2*c.ne) as distance
from couples c join filmo f1 on c.nom1=f1.nom join filmo f2 on c.nom2=f2.nom
order by  distance desc, nom1;

/*********************/
/*3.14 Exporter le contenu de cette table dans un fichier CSV nommé proches.csv. */
/*********************/

\copy proches to './proches.csv' (DELIMITER ';', format CSV, HEADER, ENCODING 'UTF8');

/*
 _______________
< c'est fini !!! >
 ---------------
        \   ^__^
         \  (oo)\_______
            (__)\       )\/\
                ||----w |
                ||     ||
*/