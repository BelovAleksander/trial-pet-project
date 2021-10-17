CREATE TABLE IF NOT EXISTS order_status(
    code                    TEXT PRIMARY KEY,
    name                    TEXT NOT NULL
);

INSERT INTO order_status(code, name) VALUES
('1', '{"rus": "создан"}'),
('2', '{"rus": "оплачен"}'),
('3', '{"rus": "доставляется"}'),
('4', '{"rus": "доставлен"}')
ON CONFLICT DO NOTHING;

CREATE TABLE IF NOT EXISTS client_order(
    uuid                    UUID PRIMARY KEY,
    product_uuid            UUID REFERENCES product(uuid),
    client_uuid             UUID REFERENCES client(uuid),
    order_datetime          TIMESTAMP NOT NULL DEFAULT NOW(),
    order_status            TEXT REFERENCES order_status(code),
    datetime_created        TIMESTAMP NOT NULL DEFAULT NOW(),
    datetime_updated        TIMESTAMP NOT NULL DEFAULT NOW()
);