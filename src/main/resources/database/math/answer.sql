create table answer
(
    id       serial
        constraint answer_pk
            primary key,
    datetime varchar               not null,
    number   integer               not null,
    decision boolean default false not null
);

comment on table answer is 'Ответы пользователя';

comment on column answer.datetime is 'Дата и время записи ответа на задачу';

comment on column answer.number is 'Номер задачи';

comment on column answer.decision is 'Ответ пользователя';

alter table answer
    owner to postgres;


