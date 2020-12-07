
    alter table `administrator` 
       drop 
       foreign key FK_2a5vcjo3stlfcwadosjfq49l1;

    alter table `anonymous` 
       drop 
       foreign key FK_6lnbc6fo3om54vugoh8icg78m;

    alter table `audit_record` 
       drop 
       foreign key `FKdcrrgv6rkfw2ruvdja56un4ji`;

    alter table `audit_record` 
       drop 
       foreign key `FK47tigk6nwo26xcchn2ngnlj4f`;

    alter table `auditor` 
       drop 
       foreign key FK_clqcq9lyspxdxcp6o4f3vkelj;

    alter table `auditorrequest` 
       drop 
       foreign key `FKmj2lnje7xeeex43hlasdod3vj`;

    alter table `authenticated` 
       drop 
       foreign key FK_h52w0f3wjoi68b63wv9vwon57;

    alter table `buyer` 
       drop 
       foreign key FK_630a954if6nal5afofvjy73ob;

    alter table `consumer` 
       drop 
       foreign key FK_6cyha9f1wpj0dpbxrrjddrqed;

    alter table `forum` 
       drop 
       foreign key `FKrgdtbakxmpiv2k47q778a77qa`;

    alter table `item` 
       drop 
       foreign key `FK7r7pmef5wvaepffbi0xfrso2c`;

    alter table `message` 
       drop 
       foreign key `FK3ny0h1379q528toyokq81noiu`;

    alter table `message` 
       drop 
       foreign key `FKfwwpivgx5j4vw4594dgrw884q`;

    alter table `provider` 
       drop 
       foreign key FK_b1gwnjqm6ggy9yuiqm0o4rlmd;

    alter table `request` 
       drop 
       foreign key `FKxmj75t0jkph9b4xh8v8pph38`;

    alter table `request` 
       drop 
       foreign key `FKgc694uarnypqbqgbrmspm0mf5`;

    alter table `section` 
       drop 
       foreign key `FK1p9pdohs3k78gp2gsf86f0fsv`;

    alter table `supplier` 
       drop 
       foreign key FK_1h83guf8tf3di74bk4uhuo1ia;

    drop table if exists `administrator`;

    drop table if exists `advertisement`;

    drop table if exists `anonymous`;

    drop table if exists `audit_record`;

    drop table if exists `auditor`;

    drop table if exists `auditorrequest`;

    drop table if exists `authenticated`;

    drop table if exists `buyer`;

    drop table if exists `consumer`;

    drop table if exists `figment`;

    drop table if exists `forum`;

    drop table if exists `item`;

    drop table if exists `item_category`;

    drop table if exists `material`;

    drop table if exists `message`;

    drop table if exists `new`;

    drop table if exists `new_category`;

    drop table if exists `provider`;

    drop table if exists `request`;

    drop table if exists `section`;

    drop table if exists `spam`;

    drop table if exists `suggestion`;

    drop table if exists `supplier`;

    drop table if exists `toolsheet`;

    drop table if exists `user_account`;

    drop table if exists `hibernate_sequence`;
