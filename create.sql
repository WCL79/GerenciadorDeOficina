create table servicos (id bigint not null auto_increment, data_criacao varchar(255), id_veiculo bigint, item varchar(255) not null, mecanica varchar(255) not null, os varchar(255), valor double precision not null, primary key (id)) engine=InnoDB
create table tb_veiculo (id bigint not null auto_increment, ano varchar(255), cor varchar(255), id_usuario bigint, marca varchar(255), modelo varchar(255), placa varchar(255), primary key (id)) engine=InnoDB
create table usuarios (id bigint not null auto_increment, email varchar(255), nome_completo varchar(255), senha varchar(255), primary key (id)) engine=InnoDB
alter table servicos add constraint FK63oynqfh0hryoj26ac99268b9 foreign key (id_veiculo) references tb_veiculo (id)
alter table tb_veiculo add constraint FKi1rr12eb9gnp4ydtwu3bb9orr foreign key (id_usuario) references usuarios (id)
