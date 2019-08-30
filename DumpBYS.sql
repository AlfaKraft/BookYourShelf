-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bys_db
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `author_book`
--

DROP TABLE IF EXISTS `author_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `author_book` (
  `idAuthor` int(11) NOT NULL,
  `idBook` int(11) NOT NULL,
  UNIQUE KEY `UK_og9nccartktqykcku20xl1jrm` (`idAuthor`),
  KEY `FK_AUTHOR_BOOK_idx` (`idBook`),
  KEY `FK_autor_idx` (`idAuthor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author_book`
--

LOCK TABLES `author_book` WRITE;
/*!40000 ALTER TABLE `author_book` DISABLE KEYS */;
INSERT INTO `author_book` VALUES (1,1),(2,2),(3,3),(4,5),(5,35),(6,35),(9,37),(10,37),(15,40),(16,40),(17,41),(18,41),(19,42),(20,42),(27,46),(28,46),(29,47),(30,47),(31,48),(32,48),(33,49),(34,49),(37,51),(38,51),(41,53),(42,53),(49,57),(50,57),(71,68),(72,68),(73,69),(74,69),(75,70),(76,70),(81,73),(82,73),(109,89),(110,89),(127,104),(128,104),(159,120),(160,120),(163,122),(164,122);
/*!40000 ALTER TABLE `author_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authors`
--

DROP TABLE IF EXISTS `authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authorName` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=165 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authors`
--

LOCK TABLES `authors` WRITE;
/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
INSERT INTO `authors` VALUES (1,''),(3,''),(4,''),(5,'Jaak Tamm'),(6,'Teine autor'),(9,'Sina'),(10,'Mina'),(15,'Robert Pawson'),(16,'Richard Pawson'),(17,'Rob Harrop'),(18,'Jan Machachek'),(19,''),(20,'J.K. Rowling'),(29,'Jan Machachek'),(30,'Rob Harrop'),(31,'Jan Machachek'),(32,'Rob Harrop'),(33,'A2'),(34,'A1'),(37,'J.K Rowling'),(38,''),(71,''),(72,''),(73,''),(74,''),(75,''),(76,''),(81,'Karel'),(82,'Allan'),(109,'J. Oliver'),(110,''),(127,'Bert Bates'),(128,'Kathy Sierra'),(159,''),(160,'Thomas More'),(163,'Mike Keith'),(164,'');
/*!40000 ALTER TABLE `authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(150) NOT NULL,
  `ISBNcode` bigint(14) DEFAULT NULL,
  `genre` varchar(30) NOT NULL,
  `language` varchar(30) NOT NULL,
  `year` int(11) NOT NULL,
  `cover` varchar(100) DEFAULT NULL,
  `idComment` int(11) DEFAULT NULL,
  `likeCount` int(11) DEFAULT NULL,
  `dislikeCount` int(11) DEFAULT NULL,
  `status` tinyint(4) DEFAULT '1',
  `barcode` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `barcode_UNIQUE` (`barcode`),
  KEY `FK_BOOK_COMMENT_idx` (`idComment`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (5,'Java Programming for Beginners: Learn the fundamentals of programming with Java',9781788296298,'Java','EN',2017,'Java_programming.jpg',NULL,NULL,NULL,0,NULL),(7,'Sport',9772382818016,'Magazin','EST',2016,'Sport.jpg',NULL,NULL,NULL,0,NULL),(40,'Naked objects',9780470844205,'Educational','EN',2002,'Naked_objects.jpg',NULL,NULL,NULL,1,NULL),(41,'Pro Spring',9781590594612,'Java','EN',2005,'Pro_Spring.jpg',NULL,NULL,NULL,1,NULL),(42,'Harry Potter',875858558,'Fiction','EN',1997,'Harry_Potter.jpg',NULL,NULL,NULL,0,NULL),(89,'5 ingredients : quick & easy food',9789949620302,'Food','EN',2017,'jamiefood.jpg',NULL,NULL,NULL,0,NULL),(104,'Head First Java',55698742563,'Java','English',2003,NULL,NULL,NULL,NULL,1,NULL),(120,'Utoopia',9789949565030,'Fiction','Estonian',2015,'utoopia.jpg',NULL,NULL,NULL,1,NULL),(122,'Pro JPA 2 ',9781430219569,'Programming','English',1957,'jpa.jpg',NULL,NULL,NULL,1,NULL);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrows`
--

DROP TABLE IF EXISTS `borrows`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `borrows` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) NOT NULL,
  `idBook` int(11) NOT NULL,
  `dateTaken` datetime(6) NOT NULL,
  `dateToBring` datetime(6) DEFAULT NULL,
  `dateBrought` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  KEY `FK_USER_BORROW_idx` (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=189 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrows`
--

LOCK TABLES `borrows` WRITE;
/*!40000 ALTER TABLE `borrows` DISABLE KEYS */;
INSERT INTO `borrows` VALUES (144,10,7,'2019-08-23 00:00:00.000000',NULL,'2019-08-23 00:00:00.000000'),(145,10,5,'2019-08-23 00:00:00.000000',NULL,'2019-08-27 00:00:00.000000'),(146,10,41,'2019-08-23 00:00:00.000000',NULL,'2019-08-23 00:00:00.000000'),(147,10,7,'2019-08-26 00:00:00.000000',NULL,'2019-08-26 00:00:00.000000'),(148,13,42,'2019-08-27 00:00:00.000000',NULL,'2019-08-27 00:00:00.000000'),(150,13,5,'2019-08-27 00:00:00.000000',NULL,'2019-08-27 00:00:00.000000'),(151,13,40,'2019-08-27 00:00:00.000000',NULL,'2019-08-27 00:00:00.000000'),(155,13,7,'2019-08-27 00:00:00.000000',NULL,'2019-08-27 00:00:00.000000'),(157,13,7,'2019-08-27 00:00:00.000000',NULL,'2019-08-27 00:00:00.000000'),(160,13,7,'2019-08-27 00:00:00.000000',NULL,'2019-08-27 00:00:00.000000'),(165,13,41,'2019-08-27 00:00:00.000000',NULL,'2019-08-27 00:00:00.000000'),(166,10,7,'2019-08-27 00:00:00.000000',NULL,'2019-08-27 00:00:00.000000'),(168,10,40,'2019-08-10 00:00:00.000000',NULL,'2019-08-28 00:00:00.000000'),(169,10,5,'2019-08-27 00:00:00.000000',NULL,'2019-08-27 00:00:00.000000'),(170,10,5,'2019-08-27 00:00:00.000000','2019-09-10 00:00:00.000000',NULL),(173,46,42,'2019-08-10 00:00:00.000000','2019-09-01 00:00:00.000000',NULL),(180,46,7,'2019-08-29 00:00:00.000000',NULL,'2019-08-29 00:00:00.000000'),(181,46,89,'2019-08-29 00:00:00.000000','2019-08-12 00:00:00.000000',NULL),(187,60,7,'2019-08-30 00:00:00.000000','2019-09-13 00:00:00.000000',NULL),(188,60,40,'2019-08-30 00:00:00.000000',NULL,'2019-08-30 00:00:00.000000');
/*!40000 ALTER TABLE `borrows` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `id` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `comment` varchar(300) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `FK_USER_COMMENT_idx` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `picture` varchar(45) DEFAULT NULL,
  `email` varchar(60) NOT NULL,
  `password` varchar(90) NOT NULL,
  `role` varchar(20) NOT NULL DEFAULT 'USER',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (10,'Kalle','Kalevipoeg','','kk@tieto.com','$2a$10$ZOY8yxNYkfIxyOyAbl/Yw.ni4.IIOLbV0Jscvd5bOyrEycBf397E6','USER'),(11,'Villu','Vares','','vv@tieto.com','$2a$10$PoYitEh/WU1mNL9uO90kl.yOb.v48Y8hbl93S1oc1ZfbfekzflVcu','ADMIN'),(13,'Helmi','Hell',NULL,'helmi@tieto.com','$2a$10$z2h3gRU0IjqGJCgVBqOMke6Vd9OLI.qK0rTIxhFBPLfmMgNqPdAg.','USER'),(14,'Kalev','Poeg','','kalev@tieto.com','$2a$10$0yhDJb6sWzHiXcpRCJvTl.YF2u3lTA7PttKJ7S4QuztMt52JxCy9O','USER'),(46,'Risto','Põldsalu',NULL,'risto.poldsalu@tieto.com','$2a$10$ecY0SyKz5lfTA9nx2wiM6unnckzsApfCVOZH4KgdKoHqUCZc99Hnm','USER'),(48,'Malle','Maasikas',NULL,'malle.maasika@tieto.com','$2a$10$xT585gcCefbk1mQP.LSvMedCfZ9Dy6wsQ7FzuevgcFGR2Ci8sz1aK','USER'),(51,'Allan','Sipovski','teet@tieto.com.jpg','teet@tieto.com','$2a$10$PFuduhXp9qoIKA.YgqLUZe4tiHcEOCnjkVpWi4tt5L6quvHyoTGWG','ADMIN'),(52,'Jaak','Tamm','jaak@tieto.com.jpg','jaak@tieto.com','$2a$10$Ge1bnr7pmnXfTcPQsSI6t.VwY0hoo7bj56YjvX4O//FFQZ5WgECBe','USER'),(56,'Allan','Mihkelson','allan.mihkelson@tieto.com.jpg','allan.mihkelson@tieto.com','$2a$10$pBRy5HQJckJxJHpogVcP7.SoJnfOTNPzRESCAKWvGwpUxbDxz7awy','USER'),(60,'Saskia ','Sonnberg','saskia.sonnberg@tieto.com.jpg','saskia.sonnberg@tieto.com','$2a$10$9R8kX3XpKTG99brJHBdsFOIxPZrzRroEKqVnPTDrVhCd7DQHnKfAO','USER');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'bys_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-30 13:25:03
