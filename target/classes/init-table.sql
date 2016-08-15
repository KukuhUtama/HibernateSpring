CREATE TABLE customer (
id INT(10) NOT NULL AUTO_INCREMENT,
first_name VARCHAR(20),
last_name VARCHAR(20),
address VARCHAR(30),
contact_number VARCHAR(20),
created_by varchar(255),
created_time DATETIME,
PRIMARY KEY(id)
) ENGINE=INNODB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


CREATE TABLE bank_account(
id INT(10) NOT NULL AUTO_INCREMENT,
account_number VARCHAR(20),
amount int(10),
cutomer_id INT(10),
created_by varchar(255),
created_time DATETIME,
PRIMARY KEY(id)
 ) ENGINE=INNODB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;