use xuantudbspringmvc;

DROP TABLE role;
CREATE TABLE role(
 id bigint NOT NULL PRIMARY KEY auto_increment,
 name VARCHAR(255) NOT NULL,
 code VARCHAR(255) NOT NULL,
 createddate TIMESTAMP NULL,
 modifieddate TIMESTAMP NULL,
 createby VARCHAR(255)  NULL,
 modifieldby VARCHAR(255)  NULL
 );
 
DROP TABLE user;
 CREATE TABLE user(
  id bigint NOT NULL PRIMARY KEY auto_increment,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  fullname VARCHAR(255) NULL,
  status int NOT NULL,
  roleid bigint NOT NULL,
  createddate TIMESTAMP NULL,
  modifieddate TIMESTAMP NULL,
  createby VARCHAR(255)  NULL,
  modifieldby VARCHAR(255) ); 

ALTER TABLE user ADD CONSTRAINT fk_user_role FOREIGN KEY (roleidfk_user_role) REFERENCES role(id);

 CREATE TABLE news(
  id bigint NOT NULL PRIMARY KEY auto_increment,
  title VARCHAR(255) NULL,
  thumbnail VARCHAR(255) NULL,
  shortdecription TEXT  NULL,
  content TEXT  NULL,
  categoryid bigint NOT NULL,
  createddate TIMESTAMP NULL,
  modifieddate TIMESTAMP NULL,
  createby VARCHAR(255)  NULL,
  modifieldby VARCHAR(255) ); 
  
  
  CREATE TABLE category(
  id bigint NOT NULL PRIMARY KEY auto_increment,
  name VARCHAR(255) NOT NULL,
  code VARCHAR(255) NOT NULL,
  createddate TIMESTAMP NULL,
  modifieddate TIMESTAMP NULL,
  createby VARCHAR(255)  NULL,
  modifieldby VARCHAR(255) ); 
  
  ALTER TABLE news ADD CONSTRAINT fk_news_category FOREIGN KEY (categoryid) REFERENCES category(id);
  
CREATE TABLE comment(
  id bigint NOT NULL PRIMARY KEY auto_increment,
  content TEXT NOT NULL,
  user_id bigint NOT NULL,
  new_id bigint NOT NULL,
  createddate TIMESTAMP NULL,
  modifieddate TIMESTAMP NULL,
  createby VARCHAR(255)  NULL,
  modifieldby VARCHAR(255) ); 
  
  ALTER TABLE comment ADD CONSTRAINT fk_comment_user FOREIGN KEY (user_id) REFERENCES user(id);
  ALTER TABLE comment ADD CONSTRAINT fk_comment_news FOREIGN KEY (new_id) REFERENCES news(id);

  
  
  

  
  
  
  
  
  
 