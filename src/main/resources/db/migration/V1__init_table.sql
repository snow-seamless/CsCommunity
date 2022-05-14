-- auto-generated definition
create table comment
(
    id            bigint auto_increment
        primary key,
    parent_id     bigint           null,
    comment_type  int              null,
    gmt_create    bigint           null,
    gmt_modified  bigint           null,
    like_count    bigint default 0 null,
    content       varchar(1024)    null,
    commentator   varchar(30)      null,
    comment_count bigint default 0 null
);

-- auto-generated definition
create table like_record
(
    id           bigint auto_increment
        primary key,
    target_id    bigint      not null,
    gmt_create   bigint      null,
    gmt_modified bigint      null,
    like_creator varchar(30) not null
);

-- auto-generated definition
create table nav
(
    id           int auto_increment
        primary key,
    title        varchar(30)   null,
    url          varchar(30)   null,
    priority     int default 0 null,
    gmt_create   bigint        null,
    gmt_modified bigint        null,
    status       int           null
);

-- auto-generated definition
create table notification
(
    id            bigint auto_increment
        primary key,
    notifier      varchar(30)   not null,
    receiver      varchar(30)   not null,
    outer_id      bigint        not null,
    type          int           not null,
    gmt_create    bigint        not null,
    status        int default 0 not null,
    notifier_name varchar(50)   null,
    outer_title   varchar(50)   null
);

-- auto-generated definition
create table question
(
    id            bigint auto_increment
        primary key,
    title         varchar(50)      null,
    description   varchar(1024)    null,
    gmt_create    bigint           null,
    gmt_modified  bigint           null,
    creator       varchar(30)      null,
    comment_count bigint default 0 null,
    view_count    bigint default 0 null,
    like_count    bigint default 0 null,
    tag           varchar(255)     null,
    star_count    bigint           null,
    sticky        int    default 0 null
);

-- auto-generated definition
create table star_record
(
    id           bigint auto_increment
        primary key,
    target_id    bigint      not null,
    gmt_create   bigint      null,
    gmt_modified bigint      null,
    star_creator varchar(30) not null
);

-- auto-generated definition
create table user_info
(
    account_name varchar(50)   null,
    token        varchar(100)  null,
    gmt_create   bigint        null,
    gmt_modified bigint        null,
    account_id   varchar(30)   not null
        primary key,
    bio          varchar(255)  null,
    avatar_url   varchar(100)  null,
    password     varchar(100)  null,
    email        varchar(100)  null,
    salt         varchar(100)  null,
    status       int default 0 null
);

