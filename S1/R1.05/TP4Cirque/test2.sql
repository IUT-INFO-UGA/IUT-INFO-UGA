--------------------------------------------------------------------------------
          -- TESTS DE CONFORMITÉ DES RELATIONS CRÉÉES --
--------------------------------------------------------------------------------


--------------------------------------------------------------------------------
--  INSTRUCTION N°0 : préliminaires...
INSERT INTO ARTISTE VALUES('Bozzo', 'clown'), ('Gary','jongleur');

/* ATTENDU :
INSERT 0 2
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°1
INSERT INTO NUMERO VALUES('Faux Numéro', 'Bozzo');

/* ATTENDU :
ERROR:  null value in column "duree" of relation "numero" violates not-null constraint
DETAIL:  Failing row contains (Faux Numéro, Bozzo, null).
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°2
INSERT INTO NUMERO VALUES('Faux Numéro', 'Bozzo','00:30:01');

/* ATTENDU :
ERROR:  new row for relation "numero" violates check constraint "numero_duree_check"
DETAIL:  Failing row contains (Faux Numéro, Bozzo, 00:30:01).
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°3
INSERT INTO NUMERO VALUES('Faux Numéro', 'Bozzo','00:14:59');

/* ATTENDU :
ERROR:  new row for relation "numero" violates check constraint "numero_duree_check"
DETAIL:  Failing row contains (Faux Numéro, Bozzo, 00:14:59).
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°4
INSERT INTO NUMERO VALUES('Faux Numéro', 'Bozzo','00:25:45'),
                          ('Abonné absent', 'Bozzo','00:30:00');
/* ATTENDU :
INSERT 0 2
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°4
INSERT INTO LIEU VALUES('L1');
/* ATTENDU :
ERROR:  null value in column "adresse" of relation "lieu" violates not-null constraint
DETAIL:  Failing row contains (L1, null, null).
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°5
INSERT INTO LIEU VALUES('L1','ici');

/* ATTENDU :
INSERT 0 1
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°6
INSERT INTO LIEU VALUES('L1','là');

/* ATTENDU :
ERROR:  duplicate key value violates unique constraint "lieu_pkey"
DETAIL:  Key (idlieu)=(L1) already exists.
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°7
INSERT INTO LIEU VALUES('L2','là', 'http://et_ici_aussi');

/* ATTENDU :
ERROR:  new row for relation "lieu" violates check constraint "lieu_siteweb_check"
DETAIL:  Failing row contains (L2, là, http://et_ici_aussi).
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°8
INSERT INTO LIEU VALUES('L2','là', 'https://et_ici_aussi');

/* ATTENDU :
INSERT 0 1
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°9
INSERT INTO REPRESENTATION(CodeRep) VALUES ('REP1');

/* ATTENDU :
ERROR:  null value in column "date" of relation "representation" violates not-null constraint
DETAIL:  Failing row contains (REP1, null, null, null, 00:30:00).
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°10
INSERT INTO REPRESENTATION VALUES ('REP1',current_date+7);

/* ATTENDU :
ERROR:  null value in column "heuredebut" of relation "representation" violates not-null constraint
DETAIL:  Failing row contains (REP1, 2022-12-05, null, null).
*/
-- NOTE : la date affichée dans la ligne détail, dépend de la date où a été fait le test

--------------------------------------------------------------------------------
-- INSTRUCTION n°11
INSERT INTO REPRESENTATION VALUES ('REP1',current_date+7,'11:00:00');

/* ATTENDU :
ERROR:  null value in column "idlieu" of relation "representation" violates not-null constraint
DETAIL:  Failing row contains (REP1, 2022-12-05, 11:00:00, null).
*/
-- NOTE : la date affichée dans la ligne détail, dépend de la date où a été fait le test

--------------------------------------------------------------------------------
-- INSTRUCTION n°12
INSERT INTO REPRESENTATION VALUES ('REP1',current_date+7,'22:00:01','L1');

/* ATTENDU :
ERROR:  new row for relation "representation" violates check constraint "representation_heuredebut_check"
DETAIL:  Failing row contains (REP1, 2022-12-05, 22:00:01, L1).
*/
-- NOTE : la date affichée dans la ligne détail, dépend de la date où a été fait le test

--------------------------------------------------------------------------------
-- INSTRUCTION n°13
INSERT INTO REPRESENTATION VALUES ('REP1',current_date+7,'9:59:59','L1');

/* ATTENDU :
ERROR:  new row for relation "representation" violates check constraint "representation_heuredebut_check"
DETAIL:  Failing row contains (REP1, 2022-12-05, 09:59:59, L1).
*/
-- NOTE : la date affichée dans la ligne détail, dépend de la date où a été fait le test
--------------------------------------------------------------------------------
-- INSTRUCTION n°14
INSERT INTO REPRESENTATION VALUES ('REP1',current_date+7,'11:00:00','L1');

/* ATTENDU :
INSERT 0 1
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°15
INSERT INTO REPRESENTATION VALUES ('REP1',current_date+15,'11:00:00','L2');

/* ATTENDU :
ERROR:  duplicate key value violates unique constraint "representation_pkey"
DETAIL:  Key (coderep)=(REP1) already exists.
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°16
INSERT INTO REPRESENTATION VALUES ('REP2',current_date+15,'11:00:00','L3');

/* ATTENDU :
ERROR:  insert or update on table "representation" violates foreign key constraint "representation_idlieu_fkey"
DETAIL:  Key (idlieu)=(L3) is not present in table "lieu"..
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°17
INSERT INTO PRESENTE VALUES ('REP3', 'Faux Numéro');

/* ATTENDU :
ERROR:  null value in column "ordrepassage" of relation "presente" violates not-null constraint
DETAIL:  Failing row contains (REP3, Faux Numéro, null).
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°18
INSERT INTO PRESENTE VALUES ('REP3', 'Faux Numéro',-3);

/* ATTENDU :
ERROR:  new row for relation "presente" violates check constraint "presente_ordrepassage_check"
DETAIL:  Failing row contains (REP3, Faux Numéro, -3).
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°19
INSERT INTO PRESENTE VALUES ('REP3', 'Faux Numéro',2);

/* ATTENDU :
ERROR:  insert or update on table "presente" violates foreign key constraint "presente_coderep_fkey"
DETAIL:  Key (coderep)=(REP3) is not present in table "representation".
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°20
INSERT INTO PRESENTE VALUES ('REP1', 'Faux Numéro',2);


/* ATTENDU :
INSERT 0 1
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°21
INSERT INTO PRESENTE VALUES ('REP1', 'Abonné présent',2);

/* ATTENDU :
ERROR:  duplicate key value violates unique constraint "presente_coderep_ordrepassage_key"
DETAIL:  Key (coderep, ordrepassage)=(REP1, 2) already exists.
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°22
INSERT INTO PRESENTE VALUES ('REP1', 'Abonné présent',1);

/* ATTENDU :
ERROR:  insert or update on table "presente" violates foreign key constraint "presente_titre_fkey"
DETAIL:  Key (titre)=(Abonné présent) is not present in table "numero".
*/

--------------------------------------------------------------------------------
-- INSTRUCTION n°23
INSERT INTO PRESENTE VALUES ('REP1', 'Abonné absent',1);

/* ATTENDU :
INSERT 0 1
*/

--------------------------------------------------------------------------------
-- FIN !!!
--------------------------------------------------------------------------------
