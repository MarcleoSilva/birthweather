CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE birthweather (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,

    name VARCHAR(200) NOT NULL,
    date VARCHAR(200) NOT NULL,
    city VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL,

    latitude VARCHAR(200) NOT NULL,
    longitude VARCHAR(200) NOT NULL,
    rain REAL,
    precipitation REAL,
    cloud INTEGER,
    humidity INTEGER,
    temperature REAL
);