-- MySQL dump 10.13  Distrib 8.0.27, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: Gitforum
-- ------------------------------------------------------
-- Server version	8.0.27-0ubuntu0.20.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `contents` varchar(100) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` int NOT NULL DEFAULT '0',
  `approve` int NOT NULL DEFAULT '0',
  `responseNumber` int NOT NULL DEFAULT '0',
  `post_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forum`
--

DROP TABLE IF EXISTS `forum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `forum` (
  `C1` text,
  `C2` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forum`
--

LOCK TABLES `forum` WRITE;
/*!40000 ALTER TABLE `forum` DISABLE KEYS */;
INSERT INTO `forum` VALUES ('-- MySQL dump 10.13  Distrib 8.0.27',' for Linux (x86_64)'),('/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS',' UNIQUE_CHECKS=0 */;'),('/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS',' FOREIGN_KEY_CHECKS=0 */;'),('/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE',' SQL_MODE=\'NO_AUTO_VALUE_ON_ZERO\' */;'),('/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES',' SQL_NOTES=0 */;'),('  `id` int NOT NULL AUTO_INCREMENT',NULL),('  `contents` varchar(100) NOT NULL',NULL),('  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP',NULL),('  `status` int NOT NULL DEFAULT \'0\'',NULL),('  `approve` int NOT NULL DEFAULT \'0\'',NULL),('  `responseNumber` int NOT NULL DEFAULT \'0\'',NULL),('  `post_id` int DEFAULT NULL',NULL),('  `user_id` int DEFAULT NULL',NULL),('  `id` int NOT NULL AUTO_INCREMENT',NULL),('  `title` varchar(50) NOT NULL',NULL),('  `contents` varchar(1000) DEFAULT NULL',NULL),('  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP',NULL),('  `status` int NOT NULL DEFAULT \'0\'',NULL),('  `starred` int NOT NULL DEFAULT \'0\'',NULL),('  `commentNumber` int NOT NULL DEFAULT \'0\'',NULL),('  `user_id` int DEFAULT NULL',NULL),('  `id` int NOT NULL AUTO_INCREMENT',NULL),('  `contents` varchar(100) NOT NULL',NULL),('  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP',NULL),('  `status` int NOT NULL DEFAULT \'0\'',NULL),('  `approve` int NOT NULL DEFAULT \'0\'',NULL),('  `commit_id` int DEFAULT NULL',NULL),('  `user_id` int DEFAULT NULL',NULL),('  `id` int NOT NULL AUTO_INCREMENT',NULL),('  `followers_id` int DEFAULT NULL',NULL),('  `following_id` int DEFAULT NULL',NULL),('  `id` int NOT NULL AUTO_INCREMENT',NULL),('  `name` varchar(10) NOT NULL',NULL),('  `status` int NOT NULL DEFAULT \'0\'',NULL),('  PRIMARY KEY (`id`)',NULL),('  `id` int NOT NULL AUTO_INCREMENT',NULL),('  `name` varchar(10) NOT NULL',NULL),('  `password` varchar(24) NOT NULL',NULL),('  `age` int DEFAULT NULL',NULL),('  `phoneNumber` int DEFAULT NULL',NULL),('  `authorization` varchar(10) NOT NULL DEFAULT \'user\'',NULL),('  `registrationTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP',NULL),('  `status` int NOT NULL DEFAULT \'0\'',NULL),('  `nickname` varchar(10) DEFAULT NULL',NULL),('  `follows` int DEFAULT \'0\'',NULL),('  `likes` int DEFAULT \'0\'',NULL),('  `Reputation` int DEFAULT \'0\'',NULL),('  `intro` varchar(200) DEFAULT NULL',NULL),('  `id` int NOT NULL AUTO_INCREMENT',NULL),('  `user_id` int DEFAULT NULL',NULL),('  `post_id` int DEFAULT NULL',NULL),('  `id` int NOT NULL AUTO_INCREMENT',NULL),('  `user_id` int DEFAULT NULL',NULL),('  `tec_id` int DEFAULT NULL',NULL);
/*!40000 ALTER TABLE `forum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `contents` varchar(1000) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` int NOT NULL DEFAULT '0',
  `starred` int NOT NULL DEFAULT '0',
  `commentNumber` int NOT NULL DEFAULT '0',
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (2,'怎么通过props修改children的样式？','111','2022-01-03 06:45:46',0,4,3,4),(3,'vue页面跳转失败','222','2022-01-03 06:45:46',0,-1,0,4),(4,'Golang 有没有类型实现速查的小诀窍','333','2022-01-03 06:45:46',0,-1,0,4),(5,'用递归判断两个嵌套数组是否相同','444','2022-01-03 06:45:46',0,0,0,4),(6,'cyb今天吃什么','555','2022-01-03 06:45:46',0,0,0,4),(7,'练习两年半的同事写的代码','666','2022-01-03 06:53:53',0,0,0,4),(8,'练习两年半的同事写的代码','777','2022-01-03 07:06:22',0,0,0,4),(9,'练习两年半的同事写的代码','888','2022-01-03 07:06:22',0,0,0,4),(10,'练习两年半的同事写的代码','999','2022-01-03 07:06:22',0,0,0,4),(11,'cyb明天吃什么','000','2022-01-03 07:06:22',0,0,0,4),(12,'cyb后天吃什么','111','2022-01-03 07:06:22',0,0,0,4);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `response`
--

DROP TABLE IF EXISTS `response`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `response` (
  `id` int NOT NULL AUTO_INCREMENT,
  `contents` varchar(100) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` int NOT NULL DEFAULT '0',
  `approve` int NOT NULL DEFAULT '0',
  `commit_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `response`
--

LOCK TABLES `response` WRITE;
/*!40000 ALTER TABLE `response` DISABLE KEYS */;
/*!40000 ALTER TABLE `response` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_follow`
--

DROP TABLE IF EXISTS `t_follow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_follow` (
  `id` int NOT NULL AUTO_INCREMENT,
  `followers_id` int DEFAULT NULL,
  `following_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_follow`
--

LOCK TABLES `t_follow` WRITE;
/*!40000 ALTER TABLE `t_follow` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_follow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `technologyStack`
--

DROP TABLE IF EXISTS `technologyStack`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `technologyStack` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `status` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `technologyStack_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `technologyStack`
--

LOCK TABLES `technologyStack` WRITE;
/*!40000 ALTER TABLE `technologyStack` DISABLE KEYS */;
INSERT INTO `technologyStack` VALUES (1,'Java',0),(2,'C++',0),(3,'Python',0),(4,'PHP',0),(5,'Rust',0),(6,'JavaScript',0),(7,'HTML',0);
/*!40000 ALTER TABLE `technologyStack` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `password` varchar(24) NOT NULL,
  `age` int DEFAULT NULL,
  `phoneNumber` int DEFAULT NULL,
  `authorization` varchar(10) NOT NULL DEFAULT 'user',
  `registrationTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` int NOT NULL DEFAULT '0',
  `nickname` varchar(30) DEFAULT NULL,
  `follows` int DEFAULT '0',
  `likes` int DEFAULT '0',
  `Reputation` int DEFAULT '0',
  `intro` varchar(200) DEFAULT NULL,
  `avatar` varchar(100) DEFAULT 'http://localhost/avatar.jpg',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (4,'cyb','123',233,10086,'root','2021-12-29 12:55:15',0,'batman',0,0,0,NULL,'http://localhost/avatar.jpg'),(5,'张三','123',33,2333,'user','2021-12-29 12:55:15',0,'333',0,0,0,NULL,'http://localhost/avatar.jpg'),(6,'李四','123',44,1008611,'user','2021-12-31 08:13:29',0,'李四',0,0,0,NULL,'http://localhost/avatar.jpg'),(7,'123','123',NULL,NULL,'user','2021-12-31 08:49:22',1,'123',0,0,0,NULL,'http://localhost/avatar.jpg'),(8,'666','123',NULL,NULL,'root','2021-12-31 09:00:24',0,'HuangMJ',0,0,0,NULL,'http://localhost/8avatar.jpg'),(9,'666666','123',NULL,NULL,'user','2022-01-06 08:06:12',0,'赵刘',0,0,0,NULL,'http://localhost/9avatar.jpg'),(10,'777','777',10,NULL,'user','2022-01-07 01:22:47',0,'Abc',0,0,0,NULL,'http://localhost/avatar.jpg'),(11,'123456','123456',NULL,NULL,'user','2022-01-07 03:13:58',0,'舒界豪',0,0,0,NULL,'http://localhost/11avatar.jpg'),(13,'DerDerTea','123456',NULL,NULL,'user','2022-01-07 06:16:43',0,'DerDerTea',0,0,0,NULL,'https://avatars.githubusercontent.com/u/71386754?v=4'),(14,'DerDerTea','123456',NULL,NULL,'user','2022-01-07 06:24:45',0,'DerDerTea',0,0,0,NULL,'https://avatars.githubusercontent.com/u/71386754?v=4');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_starP_relation`
--

DROP TABLE IF EXISTS `user_starP_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_starP_relation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `post_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_starP_relation`
--

LOCK TABLES `user_starP_relation` WRITE;
/*!40000 ALTER TABLE `user_starP_relation` DISABLE KEYS */;
INSERT INTO `user_starP_relation` VALUES (36,11,2);
/*!40000 ALTER TABLE `user_starP_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_tec_relation`
--

DROP TABLE IF EXISTS `user_tec_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_tec_relation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `tec_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_tec_relation`
--

LOCK TABLES `user_tec_relation` WRITE;
/*!40000 ALTER TABLE `user_tec_relation` DISABLE KEYS */;
INSERT INTO `user_tec_relation` VALUES (1,4,1),(5,4,6),(6,4,2);
/*!40000 ALTER TABLE `user_tec_relation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-07 14:27:25
