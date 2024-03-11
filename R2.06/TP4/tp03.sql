/*=======================================================*/
/* THUILLIER Manu - TP03 : Triggers et fonctions simples */
/*=======================================================*/

/*============================================================*/
/* Ex 1 : Trigger pour respecter une contrainte référentielle */
/*============================================================*/
/***********************************************************/
/* 1 - Supression d'un personnage                          */
/***********************************************************/
CREATE OR REPLACE FUNCTION f_suppr_dependance() RETURNS trigger
AS $$
BEGIN
    DELETE FROM apparait_dans WHERE nom = old.nom;
    DELETE FROM etat_civil WHERE nom = old.alias;
    DELETE FROM favoris WHERE perso = old.nom;
    RAISE NOTICE 'Suppression dans apparait_dans, etat_civil, favoris suite à l''exécution du trigger %', TG_NAME;
    RETURN old;
END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER t_suppr_dependance
BEFORE DELETE
ON personnage
FOR EACH ROW
EXECUTE FUNCTION f_suppr_dependance();
/***********************************************************/
/* 2 - Supression d'un personnage                          */
/***********************************************************/
SELECT * FROM mes_favoris;
DELETE FROM personnage WHERE nom = 'La Valkyrie';
SELECT * FROM mes_favoris;

/***********************************************************/
/* 3 - Supression d'un fan                          */
/***********************************************************/
CREATE OR REPLACE FUNCTION f_suppr_fan() RETURNS trigger
AS $$
BEGIN
    DELETE FROM favoris WHERE login = old.login;
    RAISE NOTICE 'Suppression dans favoris suite à l''exécution du trigger %', TG_NAME;
    RETURN old;
END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER t_suppr_fan
BEFORE DELETE
ON fan
FOR EACH ROW
EXECUTE FUNCTION f_suppr_fan();

/*============================================================*/
/* Ex 2 : Trigger pour réaliser un historique */
/*============================================================*/

/***********************************************************/
/* 5 - Création de historique_fan_base                     */
/***********************************************************/
INSERT INTO fan VALUES ('arthur', 2024);
CREATE TABLE historique_fan_base (
    heure timestamp,
    nb_fans int,
    nb_likes int
);

/***********************************************************/
/* 6 - Insérer dans historique_fan_base                     */
/***********************************************************/
INSERT INTO historique_fan_base VALUES (CURRENT_TIMESTAMP, (SELECT count(*) FROM fan), (SELECT count(*) FROM favoris));

/***********************************************************/
/* 7 - Insérer dans historique_fan_base                     */
/***********************************************************/
INSERT INTO historique_fan_base
SELECT CURRENT_TIMESTAMP, count(DISTINCT(fan.login)) AS nb_fans, count(favoris.*) AS nb_likes
FROM fan LEFT JOIN favoris ON fan.login = favoris.login;

/***********************************************************/
/* 8 - Création trigger insertion                     */
/***********************************************************/
CREATE OR REPLACE FUNCTION f_ajout_log_histo() RETURNS trigger
AS $$
BEGIN
    INSERT INTO historique_fan_base VALUES (CURRENT_TIMESTAMP, (SELECT count(*) FROM fan), (SELECT count(*) FROM favoris));
    RAISE NOTICE 'Ajout d''une log dans historique_fan_base suite à l''exécution du trigger % dans la table %', TG_NAME, TG_TABLE_NAME;
    RETURN new;
END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER t_ajout_log_histo
AFTER INSERT OR DELETE
ON favoris
FOR EACH ROW
EXECUTE FUNCTION f_ajout_log_histo();

INSERT INTO favoris VALUES ('arthur', 'Ant-Man'), ('arthur', 'Black Panther');
DELETE FROM favoris WHERE login = 'arthur' AND perso = 'Black Panther';

-- n lignes sont créées pour n ajouts ou n suppressions dans la table favoris. Ce n'est pas optimal.

/***********************************************************/
/* 9 - Création trigger insertion                     */
/***********************************************************/

DROP TRIGGER t_ajout_log_histo ON favoris;
CREATE TRIGGER t_ajout_log_histo
AFTER INSERT OR DELETE
ON favoris
FOR EACH STATEMENT
EXECUTE FUNCTION f_ajout_log_histo();

-- 1 ligne est ajoutée par instruction, et non lignes ajoutées


/***********************************************************/
/* 10 - Création trigger insertion fan                     */
/***********************************************************/
CREATE TRIGGER t_ajout_log_histo
AFTER INSERT OR DELETE
ON fan
FOR EACH STATEMENT
EXECUTE FUNCTION f_ajout_log_histo();

/*============================================================*/
/* Ex 3 : Trigger pour réaliser le journal de bord d'une table (log) */
/*============================================================*/


/***********************************************************/
/* 11 - Création table favoris log                     */
/***********************************************************/
CREATE TABLE favoris_log(
    modifie_par varchar default current_user,
    modifie_a timestamp default CURRENT_TIMESTAMP,
    operation varchar,
    primary key (modifie_par, modifie_a)
);


/***********************************************************/
/* 12 - Création table favoris log                     */
/***********************************************************/
CREATE OR REPLACE FUNCTION f_ajout_log_favoris() RETURNS trigger
AS $$
BEGIN
    INSERT INTO favoris_log (operation) VALUES (TG_OP);
    RAISE NOTICE 'Ajout d''une log dans favoris_log suite à l''exécution du trigger % dans la table %', TG_NAME, TG_TABLE_NAME;
    RETURN NULL;
END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER t_ajout_log_favoris
BEFORE DELETE OR INSERT OR UPDATE
ON favoris
FOR EACH STATEMENT
EXECUTE FUNCTION f_ajout_log_favoris();


/***********************************************************/
/* 13 - Expériences favoris log                     */
/***********************************************************/
INSERT INTO fan VALUES ('arthur', 2024);
INSERT INTO favoris VALUES ('arthur', 'Ant-Man'), ('arthur', 'Black Panther');
DELETE FROM fan WHERE login = 'arthur';

/*============================================================*/
/* Ex 4 : Trigger pour réaliser un historique (un autre) */
/*============================================================*/


/***********************************************************/
/* 14 - Création historique_sans_favori                     */
/***********************************************************/
INSERT INTO fan VALUES ('arthur', 2024);
CREATE TABLE historique_sans_favori (
    heure timestamp,
    nb_fans_sans_favori int,
    nb_perso_sans_like int
);


/***********************************************************/
/* 15 & 16 - Insertion historique_sans_favori                     */
/***********************************************************/
INSERT INTO historique_fan_base VALUES (CURRENT_TIMESTAMP, (SELECT count(*) FROM fan WHERE login NOT IN (SELECT login FROM favoris)), (SELECT count(*) FROM personnage WHERE nom NOT IN (SELECT perso FROM favoris)));

INSERT INTO historique_fan_base
SELECT CURRENT_TIMESTAMP, count(fan.login) AS nb_fans, count(personnage.nom) AS nb_likes
FROM fan FULL JOIN favoris ON fan.login = favoris.login FULL JOIN personnage ON personnage.nom = favoris.perso WHERE favoris.login IS NULL OR favoris.perso IS NULL;


/***********************************************************/
/* 17 - Création trigger historique_sans_favori            */
/***********************************************************/
CREATE OR REPLACE FUNCTION f_ajout_log_sans_favoris() RETURNS trigger
AS $$
BEGIN
    INSERT INTO historique_sans_favori VALUES (CURRENT_TIMESTAMP, (SELECT count(*) FROM fan WHERE login NOT IN (SELECT login FROM favoris)), (SELECT count(*) FROM personnage WHERE nom NOT IN (SELECT perso FROM favoris)));
    RAISE NOTICE 'Ajout d''une log dans historique_sans_favori suite à l''exécution du trigger % dans la table %', TG_NAME, TG_TABLE_NAME;
    RETURN NULL;
END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER t_ajout_log_sans_favoris
AFTER DELETE OR INSERT OR UPDATE
ON favoris
FOR EACH STATEMENT
EXECUTE FUNCTION f_ajout_log_sans_favoris();

CREATE TRIGGER t_ajout_log_sans_favoris
AFTER DELETE OR INSERT OR UPDATE
ON fan
FOR EACH STATEMENT
EXECUTE FUNCTION f_ajout_log_sans_favoris();

CREATE TRIGGER t_ajout_log_sans_favoris
AFTER DELETE OR INSERT OR UPDATE
ON personnage
FOR EACH STATEMENT
EXECUTE FUNCTION f_ajout_log_sans_favoris();


/***********************************************************/
/* 17 - Expérience trigger historique_sans_favori            */
/***********************************************************/
INSERT INTO favoris VALUES ('arthur', 'Ant-Man'), ('arthur', 'Black Panther');
INSERT INTO personnage VALUES ('Wolverine');
UPDATE favoris SET perso = 'Wolverine' WHERE login = 'arthur' AND perso = 'Ant-Man';
DELETE FROM fan WHERE login = 'arthur';
