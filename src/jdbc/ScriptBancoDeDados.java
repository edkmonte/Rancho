//create database db_projetorancho
//default character set utf8
//default collate utf8_general_ci;
//
//use db_projetorancho;
//
//create table tb_refeicoes(
//	ref_codigo int not null auto_increment,
//    ref_tipo varchar(60) not null,
//    ref_horario varchar(5) not null,
//    primary key(ref_codigo)
//) default charset = utf8;
//
//create table tb_pacientes(
//	pac_codigo int not null auto_increment,
//    pac_nome varchar(155) not null,
//    pac_cpf varchar(14) not null,
//    pac_dtEntrada date not null,
//    pac_leito varchar(30) not null,
//    pac_quarto varchar(10) not null,
//    primary key(pac_codigo)
//)default charset = utf8;
//
//create table tb_acompanhante(
//	aco_nome varchar(155) not null,
//    aco_cpf varchar(14) not null,
//    aco_pac_codigo int not null,
//    foreign key (aco_pac_codigo) references tb_pacientes(pac_codigo)
//)default charset = utf8;
//
//create table tb_patentes(
//	pat_codigo int not null auto_increment,
//    pat_tipo varchar(80) not null,
//    primary key (pat_codigo)
//)default charset = utf8;
//
//create table tb_funcionarios(
//	fun_codigo int not null auto_increment,
//    fun_matricula varchar(10) not null,
//    fun_nome varchar(155) not null,
//    fun_pat_codigo int,
//    primary key (fun_codigo),
//    foreign key (fun_pat_codigo) references tb_patentes(pat_codigo)
//)default charset = utf8;
//
//create table tb_realizacoes(
//	rea_codigo int not null auto_increment,
//    rea_pac_codigo int,
//    rea_fun_codigo int,
//    rea_ref_codigo int,
//    rea_dtRealizacao datetime not null,
//    primary key (rea_codigo),
//    foreign key (rea_pac_codigo) references tb_pacientes(pac_codigo),
//    foreign key (rea_fun_codigo) references tb_funcionarios(fun_codigo),
//    foreign key (rea_ref_codigo) references tb_refeicoes(ref_codigo)
//)default charset = utf8;  
//
//create table tb_autorizacoes(
//	aut_codigo int not null auto_increment,
//    aut_pac_codigo int,
//    aut_fun_codigo int,
//    aut_ref_codigo int,
//    aut_dtAutorizado datetime not null,
//    aut_motivo varchar(255),
//    primary key (aut_codigo),
//    foreign key (aut_pac_codigo) references tb_pacientes(pac_codigo),
//    foreign key (aut_fun_codigo) references tb_funcionarios(fun_codigo),
//    foreign key (aut_ref_codigo) references tb_refeicoes(ref_codigo)
//)default charset = utf8;
//
//
//insert into tb_patentes (pat_tipo) values ('Saldado');
//insert into tb_patentes (pat_tipo) values ('Cabo');
//insert into tb_patentes (pat_tipo) values ('Sargento');
//
//insert into tb_pacientes(pac_nome, pac_cpf, pac_dtEntrada, pac_leito, pac_quarto) values ('Maria de Assis Cabral', '147.258.369-00', '2017-08-06', 'São Luis', '02B');
//insert into tb_pacientes(pac_nome, pac_cpf, pac_dtEntrada, pac_leito, pac_quarto) values ('João de Araújo Tomas', '963.852.741-11', '2017-07-10', 'São João', '03B');
//insert into tb_pacientes(pac_nome, pac_cpf, pac_dtEntrada, pac_leito, pac_quarto) values ('Carlos da Silva Bento', '258.147.369-22', '2017-07-30', 'São Fransciso', '02A');
//insert into tb_pacientes(pac_nome, pac_cpf, pac_dtEntrada, pac_leito, pac_quarto) values ('Adriano Tavares de Lira', '963.741.852-33', '2017-06-20', 'São Pedro', '05C');
//insert into tb_pacientes(pac_nome, pac_cpf, pac_dtEntrada, pac_leito, pac_quarto) values ('Paulo Castro Barros', '357.159.456-44', '2017-05-21', 'São Tomaz', '01B');
//
//insert into tb_acompanhante(aco_nome, aco_cpf, aco_pac_codigo) values ('Thiago de Assis Cabral', '147.369.852-88', 1);
//insert into tb_acompanhante(aco_nome, aco_cpf, aco_pac_codigo) values ('Joaquina Maria de Tomas', '447.002.254-55', 2);
//insert into tb_acompanhante(aco_nome, aco_cpf, aco_pac_codigo) values ('Carolina Ferreira Cruz', '954.231.474-11', 3);
//
//insert into tb_funcionarios(fun_nome, fun_matricula, fun_pat_codigo) values ('Sergio Andrede Vasconcelos', '125.369-1', 1);
//insert into tb_funcionarios(fun_nome, fun_matricula, fun_pat_codigo) values ('Ana Maria de Aquino', '002.258-2', 2);
//insert into tb_funcionarios(fun_nome, fun_matricula, fun_pat_codigo) values ('Sergio Andrede Vasconcelos', '025.654-3', 3);
//
//select*from tb_acompanhante;
//select*from tb_patentes;
//select*from tb_refeicoes;
//select*from tb_funcionarios;
//select*from tb_pacientes;
//select*from tb_autorizacoes;
//select*from tb_realizacoes;