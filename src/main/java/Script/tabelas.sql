CREATE SEQUENCE public.usuario_seq;

CREATE TABLE usuario
(
  idUsuario integer NOT NULL DEFAULT nextval('usuario_seq'::regclass),
  nome varchar(100) NOT NULL,
  email varchar(100) NOT NULL,
  dataDeNascimento Date NOT NULL,
  sexo varchar (100) NOT NULL,
  senha varchar (100) NOT NULL,
  telefone varchar (100) NOT NULL,
  foto varchar (100) not null,
  PRIMARY KEY (idUsuario)
);

