create table USER
(
    id         INT AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name  VARCHAR(50),
    email      VARCHAR(50),
    gender     VARCHAR(50),
    ip_address VARCHAR(20)
);

create table JOKE
(
    id         INT AUTO_INCREMENT,
    externalId VARCHAR(50),
    value      VARCHAR(50)
);