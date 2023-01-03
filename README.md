# projetosb - copie e cole o banco de dado abaixo ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
GRANT ALL PRIVILEGES ON your_desired_database_name.* TO 'root'@'localhost';

-- comentários
-- a linha abaixo cria um banco de dados
CREATE DATABASE dbinfox;
-- a linha abaixo escolhe o banco de dados 
use dbinfox;
-- o bloco de instruções abaixo cria uma tabela
create table tb_usuario (
  id int auto_increment primary key,
  nomecard varchar(100),
  tipo varchar(100),
  fun_designer varchar(100),
  email varchar(200),
  quantidade int ,
  qtd_cards int,
  total decimal (10,2),
  senha varchar(10)
 
);
describe tb_usuario
-- o comando abaixo descreve a tabela

-- a linha abaixo insere dados na tabela (CRUD)
-- create -> insert
insert into tb_usuario(id,nomecard,tipo,fun_designer,email,quantidade,qtd_cards,total,senha)tb_funcionarios
values(1123,'nomecard','tipo','fun_designer','email','quantidade','qtd_cards','total','senha')
-- a linha abaixo exibe os dados da tabela (CRUD)
-- read -> select
select * from tb_usuario;

insert into tbusuarios(iduser,usuario,fone,login,senha)
values(2,'Batman','9999-9999','batman22','batsenha');
insert into tbusuarios(iduser,usuario,fone,login,senha)
values(3,'keverson','9457-2564','kevdias74','senha');

-- a linha abaixo modifica dados na tabela (CRUD)
-- update -> updatetb_funcionarios
update tbusuarios set fone='8888-8888' where iduser=2;

-- a linha a baixo apaga um regristo da tabela (CRUD)
-- delete -> delete
delete from tbusuarios  where iduser=3;

select * from tbusuarios;

create table tbfuncionarios(
idfun int primary key auto_increment,
nomefun varchar(50) not null,
matricula varchar(50) not null,
cargo varchar(50) not null,
fonefun varchar(50) not null,
emailfun varchar(50) not null,
senha varchar (200) not null
);

describe tbfuncionarios;

insert into tbfuncionarios(nomefun,matricula,cargo,fonefun,emailfun)
values('keverson','79','Designer','8499457-2564','keverson80@seubone.com','12345');

select * from tbfuncionarios;

create table tbot(
ot int primary key auto_increment,
data_ot timestamp default current_timestamp,
nomecard varchar(150) not null,
tipo_de_trabalho varchar(50) not null,
quantidade decimal(10,2),
observações varchar (150),
idfun int not null,
foreign key(idfun) references tbfuncionarios(idfun)
);
describe tbot;
insert into tbot (nomecard,tipo_de_trabalho,quantidade,observações,idfun)
values ('Marcos Paulo Cordeiro  7908  +30 drogaria cordeiro','Mod Layout','11','não tenho','1');

select * from tbot;

-- o código abaixo traz informações das tabelas
select 
O.OT,nomecard,tipo_de_trabalho,quantidade,observações,
C.nomefun,cargo
from tbot as O
inner join tbfuncionarios as C 
on (O.idfun = C.idfun);


