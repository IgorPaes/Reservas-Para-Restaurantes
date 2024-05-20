-- CREATE DATABASE IF NOT EXISTS sistema_reserva;

CREATE TABLE IF NOT EXISTS Clientes (
    Id int auto_increment primary key,
    Nome varchar(30),
    Cpf varchar(20) unique,
    Email varchar(50) unique,
    Telefone varchar(20),
    Senha varchar(50)
);

CREATE TABLE IF NOT EXISTS Restaurantes (

    Id INT auto_increment primary key,
    NomeRestaurante varchar(30),
    Endereco varchar(60),
    Cep varchar(20),
    Telefone varchar(20),
    nomeImagem varchar(40)

);

CREATE TABLE IF NOT EXISTS Reservas (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    
    IdRestaurante INT,
    FOREIGN KEY (IdRestaurante) REFERENCES Restaurantes(Id),
    IdCliente INT,
    FOREIGN KEY (IdCliente) REFERENCES Clientes(Id),

    Data DATE,
    Horario TIME,
    QtdPessoas INT,
    Comentario VARCHAR(500)
);


INSERT INTO Restaurantes (NomeRestaurante, Endereco, Cep, Telefone, nomeImagem) VALUES
    ('OUTBACK', 'Av. Robert Kennedy 3999', '04772004', '11971704067', 'outback.png'),
    ('COCO BAMBU', 'Av. das Nações Unidas, 22540', '04795000', '1155484712', 'cocoBambu.jpg'),
    ('FOGO DE CHAO', 'Av. Roque Petroni Júnior, 1089', '04707000', '11970656874', 'fogodechao.png');