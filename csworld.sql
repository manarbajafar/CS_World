
CREATE SCHEMA csworld;

USE csworld;

CREATE TABLE userInfo (
  username VARCHAR(25) NOT NULL,
  email VARCHAR(45) NULL,
  password VARCHAR(45) NULL,
  PRIMARY KEY (username),
  UNIQUE INDEX email_UNIQUE (email ASC) VISIBLE);

CREATE TABLE score
(username VARCHAR(25)  NOT NULL,
 score INT,
 levelDoneNum INT,
 CONSTRAINT score_PK PRIMARY KEY (username),
 CONSTRAINT score_FK FOREIGN KEY (username) REFERENCES userInfo(username) ON DELETE CASCADE ON UPDATE CASCADE
 );