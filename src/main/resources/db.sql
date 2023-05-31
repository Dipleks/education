create database loading
    with owner postgres;

create table public.words
(
    id          serial
        constraint words_pk
            primary key,
    original    varchar not null,
    translation varchar not null
);

comment on table public.words is 'Таблица слов';

comment on column public.words.original is 'Слово на английском';

comment on column public.words.translation is 'Слово на русском';

alter table public.words
    owner to postgres;