
CREATE TABLE IF NOT EXISTS city(
    code                TEXT PRIMARY KEY,
    name                JSONB NOT NULL
);

CREATE TABLE IF NOT EXISTS client_type(
    code                TEXT PRIMARY KEY,
    name                JSONB NOT NULL
);

CREATE TABLE IF NOT EXISTS client(
    uuid                            UUID      PRIMARY KEY,
    active                          BOOLEAN NOT NULL,
    name                            TEXT NOT NULL,
    city_code                       TEXT NOT NULL REFERENCES city(code),
    client_type_code                TEXT NOT NULL REFERENCES client_type(code),
    phone_number                    TEXT NOT NULL,
    datetime_created                TIMESTAMP NOT NULL DEFAULT NOW(),
    datetime_updated                TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS payment_method(
    uuid                        UUID PRIMARY KEY,
    bank_account                TEXT NOT NULL,
    active                      BOOLEAN NOT NULL DEFAULT TRUE,
    datetime_created            TIMESTAMP NOT NULL DEFAULT NOW(),
    datetime_updated            TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS client_payment_link(
    client_uuid                 UUID NOT NULL REFERENCES client(uuid),
    payment_method_uuid         UUID NOT NULL REFERENCES payment_method(uuid),
    datetime_created            TIMESTAMP NOT NULL DEFAULT NOW(),
    datetime_updated            TIMESTAMP NOT NULL DEFAULT NOW()
);
