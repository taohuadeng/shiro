--MySQL
drop database if exists shiro;
create database shiro;
use shiro;

create table users (
  id bigint auto_increment,
  username varchar(100),
  password varchar(100),
  password_salt varchar(100),
  constraint pk_users primary key(id)
) charset=utf8 ENGINE=InnoDB;
create unique index idx_users_username on users(username);

create table user_roles(
  id bigint auto_increment,
  username varchar(100),
  role_name varchar(100),
  constraint pk_user_roles primary key(id)
) charset=utf8 ENGINE=InnoDB;
create unique index idx_user_roles on user_roles(username, role_name);

create table roles_permissions(
  id bigint auto_increment,
  role_name varchar(100),
  permission varchar(100),
  constraint pk_roles_permissions primary key(id)
) charset=utf8 ENGINE=InnoDB;
create unique index idx_roles_permissions on roles_permissions(role_name, permission);

insert into users(username,password)values('tao','123456');

--Postgres
CREATE TABLE users (
	user_id VARCHAR (32) NOT NULL PRIMARY KEY,
	user_name VARCHAR (50) NOT NULL UNIQUE,
	password VARCHAR (32) NOT NULL,
	password_salt VARCHAR (32) NOT NULL
);

INSERT INTO "public"."users" ("user_id", "user_name", "password", "password_salt") VALUES ('uuuuuuuuuuuuuuuuuuuuuuuu', 'tao', '123456', '123456');

CREATE TABLE user_roles (
	rel_id VARCHAR (32) NOT NULL PRIMARY KEY,
	username VARCHAR (50) NOT NULL,
	role_name VARCHAR (50) NOT NULL
);

CREATE TABLE roles_permissions (
	rel_id VARCHAR (32) NOT NULL PRIMARY KEY,
	username VARCHAR (50) NOT NULL,
	permission VARCHAR (50) NOT NULL
);