create database bankmanagementsystem;

show databases;
use bankmanagementsystem;

create table signup(formno varchar(20), name varchar(20), father_name varchar(20), dob varchar(20), gender varchar(20), email varchar(200), marital_status varchar(20), address varchar(200), city varchar(20), state varchar(20), pincode varchar(20));

show tables;
select * from signup;
ALTER TABLE signup MODIFY email VARCHAR(100) ;
select * from signup;

create table signupTwo(formno varchar(20), religion varchar(20), category varchar(20), education varchar(20), occupation varchar(20), pan varchar(20), adhaar varchar(20), senior varchar(20), accountExit varchar(20));
show tables;
DROP table signupTwo;
create table signupTwo(formno varchar(20), religion varchar(20), category varchar(20), education varchar(20),income varchar(20), occupation varchar(20), pan varchar(20), adhaar varchar(20), senior varchar(20), accountExit varchar(20));
show tables;
select * from signupTwo;

create table signupThree(fomrno varchar(20), accountType varchar(40), cardnumber varchar(25), pin varchar(4), facility varchar(100));
select * from signupThree;
ALTER TABLE signupThree MODIFY pin VARCHAR(10) ;
show tables;
select * from signupThree;

create table login(formno varchar(20), cardnumber varchar(25), pin varchar(10));
select * from login;

create table bank(pin varchar(10), date varchar(20), type varchar(20), amount varchar(20));
ALTER TABLE bank MODIFY date varchar(50) ;

select * from bank;


