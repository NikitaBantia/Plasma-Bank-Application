-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: plasmabank
-- ------------------------------------------------------
-- Server version	8.0.24

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
-- Table structure for table `logtable`
--

DROP TABLE IF EXISTS `logtable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logtable` (
  `name` varchar(40) DEFAULT NULL,
  `id` int DEFAULT NULL,
  `operationName` varchar(40) DEFAULT NULL,
  `ModifiedTime` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logtable`
--

LOCK TABLES `logtable` WRITE;
/*!40000 ALTER TABLE `logtable` DISABLE KEYS */;
INSERT INTO `logtable` VALUES ('Donor',5,'Insert','2021-06-16 09:19:08'),('Hospital',5,'Insert','2021-06-18 10:04:43'),('Hospital',6,'Insert','2021-06-18 11:20:49'),('Hospital',6,'Delete','2021-06-18 11:26:42'),('Hospital',7,'Insert','2021-06-18 11:27:45'),('Hospital',7,'Delete','2021-06-18 11:30:25'),('Hospital',8,'Insert','2021-06-18 11:31:05'),('Hospital',8,'Delete','2021-06-18 12:12:16'),('Hospital',6,'Insert','2021-06-18 12:21:52'),('Hospital',7,'Insert','2021-06-18 13:03:09'),('Hospital',8,'Insert','2021-06-18 13:05:02'),('Hospital',9,'Insert','2021-06-18 13:15:54'),('Hospital',8,'Delete','2021-06-18 13:23:42'),('Hospital',6,'Delete','2021-06-18 13:23:55'),('Hospital',7,'Delete','2021-06-18 13:24:07'),('Hospital',9,'Delete','2021-06-18 13:24:19'),('Donor',6,'Insert','2021-06-21 05:46:44'),('Donor',7,'Insert','2021-06-21 05:49:09'),('Seeker',5,'Insert','2021-06-21 05:57:46'),('PlasmaBank',4,'Insert','2021-06-21 05:59:04'),('PlasmaBank',5,'Insert','2021-06-21 06:02:05'),('PlasmaBank',6,'Insert','2021-06-21 06:03:32'),('Hospital',6,'Insert','2021-06-21 06:04:10'),('Seeker',6,'Insert','2021-06-22 04:51:12'),('Seeker',4,'Delete','2021-06-22 05:01:51'),('Seeker',6,'Delete','2021-06-22 05:01:51'),('Donor',8,'Insert','2021-06-22 05:16:48'),('Seeker',6,'Insert','2021-06-22 05:19:42'),('Seeker',6,'Delete','2021-06-22 05:21:11'),('Donor',9,'Insert','2021-06-22 05:21:11'),('Seeker',7,'Insert','2021-06-22 05:24:13'),('Seeker',7,'Delete','2021-06-22 05:24:38'),('Hospital',6,'Delete','2021-06-22 05:36:51'),('Donor',6,'Delete','2021-06-22 05:37:18'),('Donor',7,'Delete','2021-06-22 05:37:18'),('Donor',8,'Delete','2021-06-22 05:37:18'),('Donor',9,'Delete','2021-06-22 05:37:18'),('PlasmaBank',4,'Delete','2021-06-22 05:39:14'),('PlasmaBank',5,'Delete','2021-06-22 05:39:14'),('PlasmaBank',6,'Delete','2021-06-22 05:39:14'),('Seeker',5,'Delete','2021-06-22 05:39:25'),('Hospital',6,'Insert','2021-06-22 05:52:35'),('Seeker',4,'Insert','2021-06-22 06:39:47'),('Donor',6,'Insert','2021-06-22 06:41:55'),('PlasmaBank',4,'Insert','2021-06-22 06:47:14'),('Donor',7,'Insert','2021-06-22 06:51:50'),('Seeker',5,'Insert','2021-06-22 06:55:58'),('Seeker',6,'Insert','2021-06-22 06:59:31'),('Seeker',7,'Insert','2021-06-22 07:06:42'),('Donor',8,'Insert','2021-06-22 10:03:15'),('Hospital',7,'Insert','2021-06-22 10:05:01'),('Seeker',8,'Insert','2021-06-22 10:06:33');
/*!40000 ALTER TABLE `logtable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-22 16:11:59
