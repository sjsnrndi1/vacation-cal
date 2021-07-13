CREATE TABLE vacation (
	count NUMBER NOT NULL,
	name VARCHAR2(20) NOT NULL,
	month NUMBER NOT NULL,
	day NUMBER NOT NULL,
	
	PRIMARY KEY(count)
);

create SEQUENCE count_seq;

select * from vacation order by name asc, month asc, day asc;