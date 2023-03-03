CREATE TABLE game(
id integer not null,
name varchar(40) not null ,
price decimal (3,2),
releaseDate varchar(10) not null,
genre varchar(10) not null,
developer varchar(20) not null,
PRIMARY KEY(id)
);