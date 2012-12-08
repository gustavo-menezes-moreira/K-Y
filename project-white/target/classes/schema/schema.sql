CREATE TABLE main_users (
    id         	bigint(20) AUTO_INCREMENT NOT NULL,
    name       	varchar(255) NOT NULL,
    username    varchar(255) NOT NULL,
    password    varchar(255) NOT NULL,
    assistant	bit(1) NOT NULL DEFAULT 1,
    expiration	TIMESTAMP NOT NULL,
    last_login 	TIMESTAMP,
    try_login	TINYINT NOT NULL DEFAULT 0,
    PRIMARY KEY(id)
);

CREATE TABLE doctor_assistant (
	doctor_id		bigint(20) NOT NULL,
	assistant_id	bigint(20) NOT NULL
);

ALTER TABLE main_users
	ADD CONSTRAINT uk_user_username
	UNIQUE KEY(username)
;

ALTER TABLE doctor_assistant
	ADD CONSTRAINT fk_doctor_user
	FOREIGN KEY(doctor_id) REFERENCES main_users(id)
;

ALTER TABLE doctor_assistant
	ADD CONSTRAINT fk_assistant_user
	FOREIGN KEY(assistant_id) REFERENCES main_users(id)
;
