CREATE TABLE IF NOT EXISTS questions (
title      VARCHAR(100)  PRIMARY KEY NOT NULL,
id int FOREIGN Key Not NULL,
promoted    BIT      ,
createdAt DATE  ,
updatedAt DATE
);

CREATE TABLE IF NOT EXISTS answers (
id int PRIMARY KEY NOT NULL ,
body      VARCHAR(500)  ,
channel VARCHAR
);

