create database Locacao
default character set utf8
default collate utf8_general_ci;
use Locacao;

create table professor(
    cdprofessor int(10) not null AUTO_INCREMENT,
    nome varchar(50) not null,
    materia varchar(50) not null,
    login varchar(30) not null,
    senha varchar(30) not null,
    primary key(cdprofessor)
);

create table equipamentos(
    cdequipamentos int(10) not null AUTO_INCREMENT,
    nome varchar(80) not null,
    descricao varchar(100) not null,
    reservado boolean default false,
    primary key(cdequipamentos)
);

create table horario(
    cdhorario int(10) not null AUTO_INCREMENT,
    horario varchar(20) not null,
    dia varchar(50) not null,
    duracao varchar(30) not null,
    primary key(cdhorario)

);

create table reservas(
    cdreservas int(10) not null AUTO_INCREMENT,
    equipamentos int(10) not null,
    horario int(10) not null,
    professor int(10) not null,
    foreign key(equipamentos) references equipamentos(cdequipamentos),
    foreign key(horario) references horario(cdhorario),
    foreign key(professor) references professor(cdprofessor),
    primary key(cdreservas)
);


insert into horario(dia,horario, duracao) 
values  ("segunda-feira",'Aula 1','7:10 as 8:00'),
        ("segunda-feira",'Aula 2','8:00 as 8:50'),
        ("segunda-feira",'Aula 3','9:10 as 10:00 '),
        ("segunda-feira",'Aula 4','10:00 as 10:50'),
        ("segunda-feira",'Aula 5','10:50 as 11:40'),
        ("segunda-feira",'Aula 6','13:20 as 14:10'),
        ("segunda-feira",'Aula 7','14:10 as 15:00'),
        ("segunda-feira",'Aula 8','15:20 as 16:10'),
        ("segunda-feira",'Aula 9','16:10 as 17:00'),
        
        ("terca-feira",'Aula 1','7:10 as 8:00'),
        ("terca-feira",'Aula 2','8:00 as 8:50'),
        ("terca-feira",'Aula 3','9:10 as 10:00 '),
        ("terca-feira",'Aula 4','10:00 as 10:50'),
        ("terca-feira",'Aula 5','10:50 as 11:40'),
        ("terca-feira",'Aula 6','13:20 as 14:10'),
        ("terca-feira",'Aula 7','14:10 as 15:00'),
        ("terca-feira",'Aula 8','15:20 as 16:10'),
        ("terca-feira",'Aula 9','16:10 as 17:00'),
        
        ("quarta-feira",'Aula 1','7:10 as 8:00'),
        ("quarta-feira",'Aula 2','8:00 as 8:50'),
        ("quarta-feira",'Aula 3','9:10 as 10:00'),
        ("quarta-feira",'Aula 4','10:00 as 10:50'),
        ("quarta-feira",'Aula 5','10:50 as 11:40'),
        ("quarta-feira",'Aula 6','13:20 as 14:10'),
        ("quarta-feira",'Aula 7','14:10 as 15:00'),
        ("quarta-feira",'Aula 8','15:20 as 16:10'),
        ("quarta-feira",'Aula 9','16:10 as 17:00'),
        
		("quinta-feira",'Aula 1','7:10 as 8:00'),
        ("quinta-feira",'Aula 2','8:00 as 8:50'),
        ("quinta-feira",'Aula 3','9:10 as 10:00 '),
        ("quinta-feira",'Aula 4','10:00 as 10:50'),
        ("quinta-feira",'Aula 5','10:50 as 11:40'),
        ("quinta-feira",'Aula 6','13:20 as 14:10'),
        ("quinta-feira",'Aula 7','14:10 as 15:00'),
        ("quinta-feira",'Aula 8','15:20 as 16:10'),
        ("quinta-feira",'Aula 9','16:10 as 17:00'),
        
    
        ("sexta-feira",'Aula 1','7:10 as 8:00'),
        ("sexta-feira",'Aula 2','8:00 as 8:50'),
        ("sexta-feira",'Aula 3','9:10 as 10:00'),
        ("sexta-feira",'Aula 4','10:00 as 10:50'),
        ("sexta-feira",'Aula 5','10:50 as 11:40'),
        ("sexta-feira",'Aula 6','13:20 as 14:10'),
        ("sexta-feira",'Aula 7','14:10 as 15:00'),
        ("sexta-feira",'Aula 8','15:20 as 16:10'),
        ("sexta-feira",'Aula 9','16:10 as 17:00 ');

insert into equipamentos values(0,'Televisao','80 polegadas',false),
	(0,'Televisao', '70 polegadas',false),
	(0,'Televisao', '60 polegadas',false),
	(0,'Caixa de som','Marrom',false),
	(0,'Caixa de som','Media',false),
	(0,'Caixa de som - 1','Grande',false),
	(0,'Caixa de som - 2','Grande',false),
	(0,'Microfone - 1','Carregavel',false),
	(0,'Microfone - 2','Carregavel',false),
	(0,'Data show','Preto POSITIVO',false),
	(0,'Data show - 1','Branco - BEN',false),
	(0,'Data show - 2','Branco - BEN',false),
	(0,'Notebook - 1','Positivo',false),
	(0,'Notebook - 2','Positivo',false);