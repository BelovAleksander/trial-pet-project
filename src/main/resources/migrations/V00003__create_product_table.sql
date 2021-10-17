CREATE TABLE IF NOT EXISTS product(
    uuid UUID                   PRIMARY KEY,
    active BOOLEAN              NOT NULL DEFAULT TRUE,
    price NUMERIC(19, 4)        NOT NULL,
    name TEXT                   NOT NULL,
    datetime_created            TIMESTAMP NOT NULL DEFAULT NOW(),
    datetime_updated            TIMESTAMP NOT NULL DEFAULT NOW()
);