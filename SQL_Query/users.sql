CREATE TABLE users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    enabled TINYINT NOT NULL
);

INSERT INTO users (username, `password`, enabled)
VALUES
	("nhdao", "{bcrypt}$2a$12$w1uZK/32zgUfyRgENvjS6Oif50yIQNbGNZCVn8i1lud1P9bLcjphW", 1),
	("qhoa", "{bcrypt}$2a$12$TE1zuBrGOb5tF7dENldoReTR5vqFYm6/VBwqBigzATntZejorwokC", 1),
	("nam", "{bcrypt}$2a$12$rc9W3/z9Y.vv.2/FmanzduSKjCDRKjTfJ4WroYO9ScUASwDn47aKW", 1),
	("quang", "{bcrypt}$2a$12$FBHJmpB/oh5Cy30yWV76zOSYF2u3n.eOarZz3j/jSWPXWkq9g2eTa", 1);
	
CREATE TABLE authorities (
    username VARCHAR(50) NOT NULL,student_management
    authority VARCHAR(50) NOT NULL,
    UNIQUE KEY (username, authority),
    CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username)
);
nam123
123456
hoa123
quang123

CREATE TABLE accounts (
    id VARCHAR(50) PRIMARY KEY,
    pw VARCHAR(100) NOT NULL,
    active TINYINT NOT NULL
);


CREATE TABLE roles (
    id VARCHAR(50) NOT NULL,
    `role` VARCHAR(50) NOT NULL,
    UNIQUE KEY (id, role),accounts
    CONSTRAINT fk_id FOREIGN KEY (id) REFERENCES accounts (id)
);

INSERT INTO rolerole (id, `role`)
VALUES
	("nam", "ROLE_ADMIN"),
	("quang", "ROLE_ADMIN"),
	("qhoa", "ROLE_MANAGER"),
	("nhdao", "ROLE_TEACHER");



	