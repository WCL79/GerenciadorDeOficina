create table servicos (id bigint not null auto_increment, data_criacao varchar(255), id_veiculo bigint, item varchar(255), mecanica varchar(255), os varchar(255), valor double precision, primary key (id)) engine=InnoDB
create table tb_veiculo (id bigint not null auto_increment, ano varchar(255), cor varchar(255), marca varchar(255), modelo varchar(255), placa varchar(255), primary key (id)) engine=InnoDB
create table tb_veiculo_servico_list (veiculo_id bigint not null, servico_list_id bigint not null) engine=InnoDB
create table usuarios (id bigint not null auto_increment, email varchar(255), nome_completo varchar(255), senha varchar(255), primary key (id)) engine=InnoDB
create table usuarios_veiculo_list (usuario_id bigint not null, veiculo_list_id bigint not null) engine=InnoDB
alter table tb_veiculo_servico_list add constraint UK_3270m84sgeath4r8ukwyltia5 unique (servico_list_id)
alter table tb_veiculo_servico_list add constraint FKarrkilesq35of7y1yj6uxovlx foreign key (servico_list_id) references servicos (id)
alter table tb_veiculo_servico_list add constraint FKs7jjfnx8v5kjvbndf8p585nrt foreign key (veiculo_id) references tb_veiculo (id)
alter table usuarios_veiculo_list add constraint FKij9crl7t5wot6oegecu88wkys foreign key (veiculo_list_id) references tb_veiculo (id)
alter table usuarios_veiculo_list add constraint FKpgw217ygq7wp2cq8su23apj1 foreign key (usuario_id) references usuarios (id)
