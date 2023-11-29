use library;

DELETE FROM books_authors;
ALTER TABLE books_authors AUTO_INCREMENT = 1;
DELETE FROM books;
ALTER TABLE books AUTO_INCREMENT = 1;
DELETE FROM publisher;
ALTER TABLE publisher AUTO_INCREMENT = 1;
DELETE FROM authors;
ALTER TABLE authors AUTO_INCREMENT = 1;

-- Editoriales
INSERT INTO publisher (name) VALUES
    ('Aleta Ediciones'),
    ('Editorial Lumen'),
    ('Tusquets Editores S.A.'),
    ('Norma Editorial, S.A.'),
    ('Debolsillo'),
    ('Editorial Anagrama S.A.'),
    ('Bibliopolis'),
    ('Roca Editorial');

-- Autores
INSERT INTO authors (name, nationality, birth_year, death_year) VALUES
    ('John Kennedy Toole', 'Estadounidense', 1937, 1969),
    ('Umberto Eco', 'Italiano', 1932, 2016),
    ('Milan Kundera', 'Checo', 1929, NULL),
    ('Terry Pratchett', 'Británico', 1948, 2015),
    ('Neil Gaiman', 'Británico', 1960, NULL),
    ('Douglas Adams', 'Británico', 1952, 2001),
    ('Andrzej Sapkowski', 'Polaco', 1948, NULL);

-- La conjura de los necios
INSERT INTO books (isbn, title, synopsis, id_publisher) VALUES ('978-84-96587-40-3', 'La conjura de los necios', 'La historia cómica y trágica de Ignatius J. Reilly, un personaje estrafalario y lleno de excentricidades.', 1);
INSERT INTO books_authors (book_id, author_id) VALUES (1, 1);

-- El nombre de la rosa
INSERT INTO books (isbn, title, synopsis, id_publisher) VALUES ('978-84-264-1158-7', 'El nombre de la rosa', 'El nombre de la rosa es una novela histórica escrita por Umberto Eco, ambientada en una abadía benedictina en el siglo XIV.', 2);
INSERT INTO books_authors (book_id, author_id) VALUES (2, 2);

-- La insoportable levedad del ser
INSERT INTO books (isbn, title, synopsis, id_publisher) VALUES ('978-84-7223-000-8', 'La insoportable levedad del ser', 'La insoportable levedad del ser es una novela escrita por Milan Kundera, que explora las complejidades de las relaciones humanas y la búsqueda de sentido en la vida.', 3);
INSERT INTO books_authors (book_id, author_id) VALUES (3, 3);

-- La isla del día de antes
INSERT INTO books (isbn, title, synopsis, id_publisher) VALUES ('978-84-473-1603-8', 'La isla del día de antes', 'La isla del día de antes es una novela escrita por Umberto Eco que combina historia, filosofía y misterio en una narrativa cautivadora.', 1);
INSERT INTO books_authors (book_id, author_id) VALUES (4, 1);

-- Buenos presagios
INSERT INTO books (isbn, title, synopsis, id_publisher) VALUES ('978-84-7904-877-8', 'Buenos presagios', 'Buenos presagios es una novela escrita por Terry Pratchett y Neil Gaiman que combina humor y fantasía en una historia sobre el fin del mundo.', 5);
INSERT INTO books_authors (book_id, author_id) VALUES (5, 5),
                                                      (5, 6);

-- El país del fin del mundo
INSERT INTO books (isbn, title, synopsis, id_publisher) VALUES ('978-84-8450-429-0', 'El país del fin del mundo', 'El país del fin del mundo es una novela escrita por Terry Pratchett que combina humor y fantasía en una historia llena de personajes peculiares y situaciones cómicas.', 6);
INSERT INTO books_authors (book_id, author_id) VALUES (6, 5);

-- Mort
INSERT INTO books (isbn, title, synopsis, id_publisher) VALUES ('978-84-9992-414-8', 'Mort', 'Mort es una novela escrita por Terry Pratchett que forma parte de la serie Mundodisco. La historia sigue a Mort, un aprendiz de la Muerte, en sus aventuras por el reino de la muerte.', 6);
INSERT INTO books_authors (book_id, author_id) VALUES (7, 5);

-- Guía del autoestopista galáctico
INSERT INTO books (isbn, title, synopsis, id_publisher) VALUES ('978-84-339-7289-1', 'Guía del autoestopista galáctico', 'Guía del autoestopista galáctico es una novela de ciencia ficción escrita por Douglas Adams. Sigue las aventuras de Arthur Dent, un humano que se embarca en un viaje por el espacio.', 7);
INSERT INTO books_authors (book_id, author_id) VALUES (8, 6);

-- Libros de Neil Gaiman
INSERT INTO books (isbn, title, synopsis, id_publisher) VALUES ('978-84-7904-970-6', 'Neverwhere', 'Neverwhere es una novela de Neil Gaiman que sigue las aventuras de Richard Mayhew en un mundo subterráneo de Londres llamado "London Below".', 4);
INSERT INTO books_authors (book_id, author_id) VALUES (9, 5);
INSERT INTO books (isbn, title, synopsis, id_publisher) VALUES ('978-84-8431-627-5', 'American Gods', 'American Gods es una novela de Neil Gaiman que mezcla mitología y realidad en una historia sobre dioses antiguos y nuevos.', 4);
INSERT INTO books_authors (book_id, author_id) VALUES (10, 5);
INSERT INTO books (isbn, title, synopsis, id_publisher) VALUES ('978-84-9918-772-3', 'El libro del cementerio', 'El libro del cementerio es una novela de Neil Gaiman que sigue la vida de Nobody Owens, un niño que crece en un cementerio.', 8);
INSERT INTO books_authors (book_id, author_id) VALUES (11, 5);

-- Libros de Andrzej Sapkowski
INSERT INTO books (isbn, title, synopsis, id_publisher)
VALUES
    ('978-84-932836-1-2', 'El último deseo', 'El último deseo es el primer libro de la saga de Geralt de Rivia, un brujo solitario que se dedica a cazar monstruos en un mundo lleno de peligros y criaturas sobrenaturales.', 7),
    ('978-84-932836-6-7', 'La espada del destino', 'En La espada del destino, Geralt de Rivia se enfrenta a nuevos desafíos y se ve envuelto en intrigas y batallas mientras lucha por encontrar su lugar en un mundo turbulento.', 7),
    ('978-84-96173-00-2', 'La sangre de los elfos', 'La sangre de los elfos sigue la historia de Ciri, una joven con poderes mágicos, mientras Geralt de Rivia se convierte en su protector y la ayuda a enfrentar su destino.', 7),
    ('978-84-96173-10-1', 'Tiempo de odio', 'En Tiempo de odio, Geralt de Rivia se encuentra en medio de una guerra entre reinos y debe tomar decisiones difíciles mientras lucha por proteger a aquellos a quienes ama.', 7),
    ('978-84-96173-15-6', 'Bautismo de fuego', 'Bautismo de fuego continúa la saga de Geralt de Rivia, quien se une a un grupo de guerreros en una peligrosa misión para salvar a Ciri y detener el avance de la guerra.', 7),
    ('978-84-96173-58-3', 'La torre de la golondrina', 'La torre de la golondrina es un libro lleno de magia y misterio, donde Geralt de Rivia debe enfrentar su pasado y descubrir el verdadero poder de Ciri.', 7),
    ('978-84-96173-93-4', 'La dama del lago', 'En La dama del lago, Geralt de Rivia se enfrenta a su mayor desafío mientras se acerca al final de su camino y descubre la verdad sobre el destino de Ciri.', 7);

-- INSERT en la tabla books_authors
INSERT INTO books_authors (book_id, author_id)
VALUES
    (12, 7),
    (13, 7),
    (14, 7),
    (15, 7),
    (16, 7),
    (17, 7),
    (18, 7);