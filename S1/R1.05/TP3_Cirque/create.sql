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

