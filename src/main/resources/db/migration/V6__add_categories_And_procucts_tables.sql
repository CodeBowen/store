-- Create categories table
create table categories
(
    id   tinyint auto_increment
        primary key,
    name varchar(255) not null
);


--  Create products table
create table products
(
    id            bigint auto_increment
        primary key,
    categories_id tinyint        not null,
    name          varchar(255)   not null,
    price         decimal(10, 2) not null,
    constraint products_categories_id_fk
        foreign key (categories_id) references categories (id) on delete RESTRICT
);