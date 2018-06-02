

-- ----------------------------------------------------- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS mydb DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema LOGDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema LOGDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS LOGDB DEFAULT CHARACTER SET latin1 ;
USE mydb ;
USE LOGDB ;

-- -----------------------------------------------------
-- Table LOGDB.USERS
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS LOGDB.USERS (
  ID INT(11) NOT NULL AUTO_INCREMENT,
  USERNAME VARCHAR(45) NOT NULL,
  PASSWORD VARCHAR(45) NOT NULL,
  ENABLE INT(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (ID))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table LOGDB.USER_ROLES
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS LOGDB.USER_ROLES (
  ID INT(11) NOT NULL AUTO_INCREMENT,
  USER_ID INT(11) NOT NULL,
  ROLE VARCHAR(45) NOT NULL,
  PRIMARY KEY (ID),
  INDEX fk_new_table_1_idx (USER_ID ASC),
  CONSTRAINT fk_new_table_1
    FOREIGN KEY (USER_ID)
    REFERENCES LOGDB.USERS (ID)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

ALTER TABLE LOGDB.USER_ROLES ADD COLUMN USERNAME VARCHAR(256) NOT NULL;
ALTER TABLE LOGDB.USERS MODIFY USERNAME VARCHAR(256);
ALTER TABLE LOGDB.USERS MODIFY PASSWORD VARCHAR(256);

