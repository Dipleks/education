create table tasks
(
    number    serial
        primary key,
    condition varchar               not null,
    answer    varchar               not null,
    status    boolean default false not null
);

comment on table tasks is 'Задачи по математике';

comment on column tasks.number is 'Номер задачи';

comment on column tasks.condition is 'Условие задачи';

comment on column tasks.answer is 'Ответ на задачу';

comment on column tasks.status is 'Статут задачи';

alter table tasks
    owner to postgres;


