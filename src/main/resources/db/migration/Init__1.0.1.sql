SET
    statement_timeout = 0;
SET
    lock_timeout = 0;
SET
    idle_in_transaction_session_timeout = 0;
SET
    client_encoding = 'UTF8';
SET
    standard_conforming_strings = on;
SET
    check_function_bodies = false;
SET
    xmloption = content;
SET
    client_min_messages = warning;
SET
    row_security = off;

SET
    default_tablespace = '';

SET
    default_table_access_method = heap;

--
-- -- Adminer 4.8.1 PostgreSQL 14.2 (Debian 14.2-1.pgdg110+1) dump
--
-- \connect "mystage";
--
-- DROP TABLE IF EXISTS "address";
-- CREATE TABLE "public"."address"
-- (
--     "id"      bigint NOT NULL,
--     "address" character varying(255),
--     CONSTRAINT "address_pkey" PRIMARY KEY ("id")
-- ) WITH (oids = false);
--
--
-- DROP TABLE IF EXISTS "credit_card";
-- CREATE TABLE "public"."credit_card"
-- (
--     "id"          bigint NOT NULL,
--     "cvv"         character varying(255),
--     "amount"      real   NOT NULL,
--     "card_number" character varying(255),
--     "expiry_date" timestamp,
--     CONSTRAINT "credit_card_pkey" PRIMARY KEY ("id")
-- ) WITH (oids = false);
--
--
-- DROP TABLE IF EXISTS "flyway_schema_history";
-- CREATE TABLE "public"."flyway_schema_history"
-- (
--     "installed_rank" integer                 NOT NULL,
--     "version"        character varying(50),
--     "description"    character varying(200)  NOT NULL,
--     "type"           character varying(20)   NOT NULL,
--     "script"         character varying(1000) NOT NULL,
--     "checksum"       integer,
--     "installed_by"   character varying(100)  NOT NULL,
--     "installed_on"   timestamp DEFAULT now() NOT NULL,
--     "execution_time" integer                 NOT NULL,
--     "success"        boolean                 NOT NULL,
--     CONSTRAINT "flyway_schema_history_pk" PRIMARY KEY ("installed_rank")
-- ) WITH (oids = false);
--
-- CREATE INDEX "flyway_schema_history_s_idx" ON "public"."flyway_schema_history" USING btree ("success");
--
--
-- DROP TABLE IF EXISTS "performer";
-- CREATE TABLE "public"."performer"
-- (
--     "id"     bigint  NOT NULL,
--     "age"    integer NOT NULL,
--     "name"   character varying(255),
--     "rating" real    NOT NULL,
--     CONSTRAINT "performer_pkey" PRIMARY KEY ("id")
-- ) WITH (oids = false);
--
--
-- DROP TABLE IF EXISTS "review";
-- CREATE TABLE "public"."review"
-- (
--     "id"          bigint NOT NULL,
--     "review"      character varying(255),
--     "critique_id" bigint,
--     CONSTRAINT "review_pkey" PRIMARY KEY ("id")
-- ) WITH (oids = false);
--
--
-- DROP TABLE IF EXISTS "show";
-- CREATE TABLE "public"."show"
-- (
--     "show_type"             integer NOT NULL,
--     "id"                    bigint  NOT NULL,
--     "date"                  timestamp,
--     "duration"              integer NOT NULL,
--     "max_tickets"           integer NOT NULL,
--     "name"                  character varying(255),
--     "number_of_ratings"     integer NOT NULL,
--     "price"                 real    NOT NULL,
--     "rating"                real    NOT NULL,
--     "language"              bytea,
--     "translation_available" boolean,
--     "available_breaks"      boolean,
--     "break_duration"        integer,
--     "private_theatre"       boolean,
--     CONSTRAINT "show_pkey" PRIMARY KEY ("id")
-- ) WITH (oids = false);
--
--
-- DROP TABLE IF EXISTS "show_critiques_reviews";
-- CREATE TABLE "public"."show_critiques_reviews"
-- (
--     "show_id"              bigint NOT NULL,
--     "critiques_reviews_id" bigint NOT NULL,
--     CONSTRAINT "uk_q3w2d2vqubip5qc22yb62yb2v" UNIQUE ("critiques_reviews_id")
-- ) WITH (oids = false);
--
--
-- DROP TABLE IF EXISTS "shows_to_performers";
-- CREATE TABLE "public"."shows_to_performers"
-- (
--     "show_id"      bigint NOT NULL,
--     "performer_id" bigint NOT NULL
-- ) WITH (oids = false);
--
--
-- DROP TABLE IF EXISTS "user_to_address";
-- CREATE TABLE "public"."user_to_address"
-- (
--     "user_id"    bigint NOT NULL,
--     "address_id" bigint NOT NULL
-- ) WITH (oids = false);
--
--
-- DROP TABLE IF EXISTS "user_to_card";
-- CREATE TABLE "public"."user_to_card"
-- (
--     "card_id" bigint,
--     "user_id" bigint NOT NULL,
--     CONSTRAINT "user_to_card_pkey" PRIMARY KEY ("user_id")
-- ) WITH (oids = false);
--
--
-- DROP TABLE IF EXISTS "user_to_shows";
-- CREATE TABLE "public"."user_to_shows"
-- (
--     "user_id" bigint NOT NULL,
--     "show_id" bigint NOT NULL
-- ) WITH (oids = false);
--
--
-- ALTER TABLE ONLY "public"."show_critiques_reviews"
--     ADD CONSTRAINT "fk48ln2h1m55yih0ku7luai52qg" FOREIGN KEY (show_id) REFERENCES show (id) NOT DEFERRABLE;
-- ALTER TABLE ONLY "public"."show_critiques_reviews"
--     ADD CONSTRAINT "fkc0fgb1c62t53ytwnkio2k7y3" FOREIGN KEY (critiques_reviews_id) REFERENCES review (id) NOT DEFERRABLE;
--
-- ALTER TABLE ONLY "public"."shows_to_performers"
--     ADD CONSTRAINT "fkjmrtscsci2hwpnmm2kd6vu5qh" FOREIGN KEY (show_id) REFERENCES show (id) NOT DEFERRABLE;
-- ALTER TABLE ONLY "public"."shows_to_performers"
--     ADD CONSTRAINT "fkrrrqqphh1ynps4y0i7xs1qtml" FOREIGN KEY (performer_id) REFERENCES performer (id) NOT DEFERRABLE;
--
-- ALTER TABLE ONLY "public"."user_to_address"
--     ADD CONSTRAINT "fk3v11ttgnhtn1e1wcnxm4wwq9s" FOREIGN KEY (address_id) REFERENCES address (id) NOT DEFERRABLE;
--
-- ALTER TABLE ONLY "public"."user_to_card"
--     ADD CONSTRAINT "fkqpiv4pdox4vw3e5q9uvu2s2aw" FOREIGN KEY (card_id) REFERENCES credit_card (id) NOT DEFERRABLE;
--
-- ALTER TABLE ONLY "public"."user_to_shows"
--     ADD CONSTRAINT "fkn38lqauic43q2wsbwv6n64clj" FOREIGN KEY (show_id) REFERENCES show (id) NOT DEFERRABLE;
--
-- 2022-05-22 18:22:21.610279+00