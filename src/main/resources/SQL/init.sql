use course_db;

drop table if exists course_1;
drop table if exists course_2;

create table course_1
(
    cid     BIGINT PRIMARY KEY,
    cname   varchar(50) not null,
    user_id BIGINT  not null,
    cstatus varchar(10) not null
);

create table course_2
(
    cid     BIGINT PRIMARY KEY,
    cname   varchar(50) not null,
    user_id BIGINT  not null,
    cstatus varchar(10) not null
);

create table t_udic (
    dictid BIGINT PRIMARY KEY,
    ustatus VARCHAR(100) NOT NULL,
    uvalue VARCHAR (100) NOT NULL
)