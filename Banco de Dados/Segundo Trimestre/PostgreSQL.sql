CREATE TABLE Empresa(
  nome VARCHAR (20) NOT NULL,
  email VARCHAR (50),
  telefone VARCHAR (15),
  cnpj_empresa VARCHAR (14) NOT NULL,
  cep VARCHAR (8),
  numero INT,
  primary key (cnpj_empresa)
  );
INSERT into Empresa (nome, email, telefone, cnpj_empresa, cep, numero)
VALUES ('MyBrain','mybrain.startup@gmail.com','(48)98480-0009','28538912056734','88149345',28),
('Sesi','sesisenai@gmail.com','(48)98456-7809','24687614598623','33762107',15),
('Ifood','ifood@gmail.com','(49)99856-2367','36823406412395','12098372',11),
('Bobs','bobs@gmail.com','(11)98456-9812','24695129104573','46925890',35),
('Dasa','dasa@gmail.com','(11)99456-2389','27964790123542','08631678',23);
SELECT * FROM Empresa WHERE numero > 20 or numero = 15
       
CREATE TABLE vagas(
 nome VARCHAR (20),
 carga_horaria decimal (4,2),
 salario decimal (7,2) NOT NULL,
 id_vagas serial,
 quantidadeVagas int,
 PRIMARY KEY (id_vagas)
 );
INSERT into vagas (nome, carga_horaria, salario, quantidadeVagas)
values ('Gerente',08.00,5500,8),
('Markenting',06.00,2600,3),
('Faxina',06.00,1700,10),
('Programador',08.00,8000,2),
('Analista de dados',06.00,7200,6),
('Estagiário',06.00,900,14),
('Jovem Aprendiz',04.00,600,16);
SELECT nome,quantidadeVagas from vagas WHERE quantidadeVagas != 16 ORDER BY nome asc 
SELECT salario from vagas ORDER by salario desc


create table Empresa_Vagas (
  cnpj_empresa VARCHAR (14) NOT NULL,
  id_vagas serial,
  FOREIGN key (cnpj_empresa)
  REFERENCES Empresa (cnpj_empresa),
  FOREIGN key (id_vagas)
  REFERENCES vagas (id_vagas)
  );
  INSERT into empresa_vagas (cnpj_empresa)
  VALUES ('28538912056734'),
('24687614598623'),
('36823406412395'),
('24695129104573'),
('27964790123542');
SELECT * from Empresa_Vagas