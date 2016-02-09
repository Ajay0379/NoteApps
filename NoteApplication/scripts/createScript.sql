use notes_db;
CREATE TABLE `User` (
  `User_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Email` varchar(50) NOT NULL UNIQUE,
  `Password` varchar(50) DEFAULT NULL,
   Create_Time Date,
   Last_Update_Time Date,
  PRIMARY KEY (`User_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
 
CREATE TABLE `Notes` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `User_id` int(11) unsigned NOT NULL,
  `Title` varchar(30) NOT NULL,
   Note_Description varchar(50),
  Create_Time Date,
  Last_Update_Time Date,
  PRIMARY KEY (`id`),
  KEY `User_id` (`User_id`),
  CONSTRAINT `notes_ibfk_1` FOREIGN KEY (`User_id`) REFERENCES `User` (`User_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;