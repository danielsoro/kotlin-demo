CREATE TABLE authors (
      id uuid,
      name VARCHAR NOT NULL,
      PRIMARY KEY (id)
);

ALTER TABLE authors ADD CONSTRAINT author_name_uk UNIQUE (name);
CREATE INDEX idx_author_name ON authors(name);

CREATE TABLE books (
      id uuid,
      name VARCHAR NOT NULL,
      author_id uuid NOT NULL,
      PRIMARY KEY (id)
);

ALTER TABLE books ADD CONSTRAINT book_author_fk FOREIGN KEY (author_id) REFERENCES authors(id);
ALTER TABLE books ADD CONSTRAINT book_name_uk UNIQUE (name);
CREATE INDEX idx_book_name ON books(name);
