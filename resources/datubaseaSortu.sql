CREATE DATABASE jokoa IF NOT EXISTS;
USE jokoa;
CREATE TABLE animalia IF NOT EXISTS(
izena char(10) NOT NULL,
zenbakia int NOT NULL,
deskribapena varchar(40) NOT NULL,
puntuazioa int NOT NULL,
orijinala bit NOT NULL,
PRIMARY KEY(zenbakia));
CREATE TABLE jokalaria IF NOT EXISTS(
izena char(15) NOT NULL,
abizena char(15) NOT NULL,
pasahitza char(10) NOT NULL,
jaioUrtea int NOT NULL,
email varchar(255) NOT NULL, 
erregistroData date NOT NULL,
mota char(10) NOT NULL,
PRIMARY KEY(email));
CREATE TABLE partida IF NOT EXISTS(
kodea int NOT NULL,
kolorea char(10) NOT NULL,
data date NOT NULL, 
hOrdua time NOT NULL,
bOrdua time NOT NULL;
jokEmail varchar(255) NOT NULL,
puntuJok int NOT NULL, 
puntuOrd int NOT NULL,
egoera bit,
PRIMARY KEY(kodea),
FOREIGN KEY(jokEmail) REFERENCES jokalaria(email));
