DROP DATABASE IF EXISTS library;
CREATE DATABASE library;
use library;

CREATE TABLE publisher (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    isbn VARCHAR(255) UNIQUE,
    title VARCHAR(255) NOT NULL,
    synopsis TEXT,
    id_publisher INT,
    FOREIGN KEY (id_publisher) REFERENCES publisher(id)
);


/*CREATE TABLE copies (
    id INT PRIMARY KEY AUTO_INCREMENT,
    book_id INT,
    free BOOLEAN,
    FOREIGN KEY (book_id) REFERENCES books(id)
);*/

CREATE TABLE authors (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    nationality VARCHAR(255),
    birth_year INT,
    death_year INT
);

CREATE TABLE books_authors (
    id INT PRIMARY KEY AUTO_INCREMENT,
    book_id INT,
    author_id INT,
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (author_id) REFERENCES authors(id)
);

/*CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    admin BOOLEAN,

);

CREATE TABLE comments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    book_id INT,
    comment_text TEXT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (book_id) REFERENCES books(id)
);

CREATE TABLE user_comments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    comment_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (comment_id) REFERENCES comments(id)
);*/
