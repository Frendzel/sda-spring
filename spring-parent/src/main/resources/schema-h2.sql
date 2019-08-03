create table USER
(
    id         INT,
    first_name VARCHAR(50),
    last_name  VARCHAR(50),
    email      VARCHAR(50),
    gender     VARCHAR(50),
    ip_address VARCHAR(20)
);

create table JOKE
(
    id         INT,
    externalId VARCHAR(50),
    value      VARCHAR(50)
);