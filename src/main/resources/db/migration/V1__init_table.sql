-- auto-generated definition
create table USER_INFO
(
    ID           BIGINT auto_increment,
    ACCOUNT_NAME CHARACTER,
    TOKEN        CHARACTER,
    GMT_CREATE   BIGINT,
    GMT_MODIFIED BIGINT,
    ACCOUNT_ID   CHARACTER not null,
    BIO          CHARACTER,
    AVATAR_URL   CHARACTER,
    PASSWORD     CHARACTER,
    EMAIL        CHARACTER,
    SALT         CHARACTER,
    STATUS       INTEGER default 0,
    constraint USER_INFO_PK
        primary key (ACCOUNT_ID)
);

-- auto-generated definition
create table STAR_RECORD
(
    ID           BIGINT auto_increment,
    TARGET_ID    BIGINT    not null,
    GMT_CREATE   BIGINT,
    GMT_MODIFIED BIGINT,
    STAR_CREATOR CHARACTER not null,
    constraint STAR_RECORD_PK
        primary key (ID)
);

-- auto-generated definition
create table QUESTION
(
    ID            BIGINT auto_increment
        primary key,
    TITLE         CHARACTER,
    DESCRIPTION   CHARACTER,
    GMT_CREATE    BIGINT,
    GMT_MODIFIED  BIGINT,
    CREATOR       CHARACTER,
    COMMENT_COUNT BIGINT  default 0,
    VIEW_COUNT    BIGINT  default 0,
    LIKE_COUNT    BIGINT  default 0,
    TAG           CHARACTER,
    STAR_COUNT    BIGINT,
    STICKY        INTEGER default 0
);

-- auto-generated definition
create table NOTIFICATION
(
    ID            BIGINT auto_increment,
    NOTIFIER      CHARACTER         not null,
    RECEIVER      CHARACTER         not null,
    OUTER_ID      BIGINT            not null,
    TYPE          INTEGER           not null,
    GMT_CREATE    BIGINT            not null,
    STATUS        INTEGER default 0 not null,
    NOTIFIER_NAME CHARACTER,
    OUTER_TITLE   CHARACTER,
    constraint NOTIFICATION_PK
        primary key (ID)
);

-- auto-generated definition
create table NAV
(
    ID           INTEGER auto_increment,
    TITLE        CHARACTER,
    URL          CHARACTER,
    PRIORITY     INTEGER default 0,
    GMT_CREATE   BIGINT,
    GMT_MODIFIED BIGINT,
    STATUS       INTEGER,
    constraint NAV_PK
        primary key (ID)
);

-- auto-generated definition
create table LIKE_RECORD
(
    ID           BIGINT auto_increment,
    TARGET_ID    BIGINT    not null,
    GMT_CREATE   BIGINT,
    GMT_MODIFIED BIGINT,
    LIKE_CREATOR CHARACTER not null,
    constraint LIKE_PK
        primary key (ID)
);

-- auto-generated definition
create table COMMENT
(
    ID            BIGINT auto_increment,
    PARENT_ID     BIGINT,
    COMMENT_TYPE  INTEGER,
    GMT_CREATE    BIGINT,
    GMT_MODIFIED  BIGINT,
    LIKE_COUNT    BIGINT default 0,
    CONTENT       CHARACTER,
    COMMENTATOR   CHARACTER,
    COMMENT_COUNT BIGINT default 0,
    constraint COMMENT_PK
        primary key (ID)
);


