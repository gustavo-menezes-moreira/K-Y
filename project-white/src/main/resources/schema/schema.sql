CREATE SEQUENCE users_id;

CREATE TABLE main_users (
    id         	bigint(20) AUTO_INCREMENT NOT NULL,
    name       	varchar(255) NOT NULL,
    username    varchar(255) NOT NULL,
    PRIMARY KEY(id)
);
