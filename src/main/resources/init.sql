CREATE SCHEMA IF NOT EXISTS human_friends_db;
USE human_friends_db;

CREATE TABLE IF NOT EXISTS type_of_animal
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    type_name VARCHAR(50) NOT NULL UNIQUE
);

INSERT IGNORE INTO type_of_animal (type_name)
VALUES ('HumanFriends');


CREATE TABLE IF NOT EXISTS type_of_animal_tree
(
    parent BIGINT null,
    child  BIGINT null,
    CONSTRAINT type_of_animal_tree_type_of_animal_id_fk
        FOREIGN KEY (parent) REFERENCES type_of_animal (id),
    CONSTRAINT type_of_animal_tree_type_of_animal_id_fk2
        FOREIGN KEY (child) REFERENCES type_of_animal (id)
);
INSERT INTO type_of_animal_tree (parent, child)
VALUES (null, 1);


CREATE TABLE IF NOT EXISTS human_friends
(
    id          BIGINT AUTO_INCREMENT
        primary key,
    name        VARCHAR(100) NULL,
    birth_DATE  DATE         NOT NULL,
    animal_type BIGINT       NULL,
    constraint human_friends_type_of_animal_id_fk
        FOREIGN KEY (animal_type) REFERENCES type_of_animal (id)
);

CREATE TABLE IF NOT EXISTS commands
(
    id           BIGINT AUTO_INCREMENT,
    command_name VARCHAR(50) NOT NULL UNIQUE,
    CONSTRAINT commands_pk
        PRIMARY KEY (id)
);


INSERT IGNORE INTO commands (command_name)
VALUES ('sleep');
INSERT IGNORE INTO commands (command_name)
VALUES ('go');
INSERT IGNORE INTO commands (command_name)
VALUES ('go away');
INSERT IGNORE INTO commands (command_name)
VALUES ('be quiet');
INSERT IGNORE INTO commands (command_name)
VALUES ('lets dance');

CREATE TABLE IF NOT EXISTS one_animal_commands
(
    animal_id  BIGINT NOT NULL,
    command_id BIGINT NOT NULL,
    CONSTRAINT one_animal_commands_commands_id_fk
        FOREIGN KEY (command_id) REFERENCES commands (id),
    CONSTRAINT one_animal_commands_human_friends_id_fk
        FOREIGN KEY (animal_id) REFERENCES human_friends (id)
);


