
CREATE TABLE tbl_artist_201905(
	artist_id char(4) not null primary key,
	artist_name varchar2(20),
	artist_birth char(8),
	artist_gender char(1),
	talent char(1),
	agency varchar2(20)
);

select * from tbl_artist_201905;

INSERT INTO tbl_artist_201905 VALUES('A001', '황스타','19970101', 'F','1','A엔터테인먼트');
INSERT INTO tbl_artist_201905 VALUES('A002', '정스타','19980201', 'M','2','B엔터테인먼트');
INSERT INTO tbl_artist_201905 VALUES('A003', '박스타','19990301', 'M','3','C엔터테인먼트');
INSERT INTO tbl_artist_201905 VALUES('A004', '김스타','20000401', 'M','1','D엔터테인먼트');
INSERT INTO tbl_artist_201905 VALUES('A005', '서스타','20010501', 'F','2','E엔터테인먼트');


CREATE TABLE tbl_mento_201905(
	mento_id char(4) primary key not null,
	mento_name varchar2(20)
);

SELECT * FROM tbl_mento_201905;

INSERT INTO tbl_mento_201905 VALUES('J001','이멘토');
INSERT INTO tbl_mento_201905 VALUES('J002','안멘토');
INSERT INTO tbl_mento_201905 VALUES('J003','한멘토');



CREATE TABLE tbl_point_201905(
	serial_no char(4) primary key not null,
	artist_id varchar2(20),
	mento_id char(8),
	point number(6)
);

SELECT * FROM tbl_point_201905;

INSERT INTO tbl_point_201905 VALUES('P001', 'A001','J001',84);
INSERT INTO tbl_point_201905 VALUES('P002', 'A001','J002',82);
INSERT INTO tbl_point_201905 VALUES('P003', 'A001','J003',86);
INSERT INTO tbl_point_201905 VALUES('P004', 'A002','J001',98);
INSERT INTO tbl_point_201905 VALUES('P005', 'A002','J002',99);

INSERT INTO tbl_point_201905 VALUES('P006', 'A002','J003',100);
INSERT INTO tbl_point_201905 VALUES('P007', 'A003','J001',23);
INSERT INTO tbl_point_201905 VALUES('P008', 'A003','J002',43);
INSERT INTO tbl_point_201905 VALUES('P009', 'A003','J003',34);
INSERT INTO tbl_point_201905 VALUES('P010', 'A004','J001',67);

INSERT INTO tbl_point_201905 VALUES('P011', 'A004','J002',56);
INSERT INTO tbl_point_201905 VALUES('P012', 'A004','J003',89);
INSERT INTO tbl_point_201905 VALUES('P013', 'A005','J001',3);
INSERT INTO tbl_point_201905 VALUES('P014', 'A005','J002',6);
INSERT INTO tbl_point_201905 VALUES('P015', 'A005','J003',9);


select artist_id,artist_name, 
substr(a.artist_birth,1,4) ||'년'||substr(a.artist_birth,5,2)||'월'||substr(a.artist_birth,7,2)||'일' artist_birth,
decode(a.artist_gender,'M','남','F','여') artist_gender,decode(a.talent,'1','보컬','2','댄스','3','랩') talent, a.agency
from tbl_artist_201905 a
order by a.artist_id;


select c.serial_no, a.artist_name,
	substr(a.artist_birth,1,4)||'년'||substr(a.artist_birth,5,2)||'월'||substr(a.artist_birth,7,2)||'일' artist_birth, c.point,
	case when c.point >= 90 then 'A'
		when c.point >= 80 then 'B'
		when c.point >= 70 then 'C'
		when c.point >= 60 then 'D'
		else 'F' end point_too, 
	b.mento_name
from TBL_ARTIST_201905 a, TBL_MENTO_201905 b, TBL_POINT_201905 c
where a.artist_id = c.artist_id and b.mento_id = c.mento_id;


select a.artist_name, sum(b.point) sumpoint, round(avg(b.point),2) roundpoint, RANK() OVER(order by sum(b.point) desc)  ranknum 
from tbl_artist_201905 a, tbl_point_201905 b 
where a.artist_id = b.artist_id 
group by a.artist_name 
order by sum(b.point) desc;




















