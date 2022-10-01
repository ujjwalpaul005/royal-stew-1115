create table student
(
roll int primary key AUTO_INCREMENT,
name varchar(20) not null,
age int,
address varchar(15),
email varchar(25) not null unique,
password varchar(8) not null
);






create table course
(
id int primary key,
cname varchar(15) not null,
duration varchar(20) not null,
fees int not null,
training_session varchar(6) not null,
seat int not null
)
;






create table batch
(
cid int,
sid int,
primary key (cid, sid),
foreign key (cid) references course(id),
foreign key (sid) references student(roll)
);