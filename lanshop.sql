create database lanshop
use lanshop
create table role(
	ROLE_ID BIGINT not null,
    ROLE_NAME VARCHAR(30) not null
);
ALTER TABLE role ADD CONSTRAINT APP_ROLE_PK primary key (ROLE_ID);
ALTER TABLE role ADD CONSTRAINT APP_ROLE_UK unique (ROLE_NAME);

create table user(
	USER_ID BIGINT not null,
    USER_NAME nvarchar(100) not null,
    ENCRYTED_PASSWORD varchar(100) not null,
    ENABLED BIT not null,
    ADDRESS nvarchar(100),
    EMAIL varchar(50),
    PHONE varchar(15),
    RESET_TOKEN varchar(36)
);

ALTER TABLE user ADD CONSTRAINT APP_USER_PK primary key (USER_ID);
ALTER TABLE user ADD CONSTRAINT APP_USER_UK unique (USER_NAME);

create table USER_ROLE(
	ID BIGINT not null,
    USER_ID BIGINT not null,
    ROLE_ID BIGINT not null
);
alter table USER_ROLE add constraint USER_ROLE_PK primary key (ID);
alter table USER_ROLE add constraint USER_ROLE_UK unique (USER_ID, ROLE_ID);

alter table USER_ROLE add constraint USER_ROLE_FK1 foreign key (USER_ID)
references user (USER_ID);

alter table USER_ROLE add constraint USER_ROLE_FK2 foreign key (ROLE_ID)
references role (ROLE_ID);