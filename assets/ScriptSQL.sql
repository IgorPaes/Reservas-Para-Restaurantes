-- Criando Base de Dados

CREATE DATABASE IF NOT EXISTS sistema_reserva;

CREATE TABLE IF NOT EXISTS Clientes (
    Id int auto_increment primary key,
    Nome varchar(30),
    Cpf varchar(20) unique,
    Email varchar(50) unique,
    Telefone varchar(20),
    Senha varchar(50)
);

CREATE TABLE IF NOT EXISTS Reservas (
    Id int auto_increment primary key,

    IdRestaurante int,
    FOREIGN KEY (IdRestaurante) REFERENCES Restaurantes(Id),
    IdCliente int,
    FOREIGN KEY (IdCliente) REFERENCES Clientes(Id),

    IdRestaurante int, FOREIGN KEY (IdRestaurante) REFERENCES Restaurantes(Id),
    IdCliente int, FOREIGN KEY (IdCliente) REFERENCES Clientes(Id),

    `Data` date,
    Horario time(6),
    QtdPessoas int,
    Comentario varchar(500)
);

CREATE TABLE IF NOT EXISTS Restaurantes (
    Id int auto_increment primary key,
    NomeRestaurante varchar(30),
    Endereco varchar(50),
    Cep varchar(20),
    Telefone varchar(20)
);

-- Inserts table Restaurantes

INSERT INTO Restaurantes (NomeRestaurante, Endereco, CEP, Telefone) VALUES
    ('OUTBACK', 'Av. Robert Kennedy 3999', '04772004', '11971704067'),
    ('COCO BAMBU', 'Av. das Nações Unidas, 22540', '04795000', '1155484712'),
    ('FOGO DE CHAO', 'Av. Roque Petroni Júnior, 1089', '04707000', '11970656874');
