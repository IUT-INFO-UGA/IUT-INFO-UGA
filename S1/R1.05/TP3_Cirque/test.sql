--------------------------------------------------------------------------------
          -- TESTS DE CONFORMITÉ DES RELATIONS CRÉÉES --
--------------------------------------------------------------------------------


--------------------------------------------------------------------------------
--  INSTRUCTION n°1

INSERT INTO INTERPRETE VALUES ('Bozzo','Les Zappatas');

/* ATTENDU :
ERROR:  insert or update on table "interprete" violates foreign key constraint "interprete_surnom_fkey"
DETAIL:  Key (surnom)=(Bozzo) is not present in table "artiste".
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°2

INSERT INTO NUMERO VALUES ('Les Zappatas', 'Bozzo');

/* ATTENDU :
ERROR:  insert or update on table "numero" violates foreign key constraint "numero_responsable_fkey"
DETAIL:  Key (responsable)=(Bozzo) is not present in table "artiste".
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°3
INSERT INTO ARTISTE VALUES ('Bozzo');

/* ATTENDU :
ERROR:  null value in column "specialite" of relation "artiste" violates not-null constraint
DETAIL:  Failing row contains (Bozzo, null).
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°4

INSERT INTO ARTISTE VALUES ('Bozzo','Grand chef');

/* ATTENDU :
ERROR:  new row for relation "artiste" violates check constraint "c_specialite"
DETAIL:  Failing row contains (Bozzo, Grand chef).
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°5
INSERT INTO ARTISTE VALUES ('Bozzo','clown');

/* ATTENDU :
INSERT 0 1
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°6
INSERT INTO ARTISTE VALUES ('Bozzo','jongleur');

/* ATTENDU :
ERROR:  duplicate key value violates unique constraint "artiste_pkey"
DETAIL:  Key (surnom)=(Bozzo) already exists.
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°7
INSERT INTO ARTISTE VALUES ('Gary','jongleur'), ('Volante', 'acrobate');

/* ATTENDU :
INSERT 0 2
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°8
INSERT INTO NUMERO VALUES ('Les Zappatas');

/* ATTENDU :
ERROR:  null value in column "responsable" of relation "numero" violates not-null constraint
DETAIL:  Failing row contains (Les Zappatas, null).
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°9
INSERT INTO NUMERO VALUES ('Les Zappatas','Bozzo'), ('Rigolo', 'Bozzo');

/* ATTENDU :
INSSERT 0 2
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°10
INSERT INTO NUMERO VALUES ('Les Zappatas','Gary');

/* ATTENDU :
ERROR:  duplicate key value violates unique constraint "numero_pkey"
DETAIL:  Key (titre)=(Les Zappatas) already exists.
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°11
INSERT INTO INTERPRETE VALUES ('Gary','MilleBalles');

/* ATTENDU :
ERROR:  insert or update on table "interprete" violates foreign key constraint "interprete_titre_fkey"
DETAIL:  Key (titre)=(MilleBalles) is not present in table "numero".
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°12
INSERT INTO INTERPRETE VALUES
('Gary','Les Zappatas'), ('Bozzo', 'Les Zappatas'), ('Volante', 'Les Zappatas');

/* ATTENDU :
INSERT 0 3
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°13
INSERT INTO UTILISATION (CodeAcc, SurNom, Titre) VALUES (123,'Gary','Les Zappatas');

/* ATTENDU :
ERROR:  insert or update on table "utilisation" violates foreign key constraint "utilisation_codeacc_fkey"
DETAIL:  Key (codeacc)=(123) is not present in table "accessoire".
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°14
INSERT INTO ACCESSOIRE (CodeAcc) VALUES (1);

/* ATTENDU :
ERROR:  null value in column "immatcamion" of relation "accessoire" violates not-null constraint
DETAIL:  Failing row contains (1, autre, null, null).
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°15
INSERT INTO ACCESSOIRE (CodeAcc,ImmatCamion) VALUES (1,'ABCDEFG');

/* ATTENDU :
ERROR:  new row for relation "accessoire" violates check constraint "accessoire_immatcamion_check"
DETAIL:  Failing row contains (1, autre, null, ABCDEFG  ).
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°16
INSERT INTO ACCESSOIRE (CodeAcc,ImmatCamion) VALUES (1,'DG-BRO-7B');

/* ATTENDU :
INSSERT 0 1
*/
--  Vérification :
SELECT * FROM ACCESSOIRE;
/*
codeacc | type  | couleur | immatcamion
---------+-------+---------+-------------
      1 | autre |         | DG-BRO-7B
(1 row)
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°17
INSERT INTO ACCESSOIRE (Type,Couleur,ImmatCamion) VALUES
('cerceau','rouge','DG-BRO-7B');

/* ATTENDU :
ERROR:  null value in column "codeacc" of relation "accessoire" violates not-null constraint
DETAIL:  Failing row contains (null, cerceau, rouge, DG-BRO-7B).
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°18
INSERT INTO ACCESSOIRE VALUES (2,'cerceau','magenta','DG-BRO-7B');

/* ATTENDU :
ERROR:  new row for relation "accessoire" violates check constraint "accessoire_couleur_check"
DETAIL:  Failing row contains (2, cerceau, magenta, DG-BRO-7B).
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°19
INSERT INTO ACCESSOIRE VALUES (2,'cerceau','violet','DG-BRO-7B');

/* ATTENDU :
INSERT 0 1
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°20
INSERT INTO UTILISATION VALUES (2,'Bozzo');

/* ATTENDU :
ERROR:  null value in column "titre" of relation "utilisation" violates not-null constraint
DETAIL:  Failing row contains (2, Bozzo, null).
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°21
INSERT INTO UTILISATION VALUES (2,'Bozzo','MilleBalles');

/* ATTENDU :
ERROR:  insert or update on table "utilisation" violates foreign key constraint "utilisation_surnom_titre_fkey"
DETAIL:  Key (surnom, titre)=(Bozzo, MilleBalles) is not present in table "interprete".
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°22
INSERT INTO UTILISATION VALUES (2,'Bozzo','Les Zappatas'), (1,'Gary','Rigolo');

/* ATTENDU :
ERROR:  insert or update on table "utilisation" violates foreign key constraint "utilisation_surnom_titre_fkey"
DETAIL:  Key (surnom, titre)=(Gary, Rigolo) is not present in table "interprete".
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°23
INSERT INTO UTILISATION VALUES
(2, 'Bozzo', 'Les Zappatas'), (2,'Gary','Les Zappatas'), (1,'Volante','Les Zappatas');

/*
INSERT 0 3
*/

--------------------------------------------------------------------------------
-- FIN !!!
--------------------------------------------------------------------------------
