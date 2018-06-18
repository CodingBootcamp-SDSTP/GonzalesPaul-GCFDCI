DROP DATABASE IF EXISTS data_gcfi;
CREATE DATABASE IF NOT EXISTS data_gcfi;
USE data_gcfi;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE admin_access (
	id INT(20) NOT NULL PRIMARY KEY,
	name VARCHAR(45) NOT NULL,
	email VARCHAR(45) NOT NULL,
	username VARCHAR(45) NOT NULL,
	password VARCHAR(45) NOT NULL,
	file VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO admin_access (id, name, email, username, password, file) VALUES
(1, 'Paul', 'paulfrontrow77@gmail.com', 'admin', 'admin123', '');


CREATE TABLE about (
	id INT(12) NOT NULL,
	gcf_mvs VARCHAR(255) NOT NULL,
	body VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO about (id, gcf_mvs, body) VALUES (1, 'gcf Mission Vission Statement', 'Save about us');
INSERT INTO about (id, gcf_mvs, body) VALUES (2, 'i. GCF Church Purpose', 'GCF Church exists to live out the Great Commandment and fulfil the Great Commission');
INSERT INTO about (id, gcf_mvs, body) VALUES (3, 'ii. GCF Vision', 'Love the Lord Jesus; be like Him and Disciple people to become like Him');
INSERT INTO about (id, gcf_mvs, body) VALUES (4, 'Articulated Vision: ', 'As a Disciple-Making Cell Church, we are committed to, - Love God passionately - Grow I Christ-likeness - Grow together as a loving family - Become a disciple-making people in Outreach & Missions');
INSERT INTO about (id, gcf_mvs, body) VALUES (5, 'Vision Statement:', '- We trust God to build GCF Church to be: 
A Disciple-making Cell Church that produces Christ-like worshippers and soul winners to accomplish the Mission God has for us.');
INSERT INTO about (id, gcf_mvs, body) VALUES (6, 'iii. GCF Mission:', '1. GCF, as a Disciple-making Cell Church, is committed to: a. Transforming lives by Evangelism and Discipleship b. Influencing the Community by advocating the family c. Blessing the nations by establishing local churches 2. In short, "Transform Lives, Influence the Community, bless the nations".');
INSERT INTO about (id, gcf_mvs, body) VALUES (7, 'iv. The Process: 4B Strategy', '1. BLESS GOD- Worship God, Live a Holy Life, Give Generously. 2. BRING IN- Reach Out pre-believers, assimilate them into the church. 3. BUILD UP- Grow them in the Cell, have them empowered by the Holy Spirit, disciple them. 4. BRANCH OUT- Send them to evangelize and disciple others, influence the community and bless the nations.');
INSERT INTO about (id, gcf_mvs, body) VALUES (8, 'b. Clarify our Mission: i. What are we looking for?', '- We are not after growing our church. We are after people who need the Lord. A Church that reaches out to people and disciple them is a Healthy Church. Church Growth is a natural result.');
INSERT INTO about (id, gcf_mvs, body) VALUES (9, 'ii. What is a Cell Church?
- We are not a Church with Cells', 'o Cells are one of the programs. Participation is not compulsory [only 20-30% are in Cells], - We are Church of Cells, o GCF is a Church of Cells. As a Cell Church, Cell is the primary platform we shepherd and disciple our people');
INSERT INTO about (id, gcf_mvs, body) VALUES (10, 'c. Our Core Values determine the kind of church we become', 'i. Cell Leaders must embrace, teach, and model these core values. ii. Core values are beliefs that drive our lives and ministries. iii. With our Core values, we exert great influence in the way we do things in our church. iv. These values drives our decisions, determines our risk level, resolve our conflict, establish our priorities, etc. v. All of these Core Values are equally important');
INSERT INTO about (id, gcf_mvs, body) VALUES (11, 'VI. GCF Five Core Values', 'a. Dependence on God. b. Living in Community. c. Transformation in People. d. Building family .e. Excellence for God');
INSERT INTO about (id, gcf_mvs, body) VALUES (12, 'VII. GCF Three Character Values', 'a. Authentic- we are desirous to be TRUE Christians. b. Intentional- we are decisive in our PURPOSE. c. Missional- we are dead to self and SERVANT to others');


CREATE TABLE history (
	id INT(11) NOT NULL,
	date VARCHAR(100) NOT NULL,
	body VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO history (id, date, body) VALUES (1, 'September 1996', 'GCFI History');


CREATE TABLE services (
	id INT(11) NOT NULL,
	body VARCHAR(255) NOT NULL,
	length_time VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO services (id, body, length_time) VALUES (1, 'First Service', '7:00-90:30');
INSERT INTO services (id, body, length_time) VALUES (2, 'Second Service', '8:30-10:30');
INSERT INTO services (id, body, length_time) VALUES (3, 'Third Service', '10:00-12:30');
INSERT INTO services (id, body, length_time) VALUES (4, 'Third Service', '6:00-8:30');


CREATE TABLE life_verse (
	id INT(12) NOT NULL,
	verse VARCHAR(255) NOT NULL,
	chapter VARCHAR(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO life_verse (id, verse, chapter) VALUES
(1, '16 For I am not ashamed of the gospel of Christ: for it is the power of God unto salvation to every one that believeth; to the Jew first, and also to the Greek.', 'Romans 1:16');


CREATE TABLE gallery (
	id INT(11) NOT NULL,
	caption VARCHAR(225) NOT NULL,
	file VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO gallery (id, caption, file) VALUES
(1, 'With the bishop', '1_2.png'),
(2, 'I was there that day', 'efa_c69c.jpg');


CREATE TABLE sermons (
	id INT(70) NOT NULL AUTO_INCREMENT,
	title VARCHAR(150) NOT NULL,
	file VARCHAR(150) NOT NULL,
	date INT(12) NOT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO sermons (title, file, date) VALUES
('sermon', 'efac_e.png', '2017:07:26');


CREATE TABLE contact (
	id int(12) NOT NULL,
	telephone INT(12) NOT NULL,
	cell_number INT(12) NOT NULL,
	email VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO contact (id, telephone, cell_number, email) VALUES (1, 123456, 09223654, 'gcfdagupan@gmail.com');

CREATE TABLE announcements (
	id INT(70) NOT NULL,
	title VARCHAR(200) NOT NULL,
	detail VARCHAR(5000) NOT NULL,
	file VARCHAR(150) NOT NULL,
	date VARCHAR(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO announcements (id, title, detail, file, date) VALUES
(1, 'I Love Lagos', 'Here is the matter with us', 'efac_e.png', '2017-07-26');

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
(1, 'NATIONAL CONVENTION 2018', 'sdfasddadqweqwe', '00:00:00', '00:00:00', '', '');
