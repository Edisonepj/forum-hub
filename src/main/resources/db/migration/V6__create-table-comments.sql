create table comments(
    id bigint not null auto_increment,
    message text not null,
    created_at datetime not null,
    user_id bigint not null,
    topic_id bigint not null,
    solution boolean default false,

    primary key(id),
    constraint fk_comments_user_id foreign key(user_id) references users(id),
    constraint fk_comments_topic_id foreign key(topic_id) references topics(id)
);
