
    create table `administrator` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `advertisement` (
       `id` integer not null,
        `version` integer not null,
        `final_date` datetime(6),
        `inicial_date` datetime(6),
        `moment` datetime(6),
        `picture` varchar(255),
        `text` varchar(255),
        `title` varchar(255),
        `volume_discounts` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `anonymous` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `audit_record` (
       `id` integer not null,
        `version` integer not null,
        `body` varchar(255),
        `creation_moment` datetime(6),
        `status` integer,
        `title` varchar(255),
        `auditor_id` integer not null,
        `item_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `auditor` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `firm` varchar(255),
        `responsibility` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `authenticated` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `buyer` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `address` varchar(255),
        `credit_cardcvv` integer,
        `credit_card_month` integer,
        `credit_card_name` varchar(255),
        `credit_card_number` varchar(255),
        `credit_card_type` varchar(255),
        `credit_card_year` integer,
        `email` varchar(255),
        `phone` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `consumer` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `figment` (
       `id` integer not null,
        `version` integer not null,
        `description` varchar(255),
        `inventor` varchar(255),
        `moment` datetime(6),
        `range_max_amount` double precision,
        `range_max_currency` varchar(255),
        `range_min_amount` double precision,
        `range_min_currency` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `forum` (
       `id` integer not null,
        `version` integer not null,
        `title` varchar(255),
        `item_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `item` (
       `id` integer not null,
        `version` integer not null,
        `creation_moment` datetime(6),
        `description` varchar(255),
        `item_category` varchar(255),
        `link` varchar(255),
        `photo` varchar(255),
        `price_amount` double precision,
        `price_currency` varchar(255),
        `status` integer,
        `ticker` varchar(255),
        `title` varchar(255),
        `supplier_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `item_category` (
       `id` integer not null,
        `version` integer not null,
        `items` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `material` (
       `id` integer not null,
        `version` integer not null,
        `description` varchar(255),
        `home_page` varchar(255),
        `provider_name` varchar(255),
        `stars` integer,
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `message` (
       `id` integer not null,
        `version` integer not null,
        `body` varchar(255),
        `creation_moment` datetime(6),
        `tags` varchar(255),
        `title` varchar(255),
        `authenticated_id` integer not null,
        `forum_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `new` (
       `id` integer not null,
        `version` integer not null,
        `body` varchar(255),
        `category` varchar(255),
        `creation_moment` datetime(6),
        `deadline_moment` datetime(6),
        `header_picture` varchar(255),
        `links` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `new_category` (
       `id` integer not null,
        `version` integer not null,
        `categories` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `provider` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `request` (
       `id` integer not null,
        `version` integer not null,
        `creation_moment` datetime(6),
        `notes` varchar(255),
        `quantity` integer,
        `ticker` varchar(255),
        `buyer_id` integer not null,
        `item_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `section` (
       `id` integer not null,
        `version` integer not null,
        `description` varchar(255),
        `index_` integer,
        `photo` varchar(255),
        `title` varchar(255),
        `item_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `spam` (
       `id` integer not null,
        `version` integer not null,
        `threshold` double precision,
        `words` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `suggestion` (
       `id` integer not null,
        `version` integer not null,
        `creation_moment` datetime(6),
        `email` varchar(255),
        `text` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `supplier` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `description` varchar(255),
        `home_page` varchar(255),
        `item_category` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `toolsheet` (
       `id` integer not null,
        `version` integer not null,
        `description` varchar(255),
        `home_page` varchar(255),
        `provider_name` varchar(255),
        `stars` integer,
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `user_account` (
       `id` integer not null,
        `version` integer not null,
        `enabled` bit not null,
        `identity_email` varchar(255),
        `identity_name` varchar(255),
        `identity_surname` varchar(255),
        `password` varchar(255),
        `username` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `hibernate_sequence` (
       `next_val` bigint
    ) engine=InnoDB;

    insert into `hibernate_sequence` values ( 1 );

    alter table `buyer` 
       add constraint UK_r3ondcmf3r5ogjok74v1gq8hj unique (`phone`);

    alter table `forum` 
       add constraint UK_c5hjl933amnwf8mq1v2lf45jo unique (`item_id`);

    alter table `item` 
       add constraint UK_d60jfv0vlrqswikfeec1le23u unique (`ticker`);

    alter table `request` 
       add constraint UK_9mxq3powq8tqctclj0fbi2nih unique (`ticker`);

    alter table `user_account` 
       add constraint UK_castjbvpeeus0r8lbpehiu0e4 unique (`username`);

    alter table `administrator` 
       add constraint FK_2a5vcjo3stlfcwadosjfq49l1 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `anonymous` 
       add constraint FK_6lnbc6fo3om54vugoh8icg78m 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `audit_record` 
       add constraint `FKdcrrgv6rkfw2ruvdja56un4ji` 
       foreign key (`auditor_id`) 
       references `auditor` (`id`);

    alter table `audit_record` 
       add constraint `FK47tigk6nwo26xcchn2ngnlj4f` 
       foreign key (`item_id`) 
       references `item` (`id`);

    alter table `auditor` 
       add constraint FK_clqcq9lyspxdxcp6o4f3vkelj 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `authenticated` 
       add constraint FK_h52w0f3wjoi68b63wv9vwon57 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `buyer` 
       add constraint FK_630a954if6nal5afofvjy73ob 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `consumer` 
       add constraint FK_6cyha9f1wpj0dpbxrrjddrqed 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `forum` 
       add constraint `FKrgdtbakxmpiv2k47q778a77qa` 
       foreign key (`item_id`) 
       references `item` (`id`);

    alter table `item` 
       add constraint `FK7r7pmef5wvaepffbi0xfrso2c` 
       foreign key (`supplier_id`) 
       references `supplier` (`id`);

    alter table `message` 
       add constraint `FK3ny0h1379q528toyokq81noiu` 
       foreign key (`authenticated_id`) 
       references `authenticated` (`id`);

    alter table `message` 
       add constraint `FKfwwpivgx5j4vw4594dgrw884q` 
       foreign key (`forum_id`) 
       references `forum` (`id`);

    alter table `provider` 
       add constraint FK_b1gwnjqm6ggy9yuiqm0o4rlmd 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `request` 
       add constraint `FKxmj75t0jkph9b4xh8v8pph38` 
       foreign key (`buyer_id`) 
       references `buyer` (`id`);

    alter table `request` 
       add constraint `FKgc694uarnypqbqgbrmspm0mf5` 
       foreign key (`item_id`) 
       references `item` (`id`);

    alter table `section` 
       add constraint `FK1p9pdohs3k78gp2gsf86f0fsv` 
       foreign key (`item_id`) 
       references `item` (`id`);

    alter table `supplier` 
       add constraint FK_1h83guf8tf3di74bk4uhuo1ia 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);
