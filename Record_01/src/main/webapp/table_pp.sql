create table dateTable_1(
	id number(20) primary key,
	name varchar2(50) not null,
	pw varchar2(50) not null,
	pnum varchar2(11) not null,
	mail varchar2(50) not null
);

insert into dateTable_1 values(100001,'은서','1234','01012345678', 'thismail@gmail.com');
insert into dateTable_1 values(100002,'하르', '1022', '01098765432', 'thisnotmail@gmail.com');
insert into dateTable_1 values(100003,'현서','1234','01012345678', 'thismail@gmail.com');
insert into dateTable_1 values(100004,'웅더', '1022', '01098765432', 'thisnotmail@gmail.com');

select * from dateTable_1;


create table dateTable_2(
	start_day varchar2(4) not null,
	end_day varchar2(4) not null  
);

insert into dateTable_2 values('0315', '0423');
insert into dateTable_2 values('0220', '0507');

select * from dateTable_2;


create table dateTable_3(
	id number(20) primary key, 
	title varchar2(50) not null,
	content varchar2(500) not null,
	to_day varchar2(8) not null,
	ox number(1)
);


//테이블 다시 만들어야함 r_id랑 check_num 추가해야함 r_id는 datetablee_1의 id, check_num은 기록 글의 번호임 몇번째의 글인지 구분하기위한 

insert into dateTable_3 values(100001, '지금 노래방 가고 싶다.', '오늘은 9시쯤에 가고싶다.','20240508',1);
insert into dateTable_3 values(100002, '지금 집 가고 싶다.', '오늘은 진짜 가고싶다.','20240508',0);
insert into dateTable_3 values(100003, '산책하고 싶다.', '나랑 산책할 사람 찾아요','20240508',1);
insert into dateTable_3 values(100004, '부자 되고 싶다.', '로또 당첨되고 싶어요','20240508',0);

select * from dateTable_3;

drop table dateTable_3;


//날짜 00월 00일 형식으로 출력
select substr(start_day,1,2)||'월'||substr(start_day,3,2)||'일' start_day,
substr(end_day,1,2)||'월'||substr(end_day,3,2)||'일' end_day from dateTable_2;


select name,pw,substr(pnum,1,3)||'-'||substr(pnum,3,4)||'-'||substr(pnum,8,4) pnum,mail from dateTable_1;


select max(id)+1 custno from datetable_1;


select r_id, check_num, title, content, substr(to_day,1,4)||'년 '||substr(to_day,5,2)||'월 '||substr(to_day,7,2)||'일' to_day,  decode(ox,'0','공개','1','비공개') ox from datetable_3 order by check_num asc;


