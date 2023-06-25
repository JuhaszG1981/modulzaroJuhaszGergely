create database ingatlan_db;

USE `ingatlan_db`;

Create Table ingatlanok(
tulajdonos VARCHAR(50) NOT NULL,
hrsz VARCHAR(30) NOT NULL,
alapterulet INT NOT NULL,
ar INT NOT NULL);

INSERT INTO ingatlanok(tulajdonos,hrsz,alapterulet,ar) VALUES ('Magyar Endre','125/2',170,75000000);
INSERT INTO ingatlanok(tulajdonos,hrsz,alapterulet,ar) VALUES ('Kiss Lilla','3181/1',110,45000000);
INSERT INTO ingatlanok(tulajdonos,hrsz,alapterulet,ar) VALUES ('Tóth Eszter','11055',80,32000000);
INSERT INTO ingatlanok(tulajdonos,hrsz,alapterulet,ar) VALUES ('Fekete Benedek','1101/1',100,40000000);
INSERT INTO ingatlanok(tulajdonos,hrsz,alapterulet,ar) VALUES ('Nagy Endre','2345',135,59000000);