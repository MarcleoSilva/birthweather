CREATE TABLE birthweather
(
    id         UUID             NOT NULL,
    name       VARCHAR(255),
    latitude   DOUBLE PRECISION NOT NULL,
    longitude  DOUBLE PRECISION NOT NULL,
    start_data TIMESTAMP WITHOUT TIME ZONE,
    city       VARCHAR(255),
    country    VARCHAR(255),
    CONSTRAINT pk_birthweather PRIMARY KEY (id)
);