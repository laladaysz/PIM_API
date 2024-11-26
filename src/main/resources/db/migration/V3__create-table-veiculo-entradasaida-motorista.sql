CREATE TABLE Motoristas (
    id_motorista BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome varchar(50),
    email varchar(70),
    telefone varchar(50)
);

CREATE TABLE Veiculos (
    id_veiculo BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_motorista BIGINT,
    placa varchar(60),
    modelo varchar(60),
    cor varchar(60),

    FOREIGN KEY (id_motorista) REFERENCES Motoristas(id_motorista)
);

CREATE TABLE Entradas_saidas (
    id_registro BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_veiculo BIGINT NOT NULL,
    id_vaga BIGINT NOT NULL,
    hora_entrada TIMESTAMP,
    hora_saida TIMESTAMP NULL,

    FOREIGN KEY (id_veiculo) REFERENCES Veiculos(id_veiculo),
    FOREIGN KEY (id_vaga) REFERENCES Vagas(id_vaga)
);
