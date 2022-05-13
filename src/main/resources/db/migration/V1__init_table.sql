-- auto-generated definition
create table user_info
(
    account_name character,
    token        character,
    gmt_create   bigint,
    gmt_modified bigint,
    account_id   character not null,
    bio          character,
    avatar_url   character,
    password     character,
    email        character,
    salt         character,
    status       integer default 0,
    constraint user_info_pk
        primary key (account_id)
);

-- auto-generated definition
create table star_record
(
    id           bigint auto_increment,
    target_id    bigint    not null,
    gmt_create   bigint,
    gmt_modified bigint,
    star_creator character not null,
    constraint star_record_pk
        primary key (id)
);

-- auto-generated definition
create table question
(
    id            bigint auto_increment
        primary key,
    title         character,
    description   character,
    gmt_create    bigint,
    gmt_modified  bigint,
    creator       character,
    comment_count bigint  default 0,
    view_count    bigint  default 0,
    like_count    bigint  default 0,
    tag           character,
    star_count    bigint,
    sticky        integer default 0
);

-- auto-generated definition
create table notification
(
    id            bigint auto_increment,
    notifier      character         not null,
    receiver      character         not null,
    outer_id      bigint            not null,
    type          integer           not null,
    gmt_create    bigint            not null,
    status        integer default 0 not null,
    notifier_name character,
    outer_title   character,
    constraint notification_pk
        primary key (id)
);

-- auto-generated definition
create table nav
(
    id           integer auto_increment,
    title        character,
    url          character,
    priority     integer default 0,
    gmt_create   bigint,
    gmt_modified bigint,
    status       integer,
    constraint nav_pk
        primary key (id)
);

-- auto-generated definition
create table like_record
(
    id           bigint auto_increment,
    target_id    bigint    not null,
    gmt_create   bigint,
    gmt_modified bigint,
    like_creator character not null,
    constraint like_pk
        primary key (id)
);

-- auto-generated definition
create table comment
(
    id            bigint auto_increment,
    parent_id     bigint,
    comment_type  integer,
    gmt_create    bigint,
    gmt_modified  bigint,
    like_count    bigint default 0,
    content       character,
    commentator   character,
    comment_count bigint default 0,
    constraint comment_pk
        primary key (id)
);


