create table buffer
(
    id        int not null ,
    condition varchar not null,
    answer    varchar (50) not null,
    count    int default 3 not null
);