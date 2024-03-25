-- 1. Triggers pour vérifier des contraintes complexes
---1.1 Adhérent
---- 1.1.1 Contrainte : Un adhérent ne peut pas perdre l'agrément skipper. Ecrire le trigger et sa fonction associée permettant le respect de cette contrainte. Pour annuler une instruction fautive, lever une exception avec un message explicatif précis.
CREATE OR REPLACE FUNCTION verif_agrement_skipper() returns trigger
as '
begin
	if old.skipper = true and new.skipper = false then
		raise exception ''Un adhérent ne peut pas perdre l''''agrément skipper'';
	end if;
	return new;
end ' language 'plpgsql';

create or replace trigger t_verif_agrement_skipper
before update on adherent
for each row
execute function verif_agrement_skipper();

---- 1.1.2 Expérience : Vérifier que le trigger annule bien une instruction contrevenant à cette contrainte d'intégrité.
update adherent set skipper = false where telephone='04-76-12-34-56';
---- 1.1.3 Expérience : Vérifier que le trigger n'empêche pas l'acquisition de l'agrément skipper par l'adhérent numéro 18.
update adherent set skipper = true where numadh=18;

--- 1.2 Course
---- 1.2.4 Contrainte : Le seul jour commun possible entre deux courses est le dernier jour de l'une et le premier jour de l'autre. Ecrire le trigger et sa fonction associée permettant le respect de cette contrainte. Nous vous invitons à utiliser la fonction OVERLAPS. Pour annuler une instruction fautive, lever une exception avec un message explicatif précis.
create or replace function verif_overlaps() returns trigger
as $$
begin
	if exists (
		select *
		from course c1
		where (c1.datedebut, c1.datefin) overlaps (new.datedebut, new.datefin) and c1.numcourse != new.numcourse
	) 
	then
	raise exception 'cette date et deja occupée';
	end if;
	return new;
end $$ language 'plpgsql';

create or replace trigger t_verif_overlaps
before INSERT or update on course
for each row
execute function verif_overlaps();

---- 1.2.5 Expérience : Vérifier que le trigger annule bien une instruction contrevenant à cette contrainte d'intégrité.
insert into course (numcourse, port, datedebut, datefin) values (3, 'St-Malo', '2021-05-07', '2021-05-10');
---- 1.2.6 Expérience : Vérifier que le trigger n'empêche pas la création d'une course se tenant du 05 mai 2021 au 06 mai 2021 à Lorient.
insert into course (numcourse, port, datedebut, datefin) values (3, 'lorient', '2021-05-05', '2021-05-06');

--- 1.3 Chef de bord
---- 1.3.7 Contraintes : Un adhérent doit avoir l'agrément skipper pour être le chef de bord d'un bateau pour une course. Par ailleurs, un adhérent ne peut être à la fois chef de bord et équipier pour une même course. Ecrire le trigger et sa fonction associée permettant le respect de ces contraintes lors des actions sur chefdebord. Pour annuler une instruction fautive, lever une exception avec un message explicatif précis.

fonctionne pas
create or replace function f_verif_skiper() returns trigger
as $$
begin
	if exists(
		select *
		from equipier e, adherent a
		where a.skipper and new.numadh != e.numadh and a.numadh = e.numadh
	)
	then
	raise exception 'erreur avec l''exercice 1.3.7';
	end if;
	return new;
end $$ language 'plpgsql';

create or replace trigger t_verif_skiper
before INSERT or update on chefdebord
for each row
execute function f_verif_skiper();
----- 1.3.8 Expérience : Vérifier que le trigger annule bien une instruction contrevenant à cette contrainte d'intégrité. Par exemple, l'enregistrement de l'adhérent 3 comme chef de bord du bateau 4 pour la course 2. Ou encore le remplacement de l'adhérent 2 par l'adhérent 10 pour être chef de bord du bateau 3 pour la course 1.
insert into chefdebord (numcourse, numbat, numadh) values (2, 4, 3);
delete from chefdebord where numadh=3;
----- 1.3.9 Expérience : Vérifier que le trigger n'empêche pas l'enregistrement de l'adhérent 5 comme chef de bord du bateau 4 pour la course 2.
insert into chefdebord (numcourse, numbat, numadh) values (2, 4, 5);
