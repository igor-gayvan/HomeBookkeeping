/* SQL Manager for MySQL                              5.6.1.47667 */
/* -------------------------------------------------------------- */
/* Host     : 192.168.1.37                                        */
/* Port     : 3306                                                */
/* Database : home_bookkeeping                                    */


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES 'utf8' */;

SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `home_bookkeeping`;

CREATE DATABASE `home_bookkeeping`
    CHARACTER SET 'utf8'
    COLLATE 'utf8_general_ci';

USE `home_bookkeeping`;

/* Dropping database objects */

DROP TABLE IF EXISTS `doc`;

/* Structure for the `doc` table : */

CREATE TABLE `doc` (
  `doc_id` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `doc_amount` DECIMAL(11,2) NOT NULL,
  `doc_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `doc_note` VARCHAR(4000) COLLATE utf8_general_ci DEFAULT NULL,
  `is_income` TINYINT(1) NOT NULL DEFAULT 1,
  `date_rec` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY USING BTREE (`doc_id`)
) ENGINE=InnoDB
AUTO_INCREMENT=15 ROW_FORMAT=DYNAMIC CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
;

/* Data for the `doc` table  (LIMIT 0,500) */

INSERT INTO `doc` (`doc_id`, `doc_amount`, `doc_date`, `doc_note`, `is_income`, `date_rec`) VALUES
  (1,10000.00,'2016-10-02 22:31:37','Doc1',1,'2016-10-01 00:00:00'),
  (2,200.00,'2016-09-14 22:31:50','Doc2',0,'2016-10-02 00:00:00'),
  (3,500.00,'2016-10-02 22:32:05','Doc3',0,'2016-10-03 00:00:00'),
  (4,788.66,'2016-10-05 07:44:26','test',1,'2016-10-04 00:00:00'),
  (5,20000.00,'2016-10-05 07:53:40','doc20000',0,'2016-10-05 00:00:00'),
  (8,666666.00,'2016-10-06 08:30:48','test',1,'2016-10-06 00:00:00'),
  (9,10000.00,'2016-10-02 22:31:00','Doc1144444',1,'2016-10-07 00:58:13'),
  (10,44444.00,'2016-10-06 11:05:23','555555555555',0,'2016-10-07 00:58:20'),
  (11,11111111.00,'2016-10-02 22:00:00','Doc22',0,'2016-10-07 01:40:53'),
  (12,33333.00,'2016-10-02 22:00:00','33333',1,'2016-10-07 01:59:11'),
  (14,9999999.00,'2016-10-02 22:00:00','9999999999999',1,'2016-10-07 01:24:55');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;