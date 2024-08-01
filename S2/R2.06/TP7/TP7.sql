/*==============================================*/
/* NOM Prénom - TP07 : Utilisateurs et droits   */
/*==============================================*/

/*==========================================*/
/* 1 - Définition des rôles-groupes         */
/*==========================================*/

--1
create role bureau;
create role president in role bureau;
create role secretaire in role bureau;
create role tresorier in role bureau;
create role adherent;
--2
grant president to aflau;
grant tresorier to guy;
grant secretaire to michal;

/*==========================================*/
/* 2 - Droits sur la base                   */
/*==========================================*/

-- 5
-- on a pas le mdp et pas le droit de se connecter depuis l'exterieur

/*==========================================*/
/* 3 - Droits sur les tables et vues        */
/*==========================================*/

-- 3.1 Création des tables

-- 3.1.7 Exécuter \i /users/info/pub/1a/R2.06/bases/voile/create_base.sql.

-- 3.2 Droits sur les tables

-- 3.3 Président

-- 3.3.9
reasign owner 