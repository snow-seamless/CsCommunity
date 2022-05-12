-- auto-generated definition
create table USER_INFO
(
    ID           INTEGER auto_increment,
    ACCOUNT_NAME CHARACTER(50),
    TOKEN        CHARACTER(36),
    GMT_CREATE   BIGINT,
    GMT_MODIFIED BIGINT,
    ACCOUNT_ID   BIGINT,
    BIO          CHARACTER(255),
    constraint USER_INFO_PK
        primary key (ID)
);

