create table words
(
    id          serial
        constraint words_pk
            primary key,
    original    varchar               not null,
    translation varchar               not null,
    favorites   boolean default false not null
);

comment on table words is 'Таблица слов';

comment on column words.original is 'Слово на английском';

comment on column words.translation is 'Слово на русском';

comment on column words.favorites is 'Избранное';

alter table words
    owner to postgres;