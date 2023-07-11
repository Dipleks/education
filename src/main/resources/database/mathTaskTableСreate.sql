create table task
(
    id        serial
        constraint id
            primary key,
    number    integer               not null,
    condition varchar               not null,
    answer    varchar               not null,
    status    boolean default false not null
);

comment on table task is 'Условия задач';

comment on column task.number is 'Номер задачи';

comment on column task.condition is 'Условие задачи';

comment on column task.answer is 'Правильный ответ решенной задачи';

comment on column task.status is 'Ответ по умолчанию';

alter table task
    owner to postgres;


