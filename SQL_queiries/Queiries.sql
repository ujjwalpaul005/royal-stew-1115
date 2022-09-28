create table student
(
roll int primary key AUTO_INCREMENT,
name varchar(20) not null,
age int,
address varchar(15),
email varchar(25) not null unique,
password varchar(8) not null
);