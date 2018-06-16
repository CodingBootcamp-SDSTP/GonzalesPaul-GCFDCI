DROP DATABASE IF EXISTS gcfdcidb;
CREATE DATABASE IF NOT EXISTS gcfdcidb;
USE gcfdcidb;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

--Table structure for admin--

CREATE TABLE table_admin (
	id INT(20) NOT NULL PRIMARY KEY,
	name VARCHAR(45) NOT NULL,
	email VARCHAR(45) NOT NULL,
	username VARCHAR(45) NOT NULL,
	password VARCHAR(45) NOT NULL,
	file VARCHAR(567) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO admin (id, name, email, username, password, file) VALUES
(1, 'Paul', 'paulfrontrow77@gmail.com', 'admin', 'admin123', ''),

--Table structure for event--
CREATE TABLE events (
	id INT(11) NOT NULL,
	title VARCHAR(60) NOT NULL,
	detail VARCHAR(500) NOT NULL,
	date VARCHAR(60) NOT NULL,
	time VARCHAR(30) NOT NULL,
	venue VARCHAR(120) NOT NULL,
	phone VARCHAR(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO events (id, title, detail, date, time, venue, phone) VALUES
(1, 'NATIONAL CONVENTION, 2018', '', 'FRIDAY 14 - THURSDAY 17 AUGUST', '', '', '');

--Table structure for gallery--

CREATE TABLE gallery (
	id INT(11) NOT NULL,
	caption VARCHAR(225) NOT NULL,
	file VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO gallery (id, caption, file) VALUES
(1, 'With the bishop', '1_2.png'),
(2, 'I was there that day', 'efac69c.jpg'),

--Table structure for news--

CREATE TABLE news (
	id INT(70) NOT NULL,
	news_title VARCHAR(200) NOT NULL,
	news_detail VARCHAR(5000) NOT NULL,
	file VARCHAR(150) NOT NULL,
	date date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO news (id, news_title, news_detail, file, date) VALUES
(1, 'I Love Lagos', 'Here is the matter with us', 'efac_e.png', '2017-07-26'),

--Table structure for quote--

CREATE TABLE quote (
	id INT(11) NOT NULL,
	quote VARCHAR(300) NOT NULL,
	quote_by VARCHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO quote (id, quote, quote_by) VALUES
(1, 'For God did not send his Son INTo the world to condemn the world, but to save the world through him.', ' John 3:17');

--Table structure for about--

CREATE TABLE about (
	id INT(11) NOT NULL,
	body VARCHAR(2500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO about (id, body) VALUES
(4, 'Save about us');

--Table structure for history--

CREATE TABLE history (
	id INT(11) NOT NULL,
	body VARCHAR(2500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO history (id, body) VALUES
(4, 'GCFI History');

--Table structure for sunday schedules--

CREATE TABLE sunday_service (
	id INT(11) NOT NULL,
	body VARCHAR(2500) NOT NULL,
	time INT(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO sunday_service (id, body, time) VALUES (1, 'First Service', 7:00-90:30);
INSERT INTO sunday_service (id, body, time) VALUES (2, 'Second Service', 8:30-10:30);
INSERT INTO sunday_service (id, body, time) VALUES (3, 'Third Service', 10:00-12:30);
INSERT INTO sunday_service (id, body, time) VALUES (3, 'Third Service', 6:00-8:30);

--Table structure for contacts--

CREATE TABLE contacts (
	id int(11) NOT NULL,
	telephone INT(12) NOT NULL,
	cellphone INT(12) NOT NULL,
	email VARCHAR(2500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO contacts (id, telephone, cellphone, email) VALUES (1, 123456, 09223654, 'gcfdagupan@gmail.com');
