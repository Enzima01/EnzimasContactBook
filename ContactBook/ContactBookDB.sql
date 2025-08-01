CREATE database bdContactBook;
Create table cadaster_table(
	id int auto_increment primary key,
    username varchar(100),
    telephone varchar(15),
    email varchar(100),
    address varchar(100),
    birthday varchar(10),
    children varchar(3)
);