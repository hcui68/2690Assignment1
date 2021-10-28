CREATE SCHEMA csci2690_schema AUTHORIZATION test;

DROP TABLE IF EXISTS csci2690_schema.test_table;

CREATE TABLE csci2690_schema.test_table
    (
        country varchar,
        city varchar,
        latitude numeric,
        longitude numeric
);