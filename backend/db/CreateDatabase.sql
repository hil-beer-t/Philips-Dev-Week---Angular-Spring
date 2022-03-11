USE Backoffice;

CREATE TABLE regiao (id INT auto_increment PRIMARY KEY, regiao varchar(20), total_exames int );
CREATE TABLE faixa_etaria (id INT auto_increment PRIMARY KEY, Faixa_i int, Faixa_n int, Descricao varchar (50));
CREATE TABLE incidencia_exame (id INT auto_increment PRIMARY KEY, Regiao_id int, Mes int, Faixa_id int, Qnt_exames int);

Alter table incidencia_exame add constraint fk_incidencia_exame foreign key (Regiao_id) references regiao (id);
Alter table incidencia_exame add constraint fk_faixa_etaria foreign key (Faixa_id) references faixa_etaria (id);

SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_results = utf8;
SET collation_connection = utf8_general_ci;

INSERT INTO regiao (regiao,total_exames) VALUES ('Norte','44');
INSERT INTO regiao (regiao,total_exames) VALUES ('Nordeste','13832');
INSERT INTO regiao (regiao,total_exames) VALUES ('Sudeste','89657');
INSERT INTO regiao (regiao,total_exames) VALUES ('Sul','122');
INSERT INTO regiao (regiao,total_exames) VALUES ('Centro-Oeste','2581');


INSERT INTO faixa_etaria (Faixa_i,Faixa_n,Descricao) VALUES ('0','10','Até 10 anos');
INSERT INTO faixa_etaria (Faixa_i,Faixa_n,Descricao) VALUES ('11','14','Entre 11 e 14 anos');
INSERT INTO faixa_etaria (Faixa_i,Faixa_n,Descricao) VALUES ('15','19','Entre 15 e 19 anos');
INSERT INTO faixa_etaria (Faixa_i,Faixa_n,Descricao) VALUES ('20','24','Entre 20 e 24 anos');
INSERT INTO faixa_etaria (Faixa_i,Faixa_n,Descricao) VALUES ('25','29','Entre 25 e 29 anos');
INSERT INTO faixa_etaria (Faixa_i,Faixa_n,Descricao) VALUES ('30','34','Entre 30 e 34 anos');
INSERT INTO faixa_etaria (Faixa_i,Faixa_n,Descricao) VALUES ('35','39','Entre 35 e 39 anos');
INSERT INTO faixa_etaria (Faixa_i,Faixa_n,Descricao) VALUES ('40','44','Entre 40 e 44 anos');
INSERT INTO faixa_etaria (Faixa_i,Faixa_n,Descricao) VALUES ('45','49','Entre 45 e 49 anos');
INSERT INTO faixa_etaria (Faixa_i,Faixa_n,Descricao) VALUES ('50','54','Entre 50 e 54 anos');
INSERT INTO faixa_etaria (Faixa_i,Faixa_n,Descricao) VALUES ('55','59','Entre 55 e 59 anos');
INSERT INTO faixa_etaria (Faixa_i,Faixa_n,Descricao) VALUES ('60','64','Entre 60 e 64 anos');
INSERT INTO faixa_etaria (Faixa_i,Faixa_n,Descricao) VALUES ('65','69','Entre 65 e 69 anos');
INSERT INTO faixa_etaria (Faixa_i,Faixa_n,Descricao) VALUES ('70','150','Acima de 70');


INSERT INTO incidencia_exame (regiao_id, Mes, faixa_id, qnt_exames) VALUES (1,5,2,1);
INSERT INTO incidencia_exame (regiao_id, Mes, faixa_id, qnt_exames) VALUES (1,5,4,2);