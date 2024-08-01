/*=====================================================================*/
/* NOM Prénom - TP06 : Mise en place d'un serveur de bases de données  */
/*=====================================================================*/

/***********************************************************/
/* 1 - Installation du programme.                          */
/***********************************************************/
-- Vérifier l'espace disque encore disponible : 
-- 1.6go
/*
Installer le programme postgresql en vérifiant que la taille des packages une fois installés est compatible avec l'espace encore disponible (noter dans votre compte-rendu cette taille additionnelle nécessaire) :

apt install postgresql

Noter la nouvelle taille de l'espace disque disponible.
1.3go
 À l'aide de la commande ps -ef, noter la commande (et ses arguments) qui est exécutée pour lancer le serveur (vous pourrez filtrer le résultat de cette commande pour ne garder que les lignes utiles).
postgres -D var/lib/ppostgresql/10/main -c config_file=/etc/postgresql/15/main/porstgresql.conf

 Mettre au propre dans votre compte-rendu un résumé des étapes ainsi suivies.
1.  R2.06-lance-machine-virtuelle
2. etu -> etu
3. sudo -i
4.	apt update
	apt upgrade
	apt clean
5. apt install postgresql
6. pg_lsclusters
*/

/***********************************************************/
/* 2 - Installation du programme.                          */
/***********************************************************/


/*Consulter le fichier de log et recopier dans votre compte-rendu les lignes expliquant cet échec de connexion.
peer authentification failled for user xxxxxxx
connection matched pg_hba.conf ligne 95 "local all all peer"

/************************************************************/
/* 3 - Création d'une base et des utilisateurs.             */
/***********************************************************/
*/
create user guy;
create user michal;
create user merlu;
create user morue;
create user limande;