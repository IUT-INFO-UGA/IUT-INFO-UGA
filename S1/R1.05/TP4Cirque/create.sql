create table ARTISTE(
	Surnom varchar(20) primary key,
	Specialite varchar NOT NULL,
	CONSTRAINT c_specialite check ( Specialite in ( 'jongleur', 'clown', 'acrobate', 'équilibriste'))
); 

create table NUMERO(
	Titre varchar primary key,
	Responsable varchar(20) references ARTISTE (Surnom)
);

create table INTERPRETE(
	Surnom varchar(20) references ARTISTE (Surnom),
	Titre varchar references NUMERO (Titre),
	primary key (Surnom, Titre)
);

create table ACCESSOIRE(
	CodeAcc numeric(3) primary key,
	Type varchar(20) not null check ( Type in ('ballon', 'cerceau', 'foulard', 'quilles', 'trapèze', 'corde', 'autre')) default 'autre',
	Couleur varchar check (Couleur in ('blanc', 'noir', 'rouge', 'bleu', 'vert', 'jaune', 'orange', 'violet')),
	ImmatCamion char(9) check (ImmatCamion like '__-___-__')
);

create table UTILISATION(
	CodeAcc numeric(3) references ACCESSOIRE (CodeAcc),
	Surnom varchar(20),
	Titre varchar,
	primary key(CodeAcc,Surnom, Titre),
	foreign key (Surnom, Titre) references INTERPRETE (Surnom, Titre)
);

alter table NUMERO add COLUMN Duree time not null
check (Duree between '00:15:00' and '00:30:00');

create table LIEU(
	IDLieu varchar primary key,
	Adresse varchar not null,
	SiteWeb varchar check (SiteWeb like 'https://%')
);

create table REPRESENTATION(
	CodeRep varchar primary key,
	Date date not null,
	HeureDebut time not null check (HeureDebut between '10:00:00' and '22:00:00'),
	IDLieu varchar not null references LIEU (IDLieu)
);

create table PRESENTE(
	CodeRep varchar references REPRESENTATION (CodeRep),
	Titre varchar references NUMERO (Titre),
	OrdrePassage int check (OrdrePassage >= 1),
	unique (CodeRep, OrdrePassage),
	primary key (CodeRep, Titre)
)