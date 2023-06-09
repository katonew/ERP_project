drop database if exists erp;
create database erp;
use erp;

drop table if exists company;	
create table company( -- 회사테이블	
	comno int auto_increment primary key, 	-- 회사고유번호
    comname varchar(20), 					-- 회사명
    cloginno int							-- 회사 로그인 번호
);
insert into company(comname,cloginno) values ('확인용회사',12345);

drop table if exists cust;	
create table cust( -- 거래처테이블	
	custno int auto_increment primary key, 	-- 거래처고유번호
    cname varchar(20) not null unique,		-- 거래처명
    custemp varchar(20), 					-- 거래처담당자명
    custphone varchar(13),					-- 거래처번호
    custaddress varchar(100),				-- 거래처주소
    comno int,
    foreign key (comno) references company(comno) on delete set null    
);
insert into cust(cname,custemp,custphone,custaddress,comno) values ('거래처1','거래처담당자1','010-1111-2222','경기도 안산시',1);
insert into cust(cname,custemp,custphone,custaddress,comno) values ('거래처2','거래처담당자2','010-3333-2222','경기도 안산시',1);
insert into cust(cname,custemp,custphone,custaddress,comno) values ('거래처3','거래처담당자3','010-4444-2222','경기도 안산시',1);
insert into cust(cname,custemp,custphone,custaddress,comno) values ('거래처4','거래처담당자4','010-5555-2222','경기도 안산시',1);
insert into cust(cname,custemp,custphone,custaddress,comno) values ('거래처5','거래처담당자5','010-6666-2222','경기도 안산시',1);

drop table if exists dept;	
create table dept( -- 부서테이블	
	dno int auto_increment primary key, 		-- 부서고유번호
    dname varchar(20) not null,					-- 부서명
    comno int,									-- 회사번호(FK)
	foreign key (comno) references company(comno)
);
insert into dept(dname,comno) values ('영업',1);


drop table if exists emp;
create table emp( -- 인사테이블
	empno int auto_increment primary key,			-- 사원 번호
    ename varchar(20),								-- 사원이름
    erank  varchar(20),								-- 직급
    officephone varchar(20),						-- 사내전화번호
    ssnum varchar(20),								-- 주민번호
    address varchar(40),							-- 집주소
    mobile varchar(20),								-- 연락처
    tenure boolean default true,					-- 재직상태
    empid varchar(20) unique,						-- 아이디
    emppwd varchar(20),								-- 비밀번호
    enterdate datetime ,							-- 입사일
    outdate datetime default null,					-- 퇴사일
    authority int,									-- 권한정보
    dno int,										-- 부서번호(FK)
    comno int,										-- 회사번호(FK)
    foreign key (dno) references dept(dno) on delete set null,
	foreign key (comno) references company(comno)
);

insert into emp(ename,erank,officephone,ssnum,address,mobile,empid,emppwd,authority,dno,comno) values
('사원명',    '대리',    '031-111-1111',    '950514-1111111',    '경기도',    '010-1111-1111',    'qwert',    'qwert1',    1,    1,    1);
insert into emp(ename,erank,officephone,ssnum,address,mobile,empid,emppwd,authority,dno,comno) values
('관리자',    '인사',    '031-111-1111',    '111111-1111111',    '경기도',    '010-1111-1111',    'admin',    'admin1',    4,    1,    1);

drop table if exists product;
create table product( -- 상품테이블
	pno int auto_increment primary key,		-- 상품코드	
	pname varchar(20) unique,				-- 상품명	
    pprice int,								-- 단가
    comno int,								-- 회사번호(FK)
	foreign key (comno) references company(comno)
);

insert into product(pname,pprice,comno) values ('상품1',1000,1);
insert into product(pname,pprice,comno) values ('상품2',2000,1);
insert into product(pname,pprice,comno) values ('상품3',3000,1);
insert into product(pname,pprice,comno) values ('상품4',4000,1);
insert into product(pname,pprice,comno) values ('상품5',5000,1);

drop table if exists request;
create table request( -- 발주테이블
	rno int auto_increment primary key,					-- 발주번호
	enter_date date default (current_date),				-- 등록일자	
	delivery_date date,									-- 납기일자
    state boolean default true,							-- 납기상태
	empno int,											-- 거래담당자(FK)
	custno int,											-- 거래처번호(FK)    
    comno int,											-- 회사번호(FK)
	foreign key (comno) references company(comno),
    foreign key (empno) references emp(empno) on delete set null,
	foreign key (custno) references cust(custno) on delete no action	-- 제품정보가 삭제되어도 정보는 그대로 남기
);

DROP TABLE IF EXISTS Info_Request;
CREATE TABLE Info_Request (
  ino INT AUTO_INCREMENT PRIMARY KEY,				-- PK
  rno INT,											-- 발주번호
  pno INT,											-- 상품번호
  quantity INT,										-- 발주수량
  FOREIGN KEY (rno) REFERENCES request(rno),
  FOREIGN KEY (pno) REFERENCES product(pno)
);

select *from request;
select *from Info_Request;


drop table if exists attendance;
create table attendance( -- 근무테이블
	entertime datetime,		-- 출근시간
    outtime datetime,		-- 퇴근시간
    empno int,				-- 직원번호(FK)
	comno int,				-- 회사번호(FK)
	foreign key (comno) references company(comno),
    foreign key (empno) references emp(empno) on delete no action
);

drop table if exists report;
create table report( -- 보고서 테이블
	rno int auto_increment primary key,	
	rtitle varchar(100),				-- 제목
    rcontent longtext,					-- 내용
    rfile longtext,						-- 첨부파일
    rstate int,							-- 결재상태 ( 결재중,결재완료,반려를 위해 int로 설정)
    comno int,							-- 회사번호(FK)
    empno int,							-- 결재자번호(FK)
    foreign key (comno) references company(comno),
    foreign key (empno) references emp(empno) on delete set null	
);

drop table if exists approval;
create table approval( -- 결재라인 테이블
	rno	int,							-- 기안서 번호(FK)
	firchecker int not null,			-- 첫번째 결재자(FK)
    secchecker int default 0,			-- 두번째 결재자(FK)
    thichecker int default 0,			-- 세번째 결재자(FK)
    fouchecker int default 0,			-- 네번째 결재자(FK)
    fifchecker int default 0,			-- 다섯번째 결재자(FK)
	foreign key (rno) references report(rno) on delete no action,
    foreign key (firchecker) references emp(empno) on delete no action,
    foreign key (secchecker) references emp(empno) on delete no action,
    foreign key (thichecker) references emp(empno) on delete no action,
    foreign key (fouchecker) references emp(empno) on delete no action,
    foreign key (fifchecker) references emp(empno) on delete no action
);

use erp;
SELECT * FROM company;
SELECT * FROM cust;
select *from product;
select *from emp;
select *from request;
select *from emp;

select i.*,p.pname,p.pprice from info_request i join product p on i.pno=p.pno where i.rno = 1;
select r.*,e.ename,c.cname from request r join cust c on r.custno=c.custno join emp e on r.empno = e.empno where rno = 1;