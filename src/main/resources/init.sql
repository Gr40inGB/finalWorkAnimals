CREATE SCHEMA IF NOT EXISTS human_friends_db;
USE human_friends_db;

CREATE TABLE IF NOT EXISTS type_of_animal
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    type_name VARCHAR(50) NOT NULL UNIQUE,
    parent    BIGINT      NULL,
    CONSTRAINT type_of_animal_type_of_animal_id_fk
        FOREIGN KEY (parent) REFERENCES type_of_animal (id)
);

INSERT IGNORE INTO type_of_animal (type_name)
VALUES ('HumanFriends');

SELECT id
INTO @id
FROM type_of_animal
WHERE type_name = 'HumanFriends';

INSERT IGNORE INTO type_of_animal (type_name, parent)
VALUES ('PackAnimals', @id);
INSERT IGNORE INTO type_of_animal (type_name, parent)
VALUES ('Pets', @id);

SELECT id
INTO @id
FROM type_of_animal
WHERE type_name = 'PackAnimals';

INSERT IGNORE INTO type_of_animal (type_name, parent)
VALUES ('Camel', @id);
INSERT IGNORE INTO type_of_animal (type_name, parent)
VALUES ('Donkey', @id);
INSERT IGNORE INTO type_of_animal (type_name, parent)
VALUES ('Horse', @id);

SELECT id
INTO @id
FROM type_of_animal
WHERE type_name = 'Pets';

INSERT IGNORE INTO type_of_animal (type_name, parent)
VALUES ('Cat', @id);
INSERT IGNORE INTO type_of_animal (type_name, parent)
VALUES ('Dog', @id);
INSERT IGNORE INTO type_of_animal (type_name, parent)
VALUES ('Hamster', @id);


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


