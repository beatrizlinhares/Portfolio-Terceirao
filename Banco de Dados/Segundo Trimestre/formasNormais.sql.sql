create table produto (
  nome VARCHAR (20),
  categoria VARCHAR (20),
  preco decimal (5,2),
  ide serial,
  PRIMARY key (ide)
  )
  
  insert into produto (nome, categoria, preco)
  values ('Camiseta','Vestuário', 25.00),
  ('Caneca', 'Utensílio', 10.00),
  ('Calça Jeans', 'Vestuário', 50.00),
  ('Livro', 'livros', 15.00),
  ('Celular', 'Eletrônicos', 500.00);
  select * from produto
  
  
  
  
  create table pedido (
    ide serial,
    qnt_produto int,
    data_pedido date,
    primary key (ide)
    )
    
    insert into pedido (qnt_produto, data_pedido)
    VALUES (2, '2022-01-15'),
    (3, '2022-02-03'),
    (1, '2022-02-10'),
    (5, '2022-03-05'),
    (2, '2022-04-20'),
    (1, '2022-05-12');
    select * from pedido
    
    
    
    
    create table pedido_produto (
      ide_pedido serial,
      ide_produto serial,
      FOREIGN key (ide_pedido)
      REFERENCES pedido (ide),
      FOREIGN key (ide_produto)
      REFERENCES produto (ide)
      )
      
      INSERT into pedido_produto DEFAULT
      values;
      select * from pedido_produto
      
      
      
      
      create table cliente (
        nome VARCHAR (50),
        cpf VARCHAR (20),
        primary key (cpf)
        )
        
        insert into cliente (nome, cpf)
        values ('João da Silva', '256.954.852-56'),
        ('Maria Souza', '065.563.678-84'),
        ('Pedro Santos', '123.765.987-34'),
        ('Ana Oliveira', '345.876.023-56'),
        ('Carlos Almeida','567.456.123-98');
        select * from cliente
        
        
        
        
        create table telefone(
          tel VARCHAR (15),
          primary key (tel)
          )
          
          insert into telefone (tel)
          values ('(11)1234-5678'),
          ('(22)9876-5432'),
          ('(33)5555-1111'),
          ('(44)2222-3333'),
          ('(55)7777-8888');
          select * from telefone
          
          
          
          
          create table cliente_telefone (
            cpf_cliente VARCHAR (20),
            tel_telefone VARCHAR (15),
            FOREIGN key (cpf_cliente)
            references cliente (cpf),
            FOREIGN key (tel_telefone)
            references telefone (tel)
            )
            
            insert into cliente_telefone (cpf_cliente,tel_telefone)
            values ('256.954.852-56','(11)1234-5678'),
            ('065.563.678-84','(22)9876-5432'),
            ('123.765.987-34','(33)5555-1111'),
            ('345.876.023-56','(44)2222-3333'),
            ('567.456.123-98','(55)7777-8888');
            select * from cliente_telefone
            
            
            
            
            create table endereco (
              rua VARCHAR (100), --podia ser cep
              numero_casa VARCHAR (5),
              ide serial,
              primary key (ide)
              )
            
            insert into endereco (rua, numero_casa)
            values ('Rua A','123'),
             ('Av. B','456'),
             ('Praça C','789'),
             ('Rua D','321'),
             ('Av. E','654');
            select * from endereco
            
     create table cliente_endereco (
       cpf_cliente VARCHAR (20),
       ide_endereco serial,
       FOREIGN key (cpf_cliente)
       REFERENCES cliente (cpf),
       FOREIGN key (ide_endereco)
       REFERENCES endereco (ide)
       )
       
       insert into cliente_endereco (cpf_cliente)
       values ('256.954.852-56'),
        ('065.563.678-84'),
        ('123.765.987-34'),
        ('345.876.023-56'),
        ('567.456.123-98');
        select * from cliente_endereco