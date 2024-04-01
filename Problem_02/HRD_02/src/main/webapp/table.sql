CREATE TABLE member_tbl_02 (
	custno number(6) PRIMARY KEY,
	custname varchar2(20),
	phone varchar2(13),
	address varchar2(60),
	joindate date,
	grade char(1),
	city char(2)
);



INSERT INTO member_tbl_02(custno, custname, phone, address, joindate, grade, city) VALUES(100001, '김행복', '010-1111-2222', '서울 동대문구 휘경1동', '20151202', 'A', '01');
INSERT INTO member_tbl_02(custno, custname, phone, address, joindate, grade, city) VALUES(100002, '이축복', '010-1111-3333', '서울 동대문구 휘경21동', '20151206', 'B', '01');
INSERT INTO member_tbl_02(custno, custname, phone, address, joindate, grade, city) VALUES(100003, '장믿음', '010-1111-4444', '울릉군 울릉읍 독도1리', '20151001', 'B', '30');
INSERT INTO member_tbl_02(custno, custname, phone, address, joindate, grade, city) VALUES(100004, '최사랑', '010-1111-5555', '울릉군 울릉읍 독도2리', '20151114', 'A', '30');
INSERT INTO member_tbl_02(custno, custname, phone, address, joindate, grade, city) VALUES(100005, '진평화', '010-1111-6666', '제주도 제주시 외나무골', '20151225', 'B', '60');
INSERT INTO member_tbl_02(custno, custname, phone, address, joindate, grade, city) VALUES(100006, '차공단', '010-1111-7777', '제주도 제주시 감나무골', '20151211', 'C', '60');

SELECT * FROM member_tbl_02;

CREATE TABLE money_tbl_02(
	custno number(6) not null,
	saleno number(8) not null,
	pcost number(8),
	amount number(4),
	price number(8),
	pcode varchar(4),
	sdate date,
	PRIMARY KEY (custno, saleno)
);



INSERT INTO money_tbl_02(custno, saleno,pcost,amount,price,pcode,sdate) 
VALUES(100001, 20160001, 500,5,2500, 'A001', '20160101');
INSERT INTO money_tbl_02(custno, saleno,pcost,amount,price,pcode,sdate) 
VALUES(100001, 20160002, 1000,4,4000, 'A002', '20160101');
INSERT INTO money_tbl_02(custno, saleno,pcost,amount,price,pcode,sdate) 
VALUES(100001, 20160003, 500,3,1500, 'A008', '20160101');
INSERT INTO money_tbl_02(custno, saleno,pcost,amount,price,pcode,sdate) 
VALUES(100002, 20160004, 2000,1,2000, 'A004', '20160102');
INSERT INTO money_tbl_02(custno, saleno,pcost,amount,price,pcode,sdate) 
VALUES(100002, 20160005, 500,1,500, 'A001', '20160103');
INSERT INTO money_tbl_02(custno, saleno,pcost,amount,price,pcode,sdate) 
VALUES(100003, 20160006, 1500,2,3000, 'A003', '20160103');
INSERT INTO money_tbl_02(custno, saleno,pcost,amount,price,pcode,sdate) 
VALUES(100004, 20160007, 500,2,1000, 'A001', '20160104');
INSERT INTO money_tbl_02(custno, saleno,pcost,amount,price,pcode,sdate) 
VALUES(100004, 20160008, 300,1,300, 'A005', '20160104');
INSERT INTO money_tbl_02(custno, saleno,pcost,amount,price,pcode,sdate) 
VALUES(100004, 20160009, 600,1,600, 'A006', '20160104');
INSERT INTO money_tbl_02(custno, saleno,pcost,amount,price,pcode,sdate) 
VALUES(100004, 20160010, 3000,1,3000, 'A007', '20160106');

SELECT * FROM money_tbl_02;


select custno, custname, phone, address, joindate, decode(grade,'A','VIP','B','일반','C','직원') grade,city 
from MEMBER_TBL_02 order by custno;

select A.custno, A.custname, decode(grade,'A','VIP','B','일반','C','직원') grade, sum(B.price) price
from member_tbl_02 A, money_tbl_02 B 
where A.custno = B.custno
group by A.custno, A.custname, A.grade 
order by price desc;

select custno, custname, phone, address, joindate, grade, city 
from MEMBER_TBL_02 where custno = 100001;

insert into member_tbl_02 values(100007,'박은서','010-2962-0936','경기도 안양시 만안구','20240507','A','06');

select A.custno, A.custname, decode(A.grade,'A','VIP','B','일반','C','직원') grade, sum(B.price) price from member_tbl_02 a, money_tbl_02 B where A.custno = B.custno group by A.custno, A.custname, A.grade order by price desc;

select max(custno)+1 custno from member_tbl_02;

insert into member_tbl_02 values(?,?,?,?,?,?,?);

 select custno, custname, phone, address, joindate, decode(grade,'A','VIP','B','일반','C','직원') grade, city from member_tbl_02 order by custno;



