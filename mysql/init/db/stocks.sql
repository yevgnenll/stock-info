CREATE SCHEMA IF NOT EXISTS `stocks`;
USE `stocks`;

create table stocks.stock (
    id         bigint auto_increment
        primary key,
    close      int         not null,
    created_at datetime(6) null,
    high       int         not null,
    low        int         not null,
    open       int         not null,
    timestamp  date        null,
    updated_at datetime(6) null,
    volume     int         not null
);


