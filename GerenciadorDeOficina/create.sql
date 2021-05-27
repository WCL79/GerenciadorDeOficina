create table servicos (id  bigserial not null, data_criacao varchar(255), id_veiculo int8, item varchar(255) not null, mecanica varchar(255) not null, os varchar(255), valor float8 not null, primary key (id))
create table tb_veiculo (id  bigserial not null, ano varchar(255), cor varchar(255), id_usuario int8, marca varchar(255), modelo varchar(255), placa varchar(255), primary key (id))
create table usuarios (id  bigserial not null, email varchar(255), nome_completo varchar(255), senha varchar(255), primary key (id))
alter table servicos add constraint FK63oynqfh0hryoj26ac99268b9 foreign key (id_veiculo) references tb_veiculo
alter table tb_veiculo add constraint FKi1rr12eb9gnp4ydtwu3bb9orr foreign key (id_usuario) references usuarios
