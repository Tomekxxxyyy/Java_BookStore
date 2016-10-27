create database ksiazki DEFAULT CHARACTER SET utf8;

CREATE TABLE kategoria(
    id INT NOT NULL AUTO_INCREMENT,
    opis_kategorii VARCHAR(20) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE ksiazka(
    id INT NOT NULL AUTO_INCREMENT,
    id_kategorii INT NOT NULL,
    tytul_ksiazki VARCHAR(60) NOT NULL,
    wydawca VARCHAR(60) NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_ksiazka_1 FOREIGN KEY(id_kategorii) REFERENCES kategoria(id)
);

CREATE TABLE autor(
    id INT NOT NULL AUTO_INCREMENT,
    id_ksiazki INT NOT NULL,
    imie VARCHAR(20) NOT NULL,
    nazwisko VARCHAR(20) NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_autor_1 FOREIGN KEY(id_ksiazki) REFERENCES ksiazka(id)
);

INSERT INTO kategoria(opis_kategorii) VALUES('Clojure');
INSERT INTO kategoria(opis_kategorii) VALUES('Groovy');
INSERT INTO kategoria(opis_kategorii) VALUES('Java');
INSERT INTO kategoria(opis_kategorii) VALUES('Scala');

INSERT INTO ksiazka(id_kategorii, tytul_ksiazki, wydawca) VALUES(1, 'Practical Clojure', 'Apress');
INSERT INTO ksiazka(id_kategorii, tytul_ksiazki, wydawca) VALUES(2, 'Beginning Groovy', 'Apress');
INSERT INTO ksiazka(id_kategorii, tytul_ksiazki, wydawca) VALUES(2, 'Practical Clojure', 'Apress');
INSERT INTO ksiazka(id_kategorii, tytul_ksiazki, wydawca) VALUES(2, 'Groovy and Grails', 'Apress');
INSERT INTO ksiazka(id_kategorii, tytul_ksiazki, wydawca) VALUES(3, 'Modern Java Web Development', 'Apress');
INSERT INTO ksiazka(id_kategorii, tytul_ksiazki, wydawca) VALUES(3, 'Java 7 Recipes', 'Apress');
INSERT INTO ksiazka(id_kategorii, tytul_ksiazki, wydawca) VALUES(3, 'Java 7 EE Recipes', 'Apress');
INSERT INTO ksiazka(id_kategorii, tytul_ksiazki, wydawca) VALUES(3, 'Beginning Java 7', 'Apress');
INSERT INTO ksiazka(id_kategorii, tytul_ksiazki, wydawca) VALUES(3, 'Pro Java 7', 'Apress');
INSERT INTO ksiazka(id_kategorii, tytul_ksiazki, wydawca) VALUES(3, 'Java 7 for Absolute Beginners', 'Apress');
INSERT INTO ksiazka(id_kategorii, tytul_ksiazki, wydawca) VALUES(3, 'Oracle Certified Java Architect', 'Apress');
INSERT INTO ksiazka(id_kategorii, tytul_ksiazki, wydawca) VALUES(4, 'Beginning Scala', 'Apress');

INSERT INTO autor(id_ksiazki, imie, nazwisko) VALUES(1, 'Luke', 'VanderHart');
INSERT INTO autor(id_ksiazki, imie, nazwisko) VALUES(2, 'Vishal', 'Layka');
INSERT INTO autor(id_ksiazki, imie, nazwisko) VALUES(3, 'Jeff', 'Brown');
INSERT INTO autor(id_ksiazki, imie, nazwisko) VALUES(4, 'Bashar', 'Jawad');
INSERT INTO autor(id_ksiazki, imie, nazwisko) VALUES(5, 'Vishal', 'Layka');
INSERT INTO autor(id_ksiazki, imie, nazwisko) VALUES(6, 'Josh', 'Juneau');
INSERT INTO autor(id_ksiazki, imie, nazwisko) VALUES(7, 'Josh', 'Juneau');
INSERT INTO autor(id_ksiazki, imie, nazwisko) VALUES(8, 'Jeff', 'Friesen');
INSERT INTO autor(id_ksiazki, imie, nazwisko) VALUES(9, 'Anghel', 'Leonard');
INSERT INTO autor(id_ksiazki, imie, nazwisko) VALUES(10, 'Jay', 'Bryant');
INSERT INTO autor(id_ksiazki, imie, nazwisko) VALUES(11, 'B V', 'Kumar');
INSERT INTO autor(id_ksiazki, imie, nazwisko) VALUES(12, 'David', 'Pollak');