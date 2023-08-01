create table Funcionario (
  nome VARCHAR (20) NOT NULL,
  salário int,
  dataAdmissão date,
  ide_funcionario serial,
  PRIMARY key (ide_funcionario)
  );
 INSERT into Funcionario (nome, salário, dataAdmissão)
 values ('João Silva', 5000, '2019-01-15'),
 ('Maria Souza', 4000, '2020-02-03'),
 ('Pedro santos',6000, '2018-05-10'),
 ('Ana Oliveira', 4500, '2017-08-20'),
 ('Carlos Almeida', 5500, '2021-03-12');
 SELECT * from Funcionario
 
 
 create table Departamento (
   nome VARCHAR (20) NOT NULL,
   localização VARCHAR (10),
   ide_departamento serial,
   PRIMARY key (ide_departamento)
   );
   INSERT into Departamento (nome, localização)
   values ('RH', 'Prédio A'),
   ('Vendas', 'Prédio B'),
   ('Desenvolvimento', 'Prédio C'),
   ('Financeiro','Prédio A'),
   ('Marketing','Prédio D');
   SELECT* from departamento
   
   
   create TABLE Funcionario_departamento (
     ide_funcionario serial,
     ide_departamento serial,
     FOREIGN KEY (ide_funcionario)
     REFERENCES Funcionario (ide_funcionario),
     FOREIGN KEY (ide_departamento)
     REFERENCES Departamento (ide_departamento)
     );
     INSERT into Funcionario_departamento DEFAULT
     VALUES;
     SELECT * from Funcionario_departamento
                             
  
  CREATE table Projeto (
    nome VARCHAR (10),
    ide_projeto serial,
    dataInício date,
    dataConclusão date,
    PRIMARY KEY (ide_projeto)
    );
    INSERT INTO Projeto (nome, dataInício, dataConclusão)
    values ('Projeto A', '2020-01-15','2021-03-30'),
    ('Projeto B', '2021-02-03','2022-05-10'),
    ('Projeto C', '2019-05-10', '2020-10-20'),
    ('Projeto D', '2022-08-20','2023-02-15'),
    ('Proeto E', '2023-01-01','2024-06-30');
    SELECT * from Projeto
    
    
    create table Projeto_departamento (
      ide_projeto serial,
      ide_departamento serial,
      FOREIGN KEY (ide_projeto)
      references Projeto (ide_projeto),
      FOREIGN key (ide_departamento)
      REFERENCES Departamento (ide_departamento)
      );
      insert into Projeto_departamento DEFAULT
      values;
      SELECT * from Projeto_departamento
      
      
      CREATE TABLE Habilidade (
        descrição VARCHAR (20),
        ide_habilidade serial,
        PRIMARY key (ide_habilidade)
        );
        INSERT into Habilidade (descrição)
        VALUES ('Programação'),
        ('Vendas'),
        ('Negociação'),
        ('Design'),
        ('Análise de Dados');
        SELECT * from Habilidade
        
        CREATE table Funcionario_habilidade (
          ide_funcionario serial,
          ide_habilidade serial,
          FOREIGN key (ide_funcionario)
          REFERENCES Funcionario (ide_funcionario),
          FOREIGN key (ide_habilidade)
          REFERENCES Habilidade (ide_habilidade)
          );
          INSERT into Funcionario_habilidade DEFAULT
          values;
          select * from Funcionario_habilidade