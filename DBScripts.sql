
/*All User's gets stored in APP_USER table*/	
create table APP_USER (
   id BIGINT NOT NULL AUTO_INCREMENT,
   sso_id VARCHAR(30) NOT NULL,
   password VARCHAR(100) NOT NULL,
   first_name VARCHAR(30) NOT NULL,
   last_name  VARCHAR(30) NOT NULL,
   email VARCHAR(30) NOT NULL,
   PRIMARY KEY (id),
   UNIQUE (sso_id)
);
   
/* USER_PROFILE table contains all possible roles */ 
create table USER_PROFILE(
   id BIGINT NOT NULL AUTO_INCREMENT,
   type VARCHAR(30) NOT NULL,
   PRIMARY KEY (id),
   UNIQUE (type)
);
   
/* JOIN TABLE for MANY-TO-MANY relationship*/  
CREATE TABLE APP_USER_USER_PROFILE (
    user_id BIGINT NOT NULL,
    user_profile_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, user_profile_id),
    CONSTRAINT FK_APP_USER FOREIGN KEY (user_id) REFERENCES APP_USER (id),
    CONSTRAINT FK_USER_PROFILE FOREIGN KEY (user_profile_id) REFERENCES USER_PROFILE (id)
);
  

/* Create persistent_logins Table used to store rememberme related stuff*/
CREATE TABLE PERSISTENT_LOGINS (
    username VARCHAR(64) NOT NULL,
    series VARCHAR(64) NOT NULL,
    token VARCHAR(64) NOT NULL,
    last_used TIMESTAMP NOT NULL,
    PRIMARY KEY (series)
);

--benim tablolar
create table TASK (
   id BIGINT NOT NULL AUTO_INCREMENT,
   taskId INT NOT NULL,
   parentId INT NOT NULL,
   taskName VARCHAR(100) NOT NULL,
   PRIMARY KEY (id)
);

create table TASKDETAIL (
   id BIGINT NOT NULL AUTO_INCREMENT,
   taskId INT NOT NULL,
   taskDetailId INT NOT NULL,
   taskDetailName VARCHAR(100) NOT NULL,
   PRIMARY KEY (id)
);

create table TASKINFO (
   taskInfoId BIGINT NOT NULL AUTO_INCREMENT,
   ssoId VARCHAR(100) NOT NULL,
   taskId INT NOT NULL,
   taskDetailId INT NOT NULL,
   taskSelfStudy BOOLEAN NULL,
   taskSelfStudyDesc VARCHAR(100) NULL,
   taskBeenStudied BOOLEAN NULL,
   taskBeenStudiedDesc VARCHAR(100) NULL,
   taskPracticeQuestionNum INT NULL,
   taskPracticeRightNum INT NULL,
   taskPracticeWrongNum INT NULL,
   taskPracticeDuration INT NULL,
   taskPracticeLessonToBeStudy INT NULL,
   PRIMARY KEY (taskInfoId)
);

create table TASKMILESTONE (
   id BIGINT NOT NULL AUTO_INCREMENT,
   ssoId VARCHAR(100) NOT NULL,
   denemeId INT NOT NULL,
   tytTurkce FLOAT,
   tytMatematik FLOAT,
   tytFizik FLOAT,
   tytKimya FLOAT,
   tytBiyoloji FLOAT,
   tytTarih FLOAT,
   tytCografya FLOAT,
   tytFelsefe FLOAT,
   tytDin FLOAT,
   yksMatematik FLOAT,
   yksFizik FLOAT,
   yksKimya FLOAT,
   yksBiyoloji FLOAT,
   yksEdebiyat FLOAT,
   yksCografya1 FLOAT,
   yksTarih1 FLOAT,
   yksCografya2 FLOAT,
   yksTarih2 FLOAT,
   yksFelsefe FLOAT,
   yksDin FLOAT,
   PRIMARY KEY (id)
);

create table TASKPLAN (
	id BIGINT NOT NULL AUTO_INCREMENT,
	ssoId VARCHAR(100) NOT NULL,
	taskId INT NOT NULL,
	taskDetailId INT NOT NULL,
	taskSelfStudy BOOLEAN NULL,
	taskBeenStudied BOOLEAN NULL,
	description VARCHAR(100) NULL,
	descriptionDetail VARCHAR(1000) NULL,
	status INT NULL,
	startDate DATE NULL,
	endDate DATE NULL,
	PRIMARY KEY (id)
);