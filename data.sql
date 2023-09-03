DROP TABLE IF EXISTS student;

CREATE TABLE student (
    id int(11) NOT NULL AUTO_INCREMENT,
    first_name varchar(300) NOT NULL,
    last_name varchar(300) NOT NULL,
    email varchar(300) NOT NULL,
    PRIMARY KEY (id)
);