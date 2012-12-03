CREATE TABLE main_users (
    id         	bigint(20) AUTO_INCREMENT NOT NULL,
    name       	varchar(255) NOT NULL,
    username    varchar(255) NOT NULL,
    password    varchar(255) NOT NULL,
    assistant	bit(1) NOT NULL DEFAULT 1,
    PRIMARY KEY(id)
);

ALTER TABLE main_users
	ADD CONSTRAINT uk_user_username
	UNIQUE KEY(username)
;
