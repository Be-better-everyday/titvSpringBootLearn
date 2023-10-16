create table if not exists users (
    username varchar(45),
    password varchar(60),
    enabled bool,
    primary key (username)
);

create table if not exists roles (
    username varchar(45),
    role varchar(60),
    foreign key (username) references users(username)
);

ALTER TABLE roles
ADD PRIMARY KEY (id);