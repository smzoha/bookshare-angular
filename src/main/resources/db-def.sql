CREATE TABLE author
(
    id         INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    birth_date DATE,
    death_date DATE,
    biography  VARCHAR(2000)
);

CREATE TABLE publisher
(
    id      INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(100) NOT NULL,
    country VARCHAR(50)
);

CREATE TABLE book
(
    id           INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title        VARCHAR(100) NOT NULL,
    description  VARCHAR(2000),
    page_number  INT,
    publish_date DATE,
    publisher_id INT,
    CONSTRAINT fk_publisher FOREIGN KEY (publisher_id) REFERENCES publisher (id)
);

CREATE TABLE book_author
(
    book_id   INT NOT NULL,
    author_id INT NOT NULL,
    PRIMARY KEY (book_id, author_id),
    CONSTRAINT fk_book_author_book FOREIGN KEY (book_id) REFERENCES book (id),
    CONSTRAINT fk_book_author_author FOREIGN KEY (author_id) REFERENCES author (id)
);

CREATE TABLE book_tags
(
    book_id INT         NOT NULL,
    tag     VARCHAR(20) NOT NULL,
    PRIMARY KEY (book_id, tag),
    CONSTRAINT fk_book_tags FOREIGN KEY (book_id) REFERENCES book (id)
);
