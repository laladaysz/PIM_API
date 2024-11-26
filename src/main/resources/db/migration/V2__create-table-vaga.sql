CREATE TABLE Vagas (
    id_vaga bigint not null auto_increment,
    numero_vaga int not null,
    status varchar(100) not null,

    primary key(id_vaga)
);