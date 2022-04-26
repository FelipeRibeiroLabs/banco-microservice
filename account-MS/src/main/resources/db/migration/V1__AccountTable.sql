CREATE SEQUENCE SEQ_ACCOUNT INCREMENT 2 MINVALUE 3 MAXVALUE 9999999999;

DROP TABLE IF EXISTS account;

CREATE TABLE IF NOT EXISTS account(
    account_id INTEGER DEFAULT NEXTVAL('SEQ_ACCOUNT') PRIMARY KEY NOT NULL,
    account_number INT UNIQUE NOT NULL,
    agency INT NOT NULL,
    account_type VARCHAR(10) UNIQUE NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    balance FLOAT NOT NULL,
    created TIMESTAMP NOT NULL
);