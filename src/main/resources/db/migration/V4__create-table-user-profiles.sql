create table user_profiles(
    user_id bigint not null,
    profile_id bigint not null,

    primary key(user_id, profile_id),
    constraint fk_user_profiles_user_id foreign key(user_id) references users(id),
    constraint fk_user_profiles_profile_id foreign key(profile_id) references profiles(id)
);