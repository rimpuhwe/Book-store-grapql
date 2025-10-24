CREATE SEQUENCE IF NOT EXISTS author_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE author
(
    id    INTEGER      NOT NULL,
    name  VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    CONSTRAINT pk_author PRIMARY KEY (id)
);

CREATE TABLE books
(
    id         INTEGER      NOT NULL,
    book_name  VARCHAR(255) NOT NULL,
    author_id  INTEGER,
    page_count INTEGER      NOT NULL,
    CONSTRAINT pk_books PRIMARY KEY (id)
);

ALTER TABLE author
    ADD CONSTRAINT uc_author_email UNIQUE (email);

ALTER TABLE books
    ADD CONSTRAINT FK_BOOKS_ON_AUTHOR FOREIGN KEY (author_id) REFERENCES author (id);