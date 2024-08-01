-- ARTISTE
\copy ARTISTE FROM '/users/info/pub/1a/R1.05/TP4/artiste.csv' WITH (DELIMITER ';', format CSV, HEADER, ENCODING 'UTF8');
-- NUMERO
\copy NUMERO FROM '/users/info/pub/1a/R1.05/TP4/numero.csv' WITH (DELIMITER ';', format CSV, HEADER, ENCODING 'UTF8');
-- INTERPRETE
\copy INTERPRETE FROM '/users/info/pub/1a/R1.05/TP4/interprete.csv' WITH (DELIMITER ';', format CSV, HEADER, ENCODING 'UTF8');
-- ACCESSOIRE
\copy ACCESSOIRE FROM '/users/info/pub/1a/R1.05/TP4/accessoire.csv' WITH (DELIMITER ';', format CSV, HEADER, ENCODING 'UTF8');
-- UTILISATION
\copy UTILISATION FROM '/users/info/pub/1a/R1.05/TP4/utilisation.csv' WITH (DELIMITER ';', format CSV, HEADER, ENCODING 'UTF8');
-- LIEU
\copy LIEU FROM '/users/info/pub/1a/R1.05/TP4/lieu.csv' WITH (DELIMITER ';', format CSV, HEADER, ENCODING 'UTF8');
-- REPRESENTATION (dates mises à jour dynamiquement, d'une année à l'autre)
INSERT INTO REPRESENTATION VALUES('R1LYO',make_date((extract(year from current_date))::integer,10,14),'15:00:00','L1_LYON');
INSERT INTO REPRESENTATION VALUES('R1GRE',make_date((extract(year from current_date))::integer,12,19),'20:00:00','L2_GRENOBLE');
INSERT INTO REPRESENTATION VALUES('R2GRE',make_date((extract(year from current_date))::integer,12,23),'14:00:00','L1_GRENOBLE');
INSERT INTO REPRESENTATION VALUES('R3GRE',make_date((extract(year from current_date))::integer,12,23),'19:30:00','L1_GRENOBLE');
INSERT INTO REPRESENTATION VALUES('R1ANN',make_date((extract(year from current_date)+1)::integer,2,24),'20:00:00','L1_ANNECY');
-- PRESENTE
\copy PRESENTE FROM '/users/info/pub/1a/R1.05/TP4/presente.csv' WITH (DELIMITER ';', format CSV, HEADER, ENCODING 'UTF8');
